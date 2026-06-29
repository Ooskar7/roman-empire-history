import { linkRegistry } from "../data/linkRegistry.js";

const WORD_CHARACTER_PATTERN = /[A-Za-z0-9]/;

export function autoLinkContent(content, currentPath = "", registry = linkRegistry) {
  if (!content) return "";

  const protectedRanges = getProtectedMarkdownRanges(content);
  const matches = findEntityMatches(content, registry, currentPath, protectedRanges);

  if (matches.length === 0) return content;

  return applyMatches(content, matches);
}

function findEntityMatches(content, registry, currentPath, protectedRanges) {
  const entities = registry.filter((entity) => entity.path !== currentPath);

  const entityMatches = entities
    .map((entity) => findFirstEntityMatch(content, entity, protectedRanges))
    .filter(Boolean)
    .sort((a, b) => a.start - b.start || b.text.length - a.text.length);

  const selectedMatches = [];

  for (const match of entityMatches) {
    if (!overlapsAnyRange(match.start, match.end, selectedMatches)) {
      selectedMatches.push(match);
    }
  }

  return selectedMatches;
}

function findFirstEntityMatch(content, entity, protectedRanges) {
  return getEntityTerms(entity)
    .flatMap((candidate) => findTermMatches(content, candidate, protectedRanges))
    .sort((a, b) => a.start - b.start || b.text.length - a.text.length)[0];
}

function getEntityTerms(entity) {
  const uniqueTerms = [...new Set([entity.label, ...(entity.aliases || [])])];

  return uniqueTerms
    .filter(Boolean)
    .map((term) => ({ entity, term }));
}

function findTermMatches(content, candidate, protectedRanges) {
  const pattern = new RegExp(escapeRegExp(candidate.term), "gi");
  const matches = [];
  let match;

  while ((match = pattern.exec(content)) !== null) {
    const start = match.index;
    const end = start + match[0].length;

    if (
      hasWordBoundary(content, start, end) &&
      !overlapsAnyRange(start, end, protectedRanges)
    ) {
      matches.push({
        start,
        end,
        text: match[0],
        path: candidate.entity.path,
      });
    }
  }

  return matches;
}

function applyMatches(content, matches) {
  let linkedContent = "";
  let cursor = 0;

  for (const match of matches) {
    linkedContent += content.slice(cursor, match.start);
    linkedContent += `[${match.text}](${match.path})`;
    cursor = match.end;
  }

  linkedContent += content.slice(cursor);
  return linkedContent;
}

function getProtectedMarkdownRanges(content) {
  const ranges = [
    ...findRegexRanges(content, /```[\s\S]*?```/g),
    ...findRegexRanges(content, /`[^`\n]+`/g),
    ...findRegexRanges(content, /!?\[[^\]\n]*]\([^)\n]+?\)/g),
  ];

  return ranges.sort((a, b) => a.start - b.start);
}

function findRegexRanges(content, regex) {
  const ranges = [];
  let match;

  while ((match = regex.exec(content)) !== null) {
    ranges.push({
      start: match.index,
      end: match.index + match[0].length,
    });
  }

  return ranges;
}

function overlapsAnyRange(start, end, ranges) {
  return ranges.some((range) => start < range.end && end > range.start);
}

function hasWordBoundary(content, start, end) {
  const before = content[start - 1];
  const after = content[end];

  return !isWordCharacter(before) && !isWordCharacter(after);
}

function isWordCharacter(character) {
  return character ? WORD_CHARACTER_PATTERN.test(character) : false;
}

function escapeRegExp(value) {
  return value.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
}

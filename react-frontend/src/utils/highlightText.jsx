export function highlightText(text, query) {
  if (!query || !query.trim()) return text;

  const escapedQuery = query.replace(/[.*+?^${}()|[\]\\]/g, "\\$&");
  const regex = new RegExp(`(${escapedQuery})`, "gi");
  const parts = text.split(regex);

  return parts.map((part, index) =>
    regex.test(part) ? (
      <mark key={index} className="highlight-mark">
        {part}
      </mark>
    ) : (
      part
    )
  );
}

export function formatYear(year) {
  if (year === null || year === undefined) return "Unknown";
  if (year < 0) {
    return `${Math.abs(year)} BC`;
  }
  return `${year} AD`;
}

export function formatYearRange(startYear, endYear) {
  return `${formatYear(startYear)} to ${formatYear(endYear)}`;
}

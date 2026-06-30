export function formatHistoricalYear(year) {
  if (year < 0) {
    return `${Math.abs(year)} BC`;
  }

  return `${year} AD`;
}

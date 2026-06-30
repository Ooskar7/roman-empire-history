function HistoricalMapLegend() {
  return (
    <section className="historical-map-legend card" aria-label="Map legend">
      <h2>Legend</h2>
      <div className="historical-legend-items">
        <div className="historical-legend-item">
          <span className="legend-swatch legend-swatch-rome" />
          <span>Roman-controlled territory</span>
        </div>
        <div className="historical-legend-item">
          <span className="legend-swatch legend-swatch-influence" />
          <span>Roman influence or allied regions</span>
        </div>
        <div className="historical-legend-item">
          <span className="legend-swatch legend-swatch-frontier" />
          <span>Frontier or contested borderlands</span>
        </div>
      </div>
    </section>
  );
}

export default HistoricalMapLegend;

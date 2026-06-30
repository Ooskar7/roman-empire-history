import { formatHistoricalYear } from "../../utils/historicalYearUtils";

function HistoricalMapInfoPanel({ stage }) {
  return (
    <aside className="historical-info-panel card">
      <p className="historical-eyebrow">{formatHistoricalYear(stage.year)}</p>
      <h2>{stage.title}</h2>
      <p>{stage.description}</p>

      <div className="historical-info-block">
        <h3>Roman Status</h3>
        <p>{stage.romanStatus}</p>
      </div>

      <div className="historical-info-block">
        <h3>Key Regions</h3>
        <ul className="historical-region-list">
          {stage.keyRegions.map((region) => (
            <li key={region}>{region}</li>
          ))}
        </ul>
      </div>
    </aside>
  );
}

export default HistoricalMapInfoPanel;

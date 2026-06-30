import { formatHistoricalYear } from "../../utils/historicalYearUtils";

function HistoricalTimelineSlider({ stages, selectedIndex, onStageChange }) {
  const selectedStage = stages[selectedIndex];

  return (
    <section className="historical-timeline card" aria-label="Historical map timeline">
      <div className="historical-timeline-header">
        <div>
          <p className="historical-eyebrow">Timeline</p>
          <h2>{selectedStage.title}</h2>
        </div>
        <span className="historical-year-badge">
          {formatHistoricalYear(selectedStage.year)}
        </span>
      </div>

      <label htmlFor="historical-map-stage" className="search-label">
        Move through Roman territorial history
      </label>
      <input
        id="historical-map-stage"
        type="range"
        min="0"
        max={stages.length - 1}
        value={selectedIndex}
        onChange={(event) => onStageChange(Number(event.target.value))}
        className="historical-slider"
        aria-valuetext={`${selectedStage.label}: ${selectedStage.title}`}
      />

      <div className="historical-timeline-marks" aria-hidden="true">
        {stages.map((stage) => (
          <span key={stage.id}>{stage.label}</span>
        ))}
      </div>
    </section>
  );
}

export default HistoricalTimelineSlider;

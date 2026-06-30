import { useState } from "react";

function HistoricalMapViewer({ stage }) {
  const [failedImage, setFailedImage] = useState("");
  const imageFailed = failedImage === stage.image;

  return (
    <section className="historical-map-viewer card" aria-label="Historical map">
      <div className="historical-map-frame">
        {imageFailed ? (
          <div className="historical-map-placeholder" role="img" aria-label="Map image unavailable">
            <span className="historical-map-placeholder-year">{stage.label}</span>
            <h2>{stage.title}</h2>
            <p>
              Map artwork for this stage has not been added yet. The political
              context below remains available for exploration.
            </p>
          </div>
        ) : (
          <img
            src={stage.image}
            alt={`Historical political map of Rome in ${stage.label}: ${stage.title}`}
            className="historical-map-image"
            onError={() => setFailedImage(stage.image)}
          />
        )}
      </div>
    </section>
  );
}

export default HistoricalMapViewer;

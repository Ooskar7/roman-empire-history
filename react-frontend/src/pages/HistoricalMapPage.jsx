import { useState } from "react";
import { Link } from "react-router-dom";
import HistoricalMapInfoPanel from "../components/HistoricalMap/HistoricalMapInfoPanel";
import HistoricalMapLegend from "../components/HistoricalMap/HistoricalMapLegend";
import HistoricalMapViewer from "../components/HistoricalMap/HistoricalMapViewer";
import HistoricalTimelineSlider from "../components/HistoricalMap/HistoricalTimelineSlider";
import Layout from "../components/Layout";
import { historicalMapStages } from "../data/historicalMapStages";

function HistoricalMapPage() {
  const [selectedStageIndex, setSelectedStageIndex] = useState(0);
  const selectedStage = historicalMapStages[selectedStageIndex];

  return (
    <Layout
      title="Historical Political Map"
      subtitle="Explore Rome's territorial changes from the foundation of the city to the fall of the Western Empire."
      backgroundImage="/images/backgrounds/map_117ad_background.png"
    >
      <Link to="/" className="button-link secondary-button">
        Back to Home
      </Link>

      <div className="historical-map-page">
        <HistoricalTimelineSlider
          stages={historicalMapStages}
          selectedIndex={selectedStageIndex}
          onStageChange={setSelectedStageIndex}
        />

        <div className="historical-map-layout">
          <HistoricalMapViewer stage={selectedStage} />
          <HistoricalMapInfoPanel stage={selectedStage} />
        </div>

        <HistoricalMapLegend />
      </div>
    </Layout>
  );
}

export default HistoricalMapPage;

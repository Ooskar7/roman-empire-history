import { Link } from "react-router-dom";
import Layout from "../components/Layout";

function HomePage() {
  return (
    <Layout
      title="Roman Empire History"
      subtitle="Explore the history of Rome from the Monarchy to the Empire."
      backgroundImage="/images/backgrounds/map_117ad_background.png"
    >
      <div className="card">
        <h2>Welcome</h2>
        <p>
          This React version of the project presents the main historical periods
          of ancient Rome and their important events.
        </p>

        <Link to="/periods" className="button-link">
          View Historical Periods
        </Link>
      </div>

      <div className="cards-container home-feature-grid">
        <div className="card home-feature-card">
          <h2>Historical Political Map</h2>
          <p>
            Explore how Roman territory changed from the city's foundation to the
            fall of the Western Roman Empire.
          </p>
          <Link to="/historical-map" className="button-link">
            Open Historical Political Map
          </Link>
        </div>
      </div>
    </Layout>
  );
}

export default HomePage;

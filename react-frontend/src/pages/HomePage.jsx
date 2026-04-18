import { Link } from "react-router-dom";
import Layout from "../components/Layout";

function HomePage() {
  return (
    <Layout
      title="Roman Empire History"
      subtitle="Explore the history of Rome from the Monarchy to the Empire."
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
    </Layout>
  );
}

export default HomePage;

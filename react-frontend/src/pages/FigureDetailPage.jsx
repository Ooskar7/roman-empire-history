import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import Layout from "../components/Layout";
import LoadingMessage from "../components/LoadingMessage";
import ErrorMessage from "../components/ErrorMessage";
import { formatYearRange } from "../utils/formatters";
import { getFigureById, getPeriodById } from "../api/periodApi";

function FigureDetailPage() {
  const { id } = useParams();

  const [figure, setFigure] = useState(null);
  const [period, setPeriod] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchFigureDetails() {
      try {
        const figureData = await getFigureById(id);
        setFigure(figureData);

        const periodData = await getPeriodById(figureData.periodId);
        setPeriod(periodData);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    }

    fetchFigureDetails();
  }, [id]);

  return (
    <Layout
      title="Roman Figure Detail"
      subtitle="Discover an important person in Roman history."
    >
      <Link to="/periods" className="button-link secondary-button">
        Back to Periods
      </Link>

      {period && (
        <Link to={`/period/${period.id}`} className="button-link secondary-button">
          Back to {period.name}
        </Link>
      )}

      {loading && <LoadingMessage message="Loading figure details..." />}
      {error && <ErrorMessage message={error} />}

      {!loading && !error && figure && (
        <div className="card">
          <h2>{figure.name}</h2>

          <p>
            <strong>Years:</strong>{" "}
            {formatYearRange(figure.birthYear, figure.deathYear)}
          </p>

          <p>
            <strong>Role:</strong> {figure.role}
          </p>

          {period && (
            <p>
              <strong>Historical Period:</strong> {period.name}
            </p>
          )}

          {figure.imageUrl && (
            <img
              src={figure.imageUrl}
              alt={figure.name}
              className="figure-image"
            />
          )}

          <p>{figure.longDescription}</p>
        </div>
      )}
    </Layout>
  );
}

export default FigureDetailPage;

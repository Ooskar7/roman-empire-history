import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import Layout from "../components/Layout";
import LoadingMessage from "../components/LoadingMessage";
import ErrorMessage from "../components/ErrorMessage";
import { formatYear } from "../utils/formatters";
import { getEventById, getPeriodById } from "../api/periodApi";

function EventDetailPage() {
  const { id } = useParams();

  const [event, setEvent] = useState(null);
  const [period, setPeriod] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchEventDetails() {
      try {
        const eventData = await getEventById(id);
        setEvent(eventData);

        const periodData = await getPeriodById(eventData.periodId);
        setPeriod(periodData);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    }

    fetchEventDetails();
  }, [id]);

  return (
    <Layout
      title="Roman Event Detail"
      subtitle="Discover an important event in Roman history."
    >
      <Link to="/periods" className="button-link secondary-button">
        Back to Periods
      </Link>

      {period && (
        <Link to={`/period/${period.id}`} className="button-link secondary-button">
          Back to {period.name}
        </Link>
      )}

      {loading && <LoadingMessage message="Loading event details..." />}
      {error && <ErrorMessage message={error} />}

      {!loading && !error && event && (
        <div className="card">
          <h2>{event.title}</h2>

          <p>
            <strong>Year:</strong> {formatYear(event.year)}
          </p>

          <p>
            <strong>Location:</strong> {event.location}
          </p>

          {period && (
            <p>
              <strong>Historical Period:</strong> {period.name}
            </p>
          )}

          {event.imageUrl && (
            <img
              src={event.imageUrl}
              alt={event.title}
              className="detail-image"
            />
          )}

          <p>{event.longDescription}</p>
        </div>
      )}
    </Layout>
  );
}

export default EventDetailPage;

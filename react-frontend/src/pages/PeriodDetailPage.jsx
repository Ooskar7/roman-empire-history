import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import Layout from "../components/Layout";
import EventCard from "../components/EventCard";
import FigureCard from "../components/FigureCard";
import LoadingMessage from "../components/LoadingMessage";
import ErrorMessage from "../components/ErrorMessage";
import { formatYear } from "../utils/formatters";
import {
  getPeriodById,
  getEventsByPeriodId,
  getFiguresByPeriodId,
} from "../api/periodApi";

function PeriodDetailPage() {
  const { id } = useParams();

  const [period, setPeriod] = useState(null);
  const [events, setEvents] = useState([]);
  const [figures, setFigures] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");
  const [eventSearchTerm, setEventSearchTerm] = useState("");

  useEffect(() => {
    async function fetchPeriodDetails() {
      try {
        const [periodData, eventsData, figuresData] = await Promise.all([
          getPeriodById(id),
          getEventsByPeriodId(id),
          getFiguresByPeriodId(id),
        ]);

        setPeriod(periodData);
        setEvents(eventsData);
        setFigures(figuresData);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    }

    fetchPeriodDetails();
  }, [id]);

  const normalizedSearch = eventSearchTerm.trim().toLowerCase();

  const filteredEvents = events
    .map((event) => ({
      ...event,
      score: getLocalEventSearchScore(event, normalizedSearch),
    }))
    .filter((event) => normalizedSearch === "" || event.score > 0)
    .sort((a, b) => b.score - a.score || a.year - b.year);

  return (
    <Layout
      title="Roman Period Detail"
      subtitle="Learn more about a specific historical period of ancient Rome."
    >
      <Link to="/periods" className="button-link secondary-button">
        Back to Periods
      </Link>

      {loading && <LoadingMessage message="Loading period details..." />}
      {error && <ErrorMessage message={error} />}

      {!loading && !error && period && (
        <>
          <div className="card">
            <h2>{period.name}</h2>
            <p>
              <strong>Years:</strong> {formatYear(period.startYear)} to{" "}
              {formatYear(period.endYear)}
            </p>
            <p>
              <strong>Capital:</strong> {period.capital}
            </p>
            <p>
              <strong>Government Type:</strong> {period.governmentType}
            </p>
            <p>
              <strong>Key Figure:</strong> {period.keyFigure}
            </p>
            <p>{period.description}</p>
          </div>

          <section className="events-section">
            <h2>Important Events</h2>

            <div className="search-box">
              <label htmlFor="event-search" className="search-label">
                Search events in this period
              </label>
              <input
                id="event-search"
                type="text"
                placeholder="Try: kings, rome, 509, law, caesar..."
                value={eventSearchTerm}
                onChange={(event) => setEventSearchTerm(event.target.value)}
                className="search-input"
              />
            </div>

            <p className="results-info">
              Showing {filteredEvents.length} of {events.length} events
            </p>

            {filteredEvents.length === 0 ? (
              <p>No events match your search in this period.</p>
            ) : (
              <div className="cards-container">
                {filteredEvents.map((event) => (
                  <EventCard
                    key={event.id}
                    event={event}
                    searchTerm={eventSearchTerm}
                  />
                ))}
              </div>
            )}
          </section>

          <section className="events-section">
            <h2>Important Figures</h2>

            {figures.length === 0 ? (
              <p>No figures available for this period.</p>
            ) : (
              <div className="cards-container">
                {figures.map((figure) => (
                  <FigureCard key={figure.id} figure={figure} />
                ))}
              </div>
            )}
          </section>
        </>
      )}
    </Layout>
  );
}

function getLocalEventSearchScore(event, query) {
  if (!query) return 1;

  let score = 0;

  const title = event.title.toLowerCase();
  const shortDescription = event.shortDescription.toLowerCase();
  const longDescription = event.longDescription.toLowerCase();
  const location = event.location.toLowerCase();
  const year = String(event.year);

  if (title === query) score += 100;
  if (title.includes(query)) score += 70;

  if (location.includes(query)) score += 30;
  if (shortDescription.includes(query)) score += 25;
  if (longDescription.includes(query)) score += 15;
  if (year.includes(query)) score += 20;

  return score;
}

export default PeriodDetailPage;

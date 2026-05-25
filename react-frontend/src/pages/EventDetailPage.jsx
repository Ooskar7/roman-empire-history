import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import ReactMarkdown from "react-markdown";
import Layout from "../components/Layout";
import LoadingMessage from "../components/LoadingMessage";
import ErrorMessage from "../components/ErrorMessage";
import ClickableImage from "../components/ClickableImage";
import { formatYear } from "../utils/formatters";
import { getEventById, getPeriodById } from "../api/periodApi";

function EventDetailPage() {
  const { id } = useParams();

  const [event, setEvent] = useState(null);
  const [period, setPeriod] = useState(null);
  const [markdownContent, setMarkdownContent] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    async function fetchEventDetails() {
      try {
        const eventResponse = await getEventById(id);

        setEvent(eventResponse.event);
        setMarkdownContent(eventResponse.markdownContent);

        const periodData = await getPeriodById(eventResponse.event.periodId);
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
      backgroundImage="/images/backgrounds/map_117ad_background.png"
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
        <article className="article-card">
          <header className="article-header">
            <h1>{event.title}</h1>

            <div className="article-meta">
              <span>{formatYear(event.year)}</span>
              <span>{event.location}</span>
              {period && <span>{period.name}</span>}
            </div>

            {event.imageUrl && (
              <ClickableImage
                src={event.imageUrl}
                alt={event.title}
                imageClassName="article-hero-image"
              />
            )}
          </header>

          <div className="markdown-article">
            <ReactMarkdown
              components={{
                img: (props) => (
                  <ClickableImage
                    {...props}
                    alt={props.alt || "Article image"}
                    imageClassName="markdown-image"
                    loading="lazy"
                  />
                ),
                a: (props) => (
                  <a {...props} target="_blank" rel="noreferrer" />
                ),
              }}
            >
              {markdownContent}
            </ReactMarkdown>
          </div>
        </article>
      )}
    </Layout>
  );
}

export default EventDetailPage;

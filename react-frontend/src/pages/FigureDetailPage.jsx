import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";
import Layout from "../components/Layout";
import LoadingMessage from "../components/LoadingMessage";
import ErrorMessage from "../components/ErrorMessage";
import ClickableImage from "../components/ClickableImage";
import ArticleRenderer from "../components/ArticleRenderer";
import { formatYearRange } from "../utils/formatters";
import { getFigureById, getPeriodById } from "../api/periodApi";

function FigureDetailPage() {
  const { id } = useParams();

  const [figure, setFigure] = useState(null);
  const [period, setPeriod] = useState(null);
  const [markdownContent, setMarkdownContent] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

    useEffect(() => {
      async function fetchFigureDetails() {
        try {
          const figureResponse = await getFigureById(id);

          setFigure(figureResponse.figure);
          setMarkdownContent(figureResponse.markdownContent);


          const periodData = await getPeriodById(figureResponse.figure.periodId);
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

      {loading && <LoadingMessage message="Loading figure details..." />}
      {error && <ErrorMessage message={error} />}

      {!loading && !error && figure && (
        <article className="article-card">
          <header className="article-header">
            <h1>{figure.name}</h1>

            <div className="article-meta">
              <span>{formatYearRange(figure.birthYear, figure.deathYear)}</span>
              {period && <span>{period.name}</span>}
            </div>

            {figure.imageUrl && (
              <ClickableImage
                src={figure.imageUrl}
                alt={figure.name}
                imageClassName="article-hero-image"
              />
            )}
          </header>

          <ArticleRenderer content={markdownContent} currentPath={`/figure/${id}`} />
        </article>
      )}
    </Layout>
  );
}

export default FigureDetailPage;

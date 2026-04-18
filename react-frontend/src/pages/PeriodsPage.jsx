import { useEffect, useMemo, useState } from "react";
import { Link } from "react-router-dom";
import Layout from "../components/Layout";
import PeriodCard from "../components/PeriodCard";
import EventCard from "../components/EventCard";
import LoadingMessage from "../components/LoadingMessage";
import ErrorMessage from "../components/ErrorMessage";
import { getAllPeriods, getAllEvents } from "../api/periodApi";

function PeriodsPage() {
  const [periods, setPeriods] = useState([]);
  const [events, setEvents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const [searchTerm, setSearchTerm] = useState("");
  const [selectedGovernmentType, setSelectedGovernmentType] = useState("all");
  const [selectedLocation, setSelectedLocation] = useState("all");
  const [selectedYearRange, setSelectedYearRange] = useState("all");

  useEffect(() => {
    async function fetchData() {
      try {
        const [periodsData, eventsData] = await Promise.all([
          getAllPeriods(),
          getAllEvents(),
        ]);

        setPeriods(periodsData);
        setEvents(eventsData);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    }

    fetchData();
  }, []);

  const normalizedSearch = searchTerm.trim().toLowerCase();
  const hasSearch = normalizedSearch !== "";

  const governmentTypes = useMemo(() => {
    return [...new Set(periods.map((period) => period.governmentType))];
  }, [periods]);

  const locations = useMemo(() => {
    return [...new Set(events.map((event) => event.location))].sort();
  }, [events]);

  const matchedPeriods = periods
    .filter((period) => {
      if (
        selectedGovernmentType !== "all" &&
        period.governmentType !== selectedGovernmentType
      ) {
        return false;
      }

      if (!matchesYearRange(period.startYear, period.endYear, selectedYearRange)) {
        return false;
      }

      return true;
    })
    .map((period) => ({
      ...period,
      score: getPeriodSearchScore(period, normalizedSearch),
    }))
    .filter((period) => !hasSearch || period.score > 0)
    .sort((a, b) => b.score - a.score || a.startYear - b.startYear);

  const matchedEvents = hasSearch
    ? events
        .filter((event) => {
          if (selectedLocation !== "all" && event.location !== selectedLocation) {
            return false;
          }

          if (!matchesSingleYearRange(event.year, selectedYearRange)) {
            return false;
          }

          return true;
        })
        .map((event) => {
          const relatedPeriod = periods.find((period) => period.id === event.periodId);

          return {
            ...event,
            relatedPeriod,
            score: getEventSearchScore(event, relatedPeriod, normalizedSearch),
          };
        })
        .filter((event) => event.score > 0)
        .sort((a, b) => b.score - a.score || a.year - b.year)
    : [];

  return (
    <Layout
      title="Roman Periods and Events"
      subtitle="Search across the main periods of Roman history and their important events."
    >
      <Link to="/" className="button-link secondary-button">
        Back to Home
      </Link>

      <div className="search-box">
        <label htmlFor="global-search" className="search-label">
          Search Roman history
        </label>
        <input
          id="global-search"
          type="text"
          placeholder="Try: monarchy, augustus, rome, 509, caesar, ravenna..."
          value={searchTerm}
          onChange={(event) => setSearchTerm(event.target.value)}
          className="search-input"
        />
      </div>

      <div className="filters-row">
        <div className="filter-group">
          <label htmlFor="government-filter" className="search-label">
            Period type
          </label>
          <select
            id="government-filter"
            value={selectedGovernmentType}
            onChange={(event) => setSelectedGovernmentType(event.target.value)}
            className="filter-select"
          >
            <option value="all">All period types</option>
            {governmentTypes.map((type) => (
              <option key={type} value={type}>
                {type}
              </option>
            ))}
          </select>
        </div>

        <div className="filter-group">
          <label htmlFor="location-filter" className="search-label">
            Event location
          </label>
          <select
            id="location-filter"
            value={selectedLocation}
            onChange={(event) => setSelectedLocation(event.target.value)}
            className="filter-select"
          >
            <option value="all">All locations</option>
            {locations.map((location) => (
              <option key={location} value={location}>
                {location}
              </option>
            ))}
          </select>
        </div>

        <div className="filter-group">
          <label htmlFor="year-range-filter" className="search-label">
            Year range
          </label>
          <select
            id="year-range-filter"
            value={selectedYearRange}
            onChange={(event) => setSelectedYearRange(event.target.value)}
            className="filter-select"
          >
            <option value="all">All years</option>
            <option value="early-rome">Before 500 BC</option>
            <option value="late-republic">500 BC to 1 BC</option>
            <option value="imperial">1 AD to 500 AD</option>
          </select>
        </div>
      </div>

      {loading && <LoadingMessage message="Loading periods and events..." />}
      {error && <ErrorMessage message={error} />}

      {!loading && !error && (
        <>
          <div className="results-summary">
            <p className="results-info">
              {hasSearch
                ? `Found ${matchedPeriods.length} matching periods and ${matchedEvents.length} matching events`
                : `Showing ${matchedPeriods.length} periods`}
            </p>
          </div>

          <section className="results-section">
            <h2>{hasSearch ? "Matching Periods" : "Filtered Periods"}</h2>

            {matchedPeriods.length === 0 ? (
              <p>No periods match your current search and filters.</p>
            ) : (
              <div className="cards-container">
                {matchedPeriods.map((period) => (
                  <PeriodCard
                    key={period.id}
                    period={period}
                    searchTerm={searchTerm}
                  />
                ))}
              </div>
            )}
          </section>

          {hasSearch && (
            <section className="results-section">
              <h2>Matching Events</h2>

              {matchedEvents.length === 0 ? (
                <p>No events match your current search and filters.</p>
              ) : (
                <div className="cards-container">
                  {matchedEvents.map((event) => (
                    <div key={event.id} className="event-search-wrapper">
                      <EventCard event={event} searchTerm={searchTerm} />
                      {event.relatedPeriod && (
                        <p className="related-period-text">
                          <strong>Period:</strong> {event.relatedPeriod.name}
                        </p>
                      )}
                    </div>
                  ))}
                </div>
              )}
            </section>
          )}
        </>
      )}
    </Layout>
  );
}

function getPeriodSearchScore(period, query) {
  if (!query) return 1;

  let score = 0;

  const name = period.name.toLowerCase();
  const description = period.description.toLowerCase();
  const governmentType = period.governmentType.toLowerCase();
  const keyFigure = period.keyFigure.toLowerCase();
  const capital = period.capital.toLowerCase();

  if (name === query) score += 100;
  if (name.includes(query)) score += 60;

  if (governmentType === query) score += 50;
  if (governmentType.includes(query)) score += 30;

  if (keyFigure.includes(query)) score += 25;
  if (capital.includes(query)) score += 20;
  if (description.includes(query)) score += 10;

  if (String(period.startYear).includes(query)) score += 8;
  if (String(period.endYear).includes(query)) score += 8;

  return score;
}

function getEventSearchScore(event, relatedPeriod, query) {
  if (!query) return 0;

  let score = 0;

  const title = event.title.toLowerCase();
  const shortDescription = event.shortDescription.toLowerCase();
  const longDescription = event.longDescription.toLowerCase();
  const location = event.location.toLowerCase();
  const year = String(event.year);
  const periodName = relatedPeriod ? relatedPeriod.name.toLowerCase() : "";

  if (title === query) score += 100;
  if (title.includes(query)) score += 70;

  if (location === query) score += 50;
  if (location.includes(query)) score += 35;

  if (shortDescription.includes(query)) score += 25;
  if (longDescription.includes(query)) score += 15;
  if (periodName.includes(query)) score += 20;
  if (year.includes(query)) score += 20;

  return score;
}

function matchesYearRange(startYear, endYear, range) {
  if (range === "all") return true;

  if (range === "early-rome") {
    return endYear <= -500;
  }

  if (range === "late-republic") {
    return startYear <= -1 && endYear >= -500;
  }

  if (range === "imperial") {
    return endYear >= 1;
  }

  return true;
}

function matchesSingleYearRange(year, range) {
  if (range === "all") return true;

  if (range === "early-rome") {
    return year <= -500;
  }

  if (range === "late-republic") {
    return year >= -500 && year <= -1;
  }

  if (range === "imperial") {
    return year >= 1;
  }

  return true;
}

export default PeriodsPage;

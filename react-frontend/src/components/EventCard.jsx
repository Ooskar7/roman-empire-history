import { Link } from "react-router-dom";
import { formatYear } from "../utils/formatters";
import { highlightText } from "../utils/highlightText";

function EventCard({ event, searchTerm = "" }) {
  return (
    <div className="card">
      <h3>{highlightText(event.title, searchTerm)}</h3>

      {event.imageUrl && (
        <img
          src={event.imageUrl}
          alt={event.title}
          className="card-image"
        />
      )}

      <p>
        <strong>Year:</strong> {formatYear(event.year)}
      </p>
      <p>{highlightText(event.shortDescription, searchTerm)}</p>
      <p>
        <strong>Location:</strong> {highlightText(event.location, searchTerm)}
      </p>

      <Link to={`/event/${event.id}`} className="button-link">
        Read more
      </Link>
    </div>
  );
}

export default EventCard;

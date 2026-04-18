import { Link } from "react-router-dom";
import { formatYearRange } from "../utils/formatters";
import { highlightText } from "../utils/highlightText";

function FigureCard({ figure, searchTerm = "" }) {
  return (
    <div className="card">
      <h3>{highlightText(figure.name, searchTerm)}</h3>

      {figure.imageUrl && (
        <img
          src={figure.imageUrl}
          alt={figure.name}
          className="card-image"
        />
      )}

      <p>
        <strong>Years:</strong>{" "}
        {formatYearRange(figure.birthYear, figure.deathYear)}
      </p>

      <p>
        <strong>Role:</strong> {highlightText(figure.role, searchTerm)}
      </p>

      <p>{highlightText(figure.shortDescription, searchTerm)}</p>

      <Link to={`/figure/${figure.id}`} className="button-link">
        Read more
      </Link>
    </div>
  );
}

export default FigureCard;

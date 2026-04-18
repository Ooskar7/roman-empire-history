import { Link } from "react-router-dom";
import { formatYear } from "../utils/formatters";
import { highlightText } from "../utils/highlightText";

function PeriodCard({ period, searchTerm = "" }) {
  return (
    <div className="card">
      <h2>{highlightText(period.name, searchTerm)}</h2>
      <p>
        <strong>Years:</strong> {formatYear(period.startYear)} to{" "}
        {formatYear(period.endYear)}
      </p>
      <p>{highlightText(period.description, searchTerm)}</p>

      <p>
        <strong>Government Type:</strong>{" "}
        {highlightText(period.governmentType, searchTerm)}
      </p>

      <p>
        <strong>Capital:</strong> {highlightText(period.capital, searchTerm)}
      </p>

      <p>
        <strong>Key Figure:</strong> {highlightText(period.keyFigure, searchTerm)}
      </p>

      <Link to={`/period/${period.id}`} className="button-link">
        View details
      </Link>
    </div>
  );
}

export default PeriodCard;

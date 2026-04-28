const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;

const PERIODS_BASE_URL = `${API_BASE_URL}/periods`;
const EVENTS_BASE_URL = `${API_BASE_URL}/events`;
const FIGURES_BASE_URL = `${API_BASE_URL}/figures`;

export async function getAllPeriods() {
  const response = await fetch(PERIODS_BASE_URL);

  if (!response.ok) {
    throw new Error("Failed to fetch periods.");
  }

  return response.json();
}

export async function getPeriodById(id) {
  const response = await fetch(`${PERIODS_BASE_URL}/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch period details.");
  }

  return response.json();
}

export async function getEventsByPeriodId(id) {
  const response = await fetch(`${PERIODS_BASE_URL}/${id}/events`);

  if (!response.ok) {
    throw new Error("Failed to fetch period events.");
  }

  return response.json();
}

export async function getFiguresByPeriodId(id) {
  const response = await fetch(`${PERIODS_BASE_URL}/${id}/figures`);

  if (!response.ok) {
    throw new Error("Failed to fetch period figures.");
  }

  return response.json();
}

export async function getAllEvents() {
  const response = await fetch(EVENTS_BASE_URL);

  if (!response.ok) {
    throw new Error("Failed to fetch events.");
  }

  return response.json();
}

export async function getEventById(id) {
  const response = await fetch(`${EVENTS_BASE_URL}/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch event details.");
  }

  return response.json();
}

export async function getAllFigures() {
  const response = await fetch(FIGURES_BASE_URL);

  if (!response.ok) {
    throw new Error("Failed to fetch figures.");
  }

  return response.json();
}

export async function getFigureById(id) {
  const response = await fetch(`${FIGURES_BASE_URL}/${id}`);

  if (!response.ok) {
    throw new Error("Failed to fetch figure details.");
  }

  return response.json();
}

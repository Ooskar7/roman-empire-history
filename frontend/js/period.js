const API_BASE_URL = "http://localhost:8080/api/periods";

async function loadPeriodPage() {
    const detailContainer = document.getElementById("period-detail-container");
    const eventsContainer = document.getElementById("events-container");

    const params = new URLSearchParams(window.location.search);
    const id = params.get("id");

    if (!id) {
        detailContainer.innerHTML = `<p class="error-message">No period ID was provided in the URL.</p>`;
        eventsContainer.innerHTML = "";
        return;
    }

    try {
        const [periodResponse, eventsResponse] = await Promise.all([
            fetch(`${API_BASE_URL}/${id}`),
            fetch(`${API_BASE_URL}/${id}/events`)
        ]);

        if (!periodResponse.ok) {
            throw new Error("Failed to fetch period details from the server.");
        }

        if (!eventsResponse.ok) {
            throw new Error("Failed to fetch period events from the server.");
        }

        const period = await periodResponse.json();
        const events = await eventsResponse.json();

        renderPeriodDetails(period, detailContainer);
        renderEvents(events, eventsContainer);

    } catch (error) {
        detailContainer.innerHTML = `<p class="error-message">${error.message}</p>`;
        eventsContainer.innerHTML = "";
        console.error("Error loading period page:", error);
    }
}

function renderPeriodDetails(period, container) {
    container.innerHTML = `
        <h2>${period.name}</h2>
        <p><strong>Years:</strong> ${formatYear(period.startYear)} to ${formatYear(period.endYear)}</p>
        <p><strong>Capital:</strong> ${period.capital}</p>
        <p><strong>Government Type:</strong> ${period.governmentType}</p>
        <p><strong>Key Figure:</strong> ${period.keyFigure}</p>
        <p>${period.description}</p>
    `;
}

function renderEvents(events, container) {
    if (events.length === 0) {
        container.innerHTML = `<p>No events available for this period.</p>`;
        return;
    }

    container.innerHTML = "";

    events.forEach(event => {
        const card = document.createElement("div");
        card.classList.add("event-card");

        card.innerHTML = `
            <h3>${event.title}</h3>
            <p><strong>Year:</strong> ${formatYear(event.year)}</p>
            <p>${event.description}</p>
        `;

        container.appendChild(card);
    });
}

function formatYear(year) {
    if (year < 0) {
        return `${Math.abs(year)} BC`;
    }
    return `${year} AD`;
}

loadPeriodPage();

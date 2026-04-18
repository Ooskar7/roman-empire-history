const API_URL = "http://localhost:8080/api/periods";

async function loadPeriods() {
    const container = document.getElementById("periods-container");

    try {
        const response = await fetch(API_URL);

        if (!response.ok) {
            throw new Error("Failed to fetch periods from the server.");
        }

        const periods = await response.json();

        container.innerHTML = "";

        periods.forEach(period => {
            const card = document.createElement("div");
            card.classList.add("period-card");

            card.innerHTML = `
                <h3>${period.name}</h3>
                <p><strong>Years:</strong> ${formatYear(period.startYear)} to ${formatYear(period.endYear)}</p>
                <p>${period.description}</p>
                <a class="button-link" href="period.html?id=${period.id}">View details</a>
            `;

            container.appendChild(card);
        });
    } catch (error) {
        container.innerHTML = `<p class="error-message">${error.message}</p>`;
        console.error("Error loading periods:", error);
    }
}

function formatYear(year) {
    if (year < 0) {
        return `${Math.abs(year)} BC`;
    }
    return `${year} AD`;
}

loadPeriods();

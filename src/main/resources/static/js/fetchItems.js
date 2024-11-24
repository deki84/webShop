// API-Endpunkt
const apiUrl = "http://localhost:8080/api/items";

// Funktion: Daten von API abrufen
async function fetchItems() {
    try {
        const response = await fetch(apiUrl);
        if (!response.ok) {
            throw new Error("Fehler beim Abrufen der Daten!");
        }
        const items = await response.json();

        // Items anzeigen
        const container = document.getElementById("items-container");
        items.forEach(item => {
            const itemDiv = document.createElement("div");
            itemDiv.innerHTML = `
                <h3>${item.name}</h3>
                <p>Quantity: ${item.quantity}</p>
                <p>Price: ${item.price.toFixed(2)} €</p>
            `;
            container.appendChild(itemDiv);
        });
    } catch (error) {
        console.error("Fehler:", error);
    }
}

// Daten laden, wenn die Seite geladen wird
fetchItems();

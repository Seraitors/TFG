// This is a public sample test API key.
// Don’t submit any personally identifiable information in requests made with this key.
// Sign in to see your own test API key embedded in code samples.
console.log("hola")

// script.js

// Initialize Stripe.js



// Fetch Checkout Session and retrieve the client secret

fetch("/api/create-checkout-session", {
    method: "POST",
    headers: {
        "Content-Type": "application/json"
    },
    body: JSON.stringify({}) // Puedes enviar datos en el cuerpo si es necesario
})
    .then(response => response.json())
    .then(data => {
        const stripe = Stripe("pk_test_51PMaMmEU6FtnP23OvWcrCbFimaRvuLTiuDYgWqwAe5g69wTwZii9AuQi5WAR8io63FOdTdw1MfSS8piqWASmu6X900afNsbBt5");
        stripe.redirectToCheckout({ sessionId: data.sessionId });
    });
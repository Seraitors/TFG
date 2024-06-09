// Función para obtener la cookie
function getCookie(name) {
    const cookieArr = document.cookie.split(';');
    for (let i = 0; i < cookieArr.length; i++) {
        const cookiePair = cookieArr[i].split('=');
        if (name == cookiePair[0].trim()) {
            return JSON.parse(cookiePair[1]);
        }
    }
    return [];
}



// Función para pintar el resumen del carrito


function pintarCarrito() {
    const carritoResumen = document.getElementById('carrito-resumen');
    const carrito = getCookie('cartItems');
    const userLogCookie = getCookie('user-log');

    if (userLogCookie.length !== 0) {
        let carritoUser = carrito[userLogCookie];

        if (carritoUser.length === 0) {
            carritoResumen.innerHTML = '<p>El carrito está vacío</p>';
            return;
        }

        let total = 0;
        let html = '<h2>Resumen del Carrito</h2><ul>';
        carritoUser.forEach(item => {
            html += `<li>${item.name} - $${item.price.toFixed(2)}</li>`;
            total += item.price;
        });
        html += '</ul>';

        const iva = total * 0.21;
        const totalMasIva = total + iva;

        html += `<p>Total: $${total.toFixed(2)}</p>`;
        html += `<p>Total + IVA (21%): $${totalMasIva.toFixed(2)}</p>`;

        carritoResumen.innerHTML = html;
    }
}

// Ejecutar la función para pintar el carrito cuando la página cargue
document.addEventListener('DOMContentLoaded', pintarCarrito);

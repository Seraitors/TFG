const cart = document.getElementById('cart');
const cartItemCount = document.getElementById('cartItemCount');
const addToCartButtons = document.querySelectorAll('.btn-comprar');
const cartContainer = document.getElementById('cartContainer');
const cartItemsList = document.getElementById('cartItems');
const cartTotal = document.getElementById('cartTotal');
const btnComprar = document.getElementById('btnComprar');

let cartItems = [];
let itemCount = 0;
let total = 0;

// Función para guardar el carrito en una cookie
function saveCartToCookie() {
    const cartCookieValue = JSON.stringify(cartItems);
    document.cookie = "cart=" + encodeURIComponent(cartCookieValue) + ";path=/";
}

// Función para cargar el carrito desde la cookie
function loadCartFromCookie() {
    const cookies = document.cookie.split(';');
    const cartCookie = cookies.find(cookie => cookie.trim().startsWith('cart='));

    if (cartCookie) {
        const cartCookieValue = decodeURIComponent(cartCookie.split('=')[1]);
        cartItems = JSON.parse(cartCookieValue);
        updateCartView();
    }
}

// Función para actualizar la vista del carrito
function updateCartView() {
    cartItemsList.innerHTML = '';
    total = 0;

    cartItems.forEach(item => {
        const listItem = document.createElement('li');
        listItem.classList.add('cart-item');
        listItem.textContent = item.name + ' - $' + item.price.toFixed(2);
        cartItemsList.appendChild(listItem);
        total += item.price;
    });

    cartTotal.textContent = 'Total: $' + total.toFixed(2);
    cartItemCount.textContent = cartItems.length;
}

// Función para agregar un artículo al carrito
function addToCart(event) {
    const productId = event.target.getAttribute('data-figura-id');
    const productName = event.target.getAttribute('data-figura-nombre');
    const productPrice = parseFloat(event.target.getAttribute('data-figura-precio'));

    const item = { id: productId, name: productName, price: productPrice };
    cartItems.push(item);

    updateCartView();
    saveCartToCookie(); // Guardar el carrito en la cookie
}

// Eventos para mostrar y ocultar el carrito
cart.addEventListener('click', () => {
    cartContainer.style.display = 'block';
});

document.addEventListener('click', (event) => {
    if (!cart.contains(event.target) && !cartContainer.contains(event.target)) {
        cartContainer.style.display = 'none';
    }
});

// Evento para el botón de comprar
btnComprar.addEventListener('click', () => {
    alert('Compra realizada!');
    // Puedes agregar aquí el código para procesar la compra y limpiar el carrito si es necesario.
    cartItems = [];
    updateCartView();
    saveCartToCookie(); // Limpiar la cookie del carrito
});

// Eventos para agregar artículos al carrito
addToCartButtons.forEach(button => {
    button.addEventListener('click', addToCart);
});

// Cargar el carrito desde la cookie cuando la página se carga
document.addEventListener('DOMContentLoaded', (event) => {
    loadCartFromCookie();
});

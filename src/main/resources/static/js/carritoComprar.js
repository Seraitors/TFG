const cart = document.getElementById('cart');
const cartItemCount = document.getElementById('cartItemCount');
const addToCartBtns = document.querySelectorAll('.addToCartBtn');
const cartContainer = document.getElementById('cartContainer');

let itemCount = 0;

function addToCart(event) {
    const product = event.target.getAttribute('data-product');
    itemCount++;
    cartItemCount.textContent = itemCount;
    const cartItem = document.createElement('div');
    cartItem.classList.add('cart-item');
    cartItem.textContent = product;
    cartContainer.appendChild(cartItem);
}

cart.addEventListener('click', () => {
    cartContainer.style.display = 'block';
});

document.addEventListener('click', (event) => {
    if (!cart.contains(event.target) && event.target !== cartContainer) {
        cartContainer.style.display = 'none';
    }
});

addToCartBtns.forEach(btn => {
    btn.addEventListener('click', addToCart);
});






const cartItemsList = document.getElementById('cartItems');
const cartTotal = document.getElementById('cartTotal');

function updateCartView() {
    // Limpiar la vista del carrito
    cartItemsList.innerHTML = '';

    // Recorrer todos los elementos del carrito
    let total = 0;
    cartItems.forEach(item => {
        const listItem = document.createElement('li');
        listItem.textContent = item.name + ' - $' + item.price.toFixed(2);
        cartItemsList.appendChild(listItem);
        total += item.price;
    });

    // Actualizar el total
    cartTotal.textContent = 'Total: $' + total.toFixed(2);
}

function addToCart(event) {
    const product = event.target.getAttribute('data-product');
    const price = parseFloat(event.target.getAttribute('data-price'));
    const item = { name: product, price: price };
    cartItems.push(item);
    itemCount++;
    cartItemCount.textContent = itemCount;
    updateCartView();
}

const cartItems = [];

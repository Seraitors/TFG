
function setCookie(name, value, days) {
    const d = new Date();
    d.setTime(d.getTime() + (days * 24 * 60 * 60 * 1000));
    const expires = "expires=" + d.toUTCString();
    document.cookie = name + "=" + JSON.stringify(value) + ";" + expires + ";path=/";
}

// Función para obtener una cookie
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

// Variables y elementos del DOM

const cartItemCount = document.getElementById('cartItemCount');

const cartItemsList = document.getElementById('cartItems');
const cartTotal = document.getElementById('cartTotal');
const addToCartBtn = document.querySelector('.addToCartBtn');


// Actualizar la vista inicial del carrito
function updateCartView() {
    const userLogCookie = getCookie('user-log');
    if (userLogCookie.length !== 0) {
        // Limpiar la vista del carrito
        let cartItems = getCookie('cartItems');
        let cartItemUser=cartItems[userLogCookie];
        let itemCount = cartItemUser.length;
        cartItemsList.innerHTML = '';

        // Recorrer todos los elementos del carrito
        let total = 0;
        cartItemUser.forEach(item => {
            const listItem = document.createElement('li');
            listItem.textContent = item.name + ' - $' + item.price.toFixed(2);
            cartItemsList.appendChild(listItem);
            total += item.price;
        });

        // Actualizar el total
        cartTotal.textContent = 'Total: $' + total.toFixed(2);
        cartItemCount.textContent = itemCount;
    }
}

// Función para añadir un elemento al carrito


function addToCart(event) {
    const userLogCookie = getCookie('user-log');
    if (userLogCookie.length !== 0) {
        let cartItems = getCookie('cartItems');
        if (cartItems.length == 0) {
            cartItems = {};
        }
        const productId = event.target.getAttribute('data-figura-id');
        const productName = event.target.getAttribute('data-figura-nombre');
        const productPrice = parseFloat(event.target.getAttribute('data-figura-precio'));



        const item = { id: productId, name: productName, price: productPrice };
        if (cartItems[userLogCookie]) {
            cartItems[userLogCookie].push(item);
        } else {
            cartItems[userLogCookie] = [item];
        }



        // Actualizar la cookie del carrito
        setCookie('cartItems', cartItems, 7);

        // Actualizar la vista del carrito
        updateCartView();

    } else {
        alert('Debes iniciar sesion para añadir al carrito');
    }

}


addToCartBtn.addEventListener('click', addToCart);

// Añadir evento a los botones de añadir al carrito



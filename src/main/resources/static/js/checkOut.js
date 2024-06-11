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

function setCookie(name, value, days) {
    const d = new Date();
    d.setTime(d.getTime() + (days*24*60*60*1000));
    const expires = "expires=" + d.toUTCString();
    document.cookie = name + "=" + JSON.stringify(value) + ";" + expires + ";path=/";
}


function clearCart() {

    console.log("hola bebebebe")
    const userLogCookie = getCookie('user-log');

    console.log("esto es borrar");
    if (userLogCookie.length !== 0) {
        let cartItems = getCookie('cartItems');
        delete cartItems[userLogCookie];
        setCookie('cartItems', cartItems, 7);


    }


}


function obtenerCarritoUser() {
    const carrito = getCookie('cartItems');
    const userLogCookie = getCookie('user-log');

    if (userLogCookie.length !== 0) {
        let carritoUser = carrito[userLogCookie];
        console.log(carritoUser);
        return carritoUser;
    }
}

function obtenerPrecioTotal() {
    const carrito = getCookie('cartItems');
    const userLogCookie = getCookie('user-log');

    if (userLogCookie.length !== 0) {
        let carritoUserPrice = carrito[userLogCookie];


        let total = 0;

        carritoUserPrice.forEach(item => {

            total += item.price;
        });


        const iva = total * 0.21;
        const totalMasIva = total + iva;



        // Envía el total con IVA al backend
        return totalMasIva;
    }
}


function obtenerVenta() {
    const carrito = getCookie('cartItems');
    const userLogCookie = getCookie('user-log');

    if (userLogCookie.length !== 0) {
        let carritoUserPrice = carrito[userLogCookie];
        let nombreFigura = "";
    let datosVivienda = document.getElementById('direccion').value  + " " +  document.getElementById('ciudad').value + " " + document.getElementById('codigo_postal').value + " " +  document.getElementById('pais').value
    let venta={
        "fechaCompra": new Date().toISOString(),
        "nombre": document.getElementById('nombre').value,
        "figuraComprada":"goku",
        "precioTotal":obtenerPrecioTotal(),
        "datosVivienda":datosVivienda


    }

    console.log(venta);

    return venta;
}}

document.addEventListener('DOMContentLoaded', async () => {
    const stripe = Stripe('pk_test_51PMaMmEU6FtnP23OvWcrCbFimaRvuLTiuDYgWqwAe5g69wTwZii9AuQi5WAR8io63FOdTdw1MfSS8piqWASmu6X900afNsbBt5');
    const elements = stripe.elements();
    const cardElement = elements.create('card');
    cardElement.mount('#card-element');

    const form = document.getElementById('payment-form');
    form.addEventListener('submit', async (event) => {
        event.preventDefault();
        let dinero = obtenerPrecioTotal() *100;
        const { clientSecret } = await fetch('/api/create-payment-intent', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ amount: dinero })
        }).then(r => r.json());

        const { paymentIntent, error } = await stripe.confirmCardPayment(clientSecret, {
            payment_method: {
                card: cardElement,
                billing_details: {
                    name: document.getElementById('cardName').value
                }
            }
        });

        if (error) {
            document.getElementById('payment-message').textContent = error.message;
        } else if (paymentIntent.status === 'succeeded') {

            fetch('/api/postPay', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(obtenerCarritoUser())
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    // Aquí puedes manejar la respuesta si lo necesitas
                })
                .catch(error => {
                    console.error('There was an error with the fetch operation:', error);
                });

            fetch('/api/postPayVenta', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(obtenerVenta())
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    // Aquí puedes manejar la respuesta si lo necesitas
                })
                .catch(error => {
                    console.error('There was an error with the fetch operation:', error);
                });

            clearCart();
            // Redirige al usuario a una URL específica
            window.location.href = "http://localhost:7071/";



        }
    });
});


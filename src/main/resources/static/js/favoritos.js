document.addEventListener("DOMContentLoaded", function() {
    var addToCartButton = document.getElementById("addToCart");

    addToCartButton.addEventListener("click", function() {
        alert("¡No puedes añadir a la lista nada si no estás registrado!");
    });
});

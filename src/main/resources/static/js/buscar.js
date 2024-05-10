document.addEventListener("DOMContentLoaded", function() {
    var toggleButton = document.getElementById("toggleSearchForm");
    var searchForm = document.getElementById("searchForm");

    // Inicialmente, ocultamos el formulario de búsqueda
    searchForm.style.display = "none";

    toggleButton.addEventListener("click", function(event) {
        // Evitamos que el evento se propague hacia arriba (hacia los padres)
        event.stopPropagation();

        // Alternamos la visibilidad del formulario de búsqueda
        if (searchForm.style.display === "none" || searchForm.style.display === "") {
            searchForm.style.display = "block";
        } else {
            searchForm.style.display = "none";
        }
    });

    // Agregamos un evento clic al formulario de búsqueda para evitar que se cierre cuando se hace clic dentro de él
    searchForm.addEventListener("click", function(event) {
        event.stopPropagation();
    });

    // Agregamos un evento clic al documento para cerrar el formulario de búsqueda cuando se hace clic en cualquier lugar fuera de él
    document.addEventListener("click", function() {
        searchForm.style.display = "none";
    });
});

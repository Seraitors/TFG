
    document.addEventListener("DOMContentLoaded", function() {
    // Obtener la URL actual
    var currentUrl = window.location.pathname;

    // Definir un objeto que mapea las rutas a los identificadores de los enlaces
    var linkMap = {
    "/inicio": "linkInicio",
    "/caracteristicas": "linkCaracteristicas",
    "/pagoEnca": "linkPrecios",
    "/faqs": "linkFaqs",
    "/encabezado": "linkAcerca"
};

    // Obtener el identificador del enlace correspondiente a la URL actual
    var activeLinkId = linkMap[currentUrl];

    // Si existe un enlace correspondiente, añadir la clase 'active'
    if (activeLinkId) {
    document.getElementById(activeLinkId).classList.add("active");
}
});


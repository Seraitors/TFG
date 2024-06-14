function setCookie(name, value, days) {
    const d = new Date();
    d.setTime(d.getTime() + (days*24*60*60*1000));
    const expires = "expires=" + d.toUTCString();
    document.cookie = name + "=" + JSON.stringify(value) + ";" + expires + ";path=/";
}



document.addEventListener('DOMContentLoaded', () => {
    try {
        // Seleccionar el elemento con el ID 'nombre-usuario'
        const nombreUsuarioElement = document.getElementById('nombre-usuario');

        // Verificar si el elemento existe
        if (!nombreUsuarioElement) {
            throw new Error('El elemento con ID "nombre-usuario" no se encontró en el DOM.');
        }

        // Obtener el contenido de texto del elemento
        const nombreUsuario = nombreUsuarioElement.textContent.trim();

        setCookie('user-log', nombreUsuario, 7);
        // Aquí puedes continuar con la lógica para usar el nombre de usuario
    } catch (error) {
        console.error("Ningun usuario logueado");
        // Puedes manejar el error de otras maneras, como mostrar un mensaje en la UI
    }
});


/*addToCartBtn.addEventListener('click', addCockieSesion);*/


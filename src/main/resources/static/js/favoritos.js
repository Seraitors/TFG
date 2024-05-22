
    function toggleFavorite(figuraId, element) {
    fetch(`/favoritos/toggle/${figuraId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        credentials: 'same-origin'
    })
        .then(response => response.json())
        .then(data => {
            if (data.status === 'added') {
                element.classList.add('text-danger');
            } else if (data.status === 'removed') {
                element.classList.remove('text-danger');
            }
        })
        .catch(error => console.error('Error:', error));
}


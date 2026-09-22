document.addEventListener('DOMContentLoaded', function() {
    const formulario = document.getElementById('loginForm');
    
    if (formulario) {
        formulario.addEventListener('submit', function() {
            // Solo cambiamos el texto del botón
            const btn = document.querySelector('.btn');
            if (btn) {
                btn.innerHTML = 'ENTRANDO...';
            }
            // Al NO haber preventDefault, el navegador envía el form al Java automáticamente
        });
    }
});
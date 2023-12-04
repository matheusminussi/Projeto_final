function mostrarDiv(divId) {
    var divs = document.getElementsByClassName('menu-cadastro');
    for (var i = 0; i < divs.length; i++) {
        if (divs[i].id === divId) {
            divs[i].style.display = 'block';
        } else {
            divs[i].style.display = 'none';
        }
    }
}

function informeGeneral() {
    htmlPDF = document.getElementById("informeDatos");
    html2pdf(htmlPDF);
}

function atras() {
    window.location = "http://localhost:8080/responsable";
}

function generarActas() {
    var resultado = confirm("¿Estás seguro que quieres generar las actas de manera automática?");
    if (resultado === true) {
        window.location = "http://localhost:8080/responsable";
    }
}
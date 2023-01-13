function atras() {
    window.location = "http://localhost:8080/responsable";
}

function guardar() {
    htmlPDF = document.getElementById("DatosGuardados");
    html2pdf(htmlPDF);
}

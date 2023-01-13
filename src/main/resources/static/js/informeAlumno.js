var nombre = document.getElementById('nombre');
nombre.disabled = true;

var apellido = document.getElementById('apellido');
apellido.disabled = true;

var nombreEmpresa = document.getElementById('nombreEmpresa');
nombreEmpresa.disabled = true;

var fecha = document.getElementById('fecha');
fecha.disabled = true;

var nombreTutor = document.getElementById('nombreTutor');
nombreTutor.disabled = true;

var apellidoTutor = document.getElementById('apellidoTutor');
apellidoTutor.disabled = true;

var fechaFinal2 = document.getElementById('fechaFinal2');
fechaFinal2.disabled = true;

var fechaInicio2 = document.getElementById('fechaInicio2');
fechaInicio2.disabled = true;

function atras() {
    window.location = "http://localhost:8080/alumno";
}

function generarInforme() {
    htmlPDF = document.getElementById("informe");

    html2pdf(htmlPDF);
}
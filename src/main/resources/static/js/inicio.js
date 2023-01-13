function elegir() {
    window.location = "http://localhost:8080/alumno/seleccionarPracticas";
}

function cerrarSesion() {
    var resultado = confirm("¿Estás seguro que quieres cerrar sesión?");
    if (resultado === true) {
        window.location = "http://localhost:8080/";
    }
}

function informePracticas() {
    window.location = "http://localhost:8080/alumno/informeAlumno";
}

function verEmpresa() {
    window.location = "http://localhost:8080/tutor/verEmpresa";
}

function redactarInforme() {
    window.location = "http://localhost:8080/tutor/redactarInforme";
}


function redactarInforme() {
    window.location = "http://localhost:8080/tutor/redactarInforme";
}

function AsignarPracticas() {
    window.location = "http://localhost:8080/responsable/asignarPractica";
}

function ConsultarInformacion() {
    window.location = "http://localhost:8080/responsable/consultarInformacion";
}

function InformeActas() {
    window.location = "http://localhost:8080/responsable/informeActas";
}


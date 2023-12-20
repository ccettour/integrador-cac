document.addEventListener("DOMContentLoaded", function () {
  var scrollTopBtn = document.getElementById("scrollTopBtn");

  window.addEventListener("scroll", function () {
    if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
      scrollTopBtn.style.display = "block";
    } else {
      scrollTopBtn.style.display = "none";
    }
  });

  scrollTopBtn.addEventListener("click", function () {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
  });
});


let botEnviar = document.getElementById("botonEnviar");
botEnviar.addEventListener("click", enviarMensaje);

// Establecer el límite de caracteres
const maxCaracteres = 200;

function enviarMensaje(event) {
    event.preventDefault();
    
    //Datos del formulario
    let nombre = document.getElementById("nombre").value;
    let correo = document.getElementById("correo").value;
    let mensaje = document.getElementById("mensaje").value;
    
    if (nombre === "" || correo === "" || mensaje === "") {
        document.getElementById("cont_error").textContent = "Por favor, completá todos los campos.";
    
    } else {
        document.getElementById("cont_error").textContent = "";
        
        console.log(nombre);
        console.log(correo);
        console.log(mensaje);
        
        document.getElementById("formContacto").submit();
        
        alert("Mensaje enviado. ¡Muchas gracias por contactarse!")
        
    }
}

// Función para actualizar el contador de caracteres
function actualizarContador() {
    let mensaje = document.getElementById("mensaje").value;
    const contadorElemento = document.getElementById("contadorCaracteres");
    contadorElemento.textContent = mensaje.length + "/" + maxCaracteres;
}
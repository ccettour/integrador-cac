package controlador;

import dao.MensajesDAO;
import modelo.Mensaje;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/dejarMensaje")
public class DejarMensaje extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
// Obtener datos del formulario
        String nombre = request.getParameter("nombre");
        String correo = request.getParameter("correo");
        String mensaje = request.getParameter("mensaje");

        // Crear un objeto Mensaje con los datos obtenidos
        Mensaje mensaje1 = new Mensaje();
        mensaje1.setNombre(nombre);
        mensaje1.setCorreo(correo);
        mensaje1.setMensaje(mensaje);

        // Obtener la fecha actual
        java.util.Date fechaActual = new java.util.Date(); //es una forma de utilizar la clase sin necesitar una declaracion 'import'
        mensaje1.setFecha(new Date(fechaActual.getTime()));

        // Cargar el mensaje en la base de datos
        MensajesDAO mensajesDAO = new MensajesDAO();
        mensajesDAO.agregarMensaje(mensaje1);

        // Redireccionar al inicio
        response.sendRedirect("index.html");
    }
}

package controlador;

import dao.MensajesDAO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/vistas/GestionMensajeServlet")
public class GestionMensajeServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MensajesDAO mensajesDAO = new MensajesDAO();
        
        int idMensaje = Integer.parseInt(request.getParameter("id"));

        mensajesDAO.eliminarMensaje(idMensaje);
        response.sendRedirect("gestionMensajes.jsp");
    }
}

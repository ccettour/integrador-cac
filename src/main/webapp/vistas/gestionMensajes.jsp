<%@page import="dao.MensajesDAO"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Mensaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Gestión de Mensajes</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="../styles/styles.css">
    </head>
    <body>
        <div class="container mt-5">
            <h2>Gestión de Mensajes</h2>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Correo</th>
                        <th>Mensaje</th>
                        <th>Fecha</th>
                        <th>Eliminar</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        MensajesDAO mensajesDAO = new MensajesDAO();
                        List<Mensaje> mensajes = mensajesDAO.obtenerTodos();

                        if (mensajes != null && !mensajes.isEmpty()) {
                            for (Mensaje m : mensajes) {
                    %>
                    <tr>
                        <td><%= m.getIdMensaje()%></td>
                        <td><%= m.getNombre()%></td>
                        <td><%= m.getCorreo()%></td>
                        <td><%= m.getMensaje()%></td>
                        <td><%= m.getFecha()%></td>
                        <td>
                            <div class="d-flex">
                                <!-- Formulario para eliminar -->
                                <form action="GestionMensajeServlet" method="post">
                                    <input type="hidden" name="id" value="<%= m.getIdMensaje()%>">
                                    <button type="submit" class="btn btn-light">Eliminar</button>
                                </form>
                            </div>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">No hay mensajes para mostrar.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="../" class="btn btn-light">Volver</a>   
        </div>
    </body>
</html>


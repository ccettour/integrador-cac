package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Mensaje;
import util.ConexionDB;

public class MensajesDAO {
    public void agregarMensaje(Mensaje mensaje) {
        String sql = "INSERT INTO mensaje (nombre, correo, mensaje, fecha) VALUES (?, ?, ?, ?)";
        //bloque try-with-resources
        //asegura que los recursos abiertos en su declaración (dentro de los paréntesis) se cierren automáticamente al final del bloque try 
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, mensaje.getNombre());
            ps.setString(2, mensaje.getCorreo());
            ps.setString(3, mensaje.getMensaje());
            ps.setDate(4, mensaje.getFecha());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Mensaje obtenerPorId(int id) {
        String sql = "SELECT * FROM mensaje WHERE id_mensaje = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Mensaje mensaje = new Mensaje();
                mensaje.setIdMensaje(rs.getInt("id_mensaje"));
                mensaje.setNombre(rs.getString("nombre"));
                mensaje.setCorreo(rs.getString("correo"));
                mensaje.setMensaje(rs.getString("mensaje"));
                mensaje.setFecha(rs.getDate("fecha"));
                return mensaje;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Mensaje> obtenerTodos() {
        List<Mensaje> mensajes = new ArrayList<>();
        String sql = "SELECT * FROM mensaje";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Mensaje mensaje = new Mensaje();
                mensaje.setIdMensaje(rs.getInt("id_mensaje"));
                mensaje.setNombre(rs.getString("nombre"));
                mensaje.setCorreo(rs.getString("correo"));
                mensaje.setMensaje(rs.getString("mensaje"));
                mensaje.setFecha(rs.getDate("fecha"));
                mensajes.add(mensaje);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mensajes;
    }

    public void eliminarMensaje(int id) {
        String sql = "DELETE FROM mensaje WHERE id_mensaje = ?";
        try (Connection conn = ConexionDB.conectar();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

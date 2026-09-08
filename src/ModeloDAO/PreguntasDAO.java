/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Modelo.Preguntas;
import java.sql.*;
import Conectividad.Conexion;

/**
 *
 * @author GoodF
 */
public class PreguntasDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conec = new Conexion();

    public String obtenerNombrePreguntaPorId(int id_pregunta) {
        String nombrePregunta = null;

        try {
            conn = conec.getConexion();
            String sql = "SELECT pregunta FROM Preguntas WHERE id_pregunta = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_pregunta);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombrePregunta = rs.getString("pregunta");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre de la pregunta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

        return nombrePregunta;
    }
    
    public String obtenerRespuestaporIdPregunta(int id_pregunta, int id_usuario){
        String respuesta = null;

        try {
            conn = conec.getConexion();
            String sql = "SELECT respuesta FROM Usuario_Pregunta WHERE id_pregunta = ? AND id_usuario =?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_pregunta);
            ps.setInt(2, id_usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                respuesta = rs.getString("respuesta");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la respuesta: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
            }
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }

        return respuesta;
    }
}

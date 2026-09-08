/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Conectividad.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author GoodF
 */
public class PermisosDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    Conexion conec = new Conexion();

    public String obtenerNombrePermisoPorId(int id_permiso) {
        String nombrePermiso = null;

        try {
            conn = conec.getConexion();
            String sql = "SELECT nombre_permiso FROM Permisos WHERE id_permiso = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id_permiso);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombrePermiso = rs.getString("nombre_permiso");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre del permiso: " + e.getMessage());
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

        return nombrePermiso;
    }
}

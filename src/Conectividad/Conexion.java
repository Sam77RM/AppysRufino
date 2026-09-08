package Conectividad;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {    
    private Connection conn;
    
    public Connection getConexion(){  

         /*
                Base caida, necesitamos un servicio permanente
                Esctructura del link:
                mysql://sql10.freesqldatabase.com:3306/sql10789406"
                
          */
        String link = "mysql://sql10.freesqldatabase.com:3306/sql10789406"
        String user = "usr";
        String password = "pwsd";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            conn = DriverManager.getConnection(link,user,password);
            System.out.println("Conectado Exitosamente");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error en la conexion!");
        }
        return conn;
    }
    
    public static void main(String args[]){
        try {
            PreparedStatement ps;
            Conexion ok = new Conexion();
            Connection oki;
            oki = ok.getConexion();
            String sql ="drop table Usuarios";
            ps = oki.prepareStatement(sql);
            ps.executeUpdate();
            oki.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
package Conectividad;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {    
    private Connection conn;
    
    public Connection getConexion(){        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://sql10.freesqldatabase.com:3306/sql10789406","sql10789406","CMVCCUHYEv");
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
        
        /*
        
        
           Conexion con = new Conexion();
    Connection conn;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Cliente c;
    ArrayList<Cliente> vc= new ArrayList<>();
    

    @Override
    public void insertar(Cliente c) {
        
        try {
            String sql = "insert into cliente (codcli, nomcli, ruccli) values(?,?,?)";
            conn = con.getConexion();
            ps = conn.prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getRuc());
            ps.executeUpdate();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }
}
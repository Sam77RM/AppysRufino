/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Interfaces.Usuario_Interface;
import Modelo.Usuarios;
import java.sql.*;
import Modelo.Cargos;
import Modelo.Permisos;
import Modelo.Preguntas;
import java.util.logging.*;
import Conectividad.Conexion;
import java.util.ArrayList;

/**
 *
 * @author GoodF
 */
public class UsuariosDAO implements Usuario_Interface {

    PreparedStatement ps;
    Conexion conec = new Conexion();
    Connection mycon;
    ResultSet rs;
    Usuarios myusuario;
    Cargos micargo;
    Permisos mipermix;
    Preguntas mipreguntix;
    ArrayList<Permisos> mipermiso;
    ArrayList<Preguntas> mipregunta;

    @Override
    public boolean insertar(Usuarios p) {
        int nuevoID = 0;
        try {
            mycon = conec.getConexion();
            mycon.setAutoCommit(false);     //desactiva el modo confirmacion automatica de transaccion

            String sql = "INSERT INTO Usuarios (usuario, contrasena, nombre ,id_cargo)"
                    + " VALUES (?,?,?,?)";
            mycon = conec.getConexion();
            ps = mycon.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getUsuario());
            ps.setString(2, p.getPassword());
            ps.setString(3, p.getNombre());
            ps.setInt(4, p.getLosCargos().getId_cargo());
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            while (rs.next()) {
                nuevoID = rs.getInt(1);
            }
            rs.close();
            System.out.println("Insertado: Parte 1 - Bien");

            for (int i = 0; i < p.getLasPreguntas().size(); i++) {

                String sql2 = "INSERT INTO Usuario_Pregunta (id_usuario, id_pregunta, respuesta)"
                        + " VALUES (?,?,?)";
                ps = mycon.prepareStatement(sql2);
                ps.setInt(1, nuevoID);
                ps.setInt(2, p.getLasPreguntas().get(i).getId_pregunta());
                ps.setString(3, p.getLasPreguntas().get(i).getRespuesta());
                ps.executeUpdate();
                System.out.println("Insertado: Parte 2 - Bien");
            }

            for (int i = 0; i < p.getLosPermisos().size(); i++) {

                String sql3 = "INSERT INTO Usuario_Permiso (id_usuario, id_permiso)"
                        + " VALUES (?,?)";
                ps = mycon.prepareStatement(sql3);
                ps.setInt(1, nuevoID);
                ps.setInt(2, p.getLosPermisos().get(i).getId_permiso());
                ps.executeUpdate();
                System.out.println("Insertado: Parte 3 - Bien");

            }
        } catch (SQLException ex) {
            try {
                if (mycon != null) {
                    mycon.rollback();
                }
            } catch (SQLException e) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, e);
                return false;
            }
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return true;
    }

    @Override
    public boolean eliminar(String usuario) {
        int codigo = 0;
        try {
            mycon = conec.getConexion();
            String sql1 = "select codigo from Usuarios where usuario=?";
            ps = mycon.prepareStatement(sql1);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                codigo = rs.getInt("codigo");
            }
            mycon.close();
            rs.close();
            ps.close();
            if (codigo == 0) {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            mycon = conec.getConexion();
            String sql = "delete from Usuario_Pregunta where id_usuario=?";
            String sql2 = "delete from Usuario_Permiso where id_usuario=?";
            String sql3 = "delete from Usuarios where usuario=?";
            ps = mycon.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps = mycon.prepareStatement(sql2);
            ps.setInt(1, codigo);
            ps.executeUpdate();
            ps = mycon.prepareStatement(sql3);
            ps.setString(1, usuario);
            ps.executeUpdate();
            mycon.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public UsuariosDAO() {
    }

    @Override
    public Usuarios listarUno(String user) {
        micargo = new Cargos();
        myusuario = new Usuarios();
        mipermiso = new ArrayList<>();
        mipregunta = new ArrayList<>();
        //Datos comunes
        try {
            String sql = "select * from Usuarios where usuario=?";
            mycon = conec.getConexion();
            ps = mycon.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            if(rs.next()) {
                myusuario.setCodigo(rs.getInt("codigo"));
                myusuario.setUsuario(rs.getString("usuario"));
                myusuario.setNombre(rs.getString("nombre"));
                myusuario.setPassword(rs.getString("contrasena"));
                micargo.setId_cargo(rs.getInt("id_cargo"));
            } else{
                ps.close();
                rs.close();
                mycon.close();
                return null;        
            }
            //Cargo
            String sql2 = "select * from Cargos where id_cargo =?";
            ps = mycon.prepareStatement(sql2);
            ps.setInt(1, micargo.getId_cargo());
            rs = ps.executeQuery();
            while (rs.next()) {
                micargo.setNombre_Cargo(rs.getString("nombre_cargo"));
            }
            myusuario.setLosCargos(micargo);

            //Permisos
            // Consulta los permisos asignados al usuario
            String sql3 = "SELECT * FROM Usuario_Permiso WHERE id_usuario = ?";
            ps = mycon.prepareStatement(sql3);
            ps.setInt(1, myusuario.getCodigo());
            rs = ps.executeQuery();

            while (rs.next()) {
                Permisos mipermix = new Permisos();
                mipermix.setId_usuario(rs.getInt("id_usuario"));
                mipermix.setId_permiso(rs.getInt("id_permiso"));

                // Cargar el nombre del permiso con otro PreparedStatement y ResultSet
                String sql4 = "SELECT nombre_permiso FROM Permisos WHERE id_permiso = ?";
                try (PreparedStatement ps2 = mycon.prepareStatement(sql4)) {
                    ps2.setInt(1, mipermix.getId_permiso());
                    try (ResultSet rs2 = ps2.executeQuery()) {
                        if (rs2.next()) {
                            mipermix.setNombre_permiso(rs2.getString("nombre_permiso"));
                        }
                    }
                }

                mipermiso.add(mipermix);
            }

            myusuario.setLosPermisos(mipermiso);

            //Preguntas
            String sql5 = "SELECT * FROM Usuario_Pregunta WHERE id_usuario = ?";
            ps = mycon.prepareStatement(sql5);
            ps.setInt(1, myusuario.getCodigo());
            rs = ps.executeQuery();

            while (rs.next()) {
                Preguntas pregunta = new Preguntas();
                pregunta.setId_usuario(rs.getInt("id_usuario"));
                pregunta.setId_pregunta(rs.getInt("id_pregunta"));
                pregunta.setRespuesta(rs.getString("respuesta"));

                // Obtener el texto de la pregunta
                String sql6 = "SELECT pregunta FROM Preguntas WHERE id_pregunta = ?";
                try (PreparedStatement ps2 = mycon.prepareStatement(sql6)) {
                    ps2.setInt(1, pregunta.getId_pregunta());
                    try (ResultSet rs2 = ps2.executeQuery()) {
                        if (rs2.next()) {
                            pregunta.setNombre_pregunta(rs2.getString("pregunta"));
                        }
                    }
                }

                mipregunta.add(pregunta); // Agregar a la lista
            }

            myusuario.setLasPreguntas(mipregunta);

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        return myusuario;
    }

   
    @Override
    public boolean actualizar(Usuarios miusu) {

        try {
            mycon = conec.getConexion();
            mycon.setAutoCommit(false);

            String sql = "update Usuarios set usuario=?, nombre=?, contrasena=?, id_cargo =? "
                    + "where codigo=" + miusu.getCodigo();

            ps = mycon.prepareStatement(sql);
            ps.setString(1, miusu.getUsuario());
            ps.setString(2, miusu.getNombre());
            ps.setString(3, miusu.getPassword());
            ps.setInt(4, miusu.getLosCargos().getId_cargo());
            ps.executeUpdate();

            for (int i = 0; i < miusu.getLasPreguntas().size(); i++) {
                String sql2 = "update Usuario_Pregunta set respuesta=?"
                        + "where id_usuario=? and id_pregunta =?";
                ps = mycon.prepareStatement(sql2);
                ps.setString(1, miusu.getLasPreguntas().get(i).getRespuesta());
                ps.setInt(2, miusu.getCodigo());
                ps.setInt(3, miusu.getLasPreguntas().get(i).getId_pregunta());
                ps.executeUpdate();
            }
            //eliminando permisos antiguos para ingresar nuevos

            String deleteSQL = "DELETE FROM Usuario_Permiso WHERE id_usuario=?";
            ps = mycon.prepareStatement(deleteSQL);
            ps.setInt(1, miusu.getCodigo());
            ps.executeUpdate();

            String insertSQL = "INSERT INTO Usuario_Permiso (id_usuario, id_permiso) VALUES (?, ?)";
            for (int i = 0; i < miusu.getLosPermisos().size(); i++) {
                ps = mycon.prepareStatement(insertSQL);
                ps.setInt(1, miusu.getCodigo());
                ps.setInt(2, miusu.getLosPermisos().get(i).getId_permiso());
                ps.executeUpdate();
                
            }
        } catch (SQLException ex) {
            try {
                if (mycon != null) {
                    mycon.rollback();
                }
            } catch (SQLException e) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, e);
                return false;
            }
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (mycon != null) {
                    mycon.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }

        }
        return true;
    }

    @Override
    public ArrayList<Usuarios> listarTodos() {
        ArrayList<Usuarios> ListadeUsers = new ArrayList<>();
        try {
            String sql = "select * from Usuarios";
            mycon = conec.getConexion();
            ps = mycon.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                myusuario = new Usuarios();
                myusuario.setCodigo(rs.getInt("codigo"));
                myusuario.setUsuario(rs.getString("usuario"));
                myusuario.setNombre(rs.getString("nombre"));
                myusuario.setPassword(rs.getString("contrasena"));
                micargo = new Cargos();
                micargo.setId_cargo(rs.getInt("id_cargo"));
                
                //Nombre del cargo
                String sql2 = "select * from Cargos where id_cargo =?"; 
                PreparedStatement ps2 = mycon.prepareStatement(sql2);
                ps2.setInt(1, micargo.getId_cargo());
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    micargo.setNombre_Cargo(rs2.getString("nombre_cargo"));
                }
                rs2.close();
                ps2.close();
                myusuario.setLosCargos(micargo);
                
                //Los permisos
                ArrayList<Permisos> miper = new ArrayList<>();
                String sql3 = "select * from Usuario_Permiso where id_usuario =?"; 
                PreparedStatement ps3 = mycon.prepareStatement(sql3);
                ps3.setInt(1, myusuario.getCodigo());
                ResultSet rs3 = ps3.executeQuery();
                while(rs3.next()){
                    Permisos mipermi = new Permisos();
                    mipermi.setId_usuario(rs3.getInt("id_usuario"));
                    mipermi.setId_permiso(rs3.getInt("id_permiso"));
                        String sql4 = "select * from Permisos where id_permiso =?"; 
                        PreparedStatement ps4 = mycon.prepareStatement(sql4);
                        ps4.setInt(1, mipermi.getId_permiso());
                        ResultSet rs4 = ps4.executeQuery();
                        while(rs4.next()){
                            mipermi.setNombre_permiso(rs4.getString("nombre_permiso"));
                        }
                        rs4.close();
                        ps4.close();
                    miper.add(mipermi);
                }
                rs3.close();
                ps3.close();
                myusuario.setLosPermisos(miper);
                
                //Las preguntas
                mipregunta = new ArrayList<>();
                String sql5 = "select * from Usuario_Pregunta where id_usuario =?"; 
                PreparedStatement ps5 = mycon.prepareStatement(sql5);
                ps5.setInt(1, myusuario.getCodigo());
                ResultSet rs5 = ps5.executeQuery();
                while(rs5.next()){
                    mipreguntix = new Preguntas();
                    mipreguntix.setId_usuario(rs5.getInt("id_usuario"));
                    mipreguntix.setId_pregunta(rs5.getInt("id_pregunta"));
                    mipreguntix.setRespuesta(rs5.getString("respuesta"));
                    
                    String sql6 = "select * from Preguntas where id_pregunta =?"; 
                    PreparedStatement ps6 = mycon.prepareStatement(sql6);
                    ps6.setInt(1, mipreguntix.getId_pregunta());
                    ResultSet rs6 = ps6.executeQuery();
                    while(rs6.next()){
                        mipreguntix.setNombre_pregunta(rs6.getString("pregunta"));
                    }
                    ps6.close();
                    rs6.close();
                    
                    mipregunta.add(mipreguntix);
                    
                }
                myusuario.setLasPreguntas(mipregunta);
                ps5.close();
                rs5.close();
                ListadeUsers.add(myusuario);
            }
            ps.close();
            rs.close();
            mycon.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ListadeUsers;
    }
    
    public Usuarios Login(String usuario, String contrasenia){
        int id_usuario=0;
        try {
            String sql = "select * from Usuarios where usuario = ? and contrasena = ?";
            mycon = conec.getConexion();
            ps = mycon.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();
            if(rs.next()){
                id_usuario = rs.getInt("codigo"); 
            }
        }catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
       }finally {
            try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (mycon != null) mycon.close();
            } catch (SQLException e) {
            e.printStackTrace();
        }
        } 
        if(id_usuario<1){
            return null;
        }else{
            UsuariosDAO miconexion = new UsuariosDAO();
            return miconexion.listarUno(usuario);
            
            }
    }
}



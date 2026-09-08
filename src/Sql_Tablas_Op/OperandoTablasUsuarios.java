/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sql_Tablas_Op;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Conectividad.Conexion;
public class OperandoTablasUsuarios {
    Conexion ok;
    PreparedStatement ps;
    Connection oki;
    public void eliminarTablas(String nombreTabla){
    try {
            ok = new Conexion();
            oki = ok.getConexion();
            String sql ="drop table "+nombreTabla;
            ps = oki.prepareStatement(sql);
            ps.executeUpdate();
            oki.close();
            System.out.println("Tabla eliminada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error!");
        }
    }
    
    public void ejecutaCualquierLineaSQL(String tuLinea){
        try{
            ok = new Conexion();
            oki = ok.getConexion();
            ps = oki.prepareStatement(tuLinea);
            ps.executeUpdate();
            oki.close();
            System.out.println("Linea Ejecutada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error!");
        }
    }
    
    public int ejecutaCualquierLineaSQLyRetornaelID(String tuLinea){
        int nuevoID=0;
        try{
            ok = new Conexion();
            oki = ok.getConexion();
            ps = oki.prepareStatement(tuLinea,Statement.RETURN_GENERATED_KEYS);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            while(rs.next()){
                nuevoID = rs.getInt(1);
            }
            oki.close();
            System.out.println("Linea Ejecutada exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error!");
        }
        return nuevoID;
    }
    
    public static void main (String args[]){
        //Ejecuta los metodos que desees
        OperandoTablasUsuarios go = new OperandoTablasUsuarios();



        /*Tabla cables
         go.ejecutaCualquierLineaSQL("CREATE TABLE Cable (codigo VARCHAR(20) PRIMARY KEY, tipo VARCHAR(50), marca_auto VARCHAR(50), modelo_auto VARCHAR(50), anio_auto INT, cantidad INT, marcaC VARCHAR(50), precioUnt DOUBLE);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt) VALUES ('C123', 'Embrague', 'Toyota', 'Corolla', 2015, 10, 'CableMaster', 45.50);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt , precioCosto) VALUES ('C124', 'Embrague', 'Nissan', 'Sentra', 2012, 25, 'SilverGreen', 60 , 25);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt , precioCosto) VALUES ('C125', 'Acelerador', 'Kia', 'Rio', 2015, 4, 'CableIK', 40 , 15.5);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt , precioCosto) VALUES ('C126', 'Cambios', 'Nissan', 'Versa', 2019, 19, 'SilverGreen', 180 , 60);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt, precioCosto) VALUES ('C127', 'Cambios', 'Nissan ', 'Tiida', 2021, 20, 'SilverGreen', 200 , 80);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt, precioCosto) VALUES ('C128', 'Embrague', 'Chevrolet', 'Sail', 2012, 1, 'Yakama', 70 , 30);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt, precioCosto) VALUES ('C129', 'Freno de Mano', 'Toyota', 'Hilux', 2011, 10, 'Lampa', 120 , 40.5);");
                    go.ejecutaCualquierLineaSQL("INSERT INTO Cable (codigo, tipo, marca_auto, modelo_auto, anio_auto, cantidad, marcaC, precioUnt, precioCosto) VALUES ('C130', 'Acelerador', 'Chevrolet', 'Sail', 2012, 8, 'Yakama', 45 , 25);");

        go.ejecutaCualquierLineaSQL("ALTER TABLE Cable ADD COLUMN precioCosto DOUBLE NOT NULL DEFAULT 0;");

        */
        
        /*
        
        Tabla usuarios
        
        go.ejecutaCualquierLineaSQL("CREATE TABLE Usuarios (\n" +
        "codigo INT PRIMARY KEY AUTO_INCREMENT,\n"+
        "usuario VARCHAR(10) UNIQUE NOT NULL,\n"+
        "nombre VARCHAR(100) NOT NULL,\n" +
        "contrasena VARCHAR(255) NOT NULL,\n" +
        "id_cargo INT,\n"+
        "FOREIGN KEY (id_cargo) REFERENCES Cargos(id_cargo)\n"+
                ");");
        */
        
        /* CARGOS
        go.ejecutaCualquierLineaSQL("CREATE TABLE Cargos (\n" +
        "id_cargo INT PRIMARY KEY AUTO_INCREMENT,\n" +
        "nombre_cargo VARCHAR(50) UNIQUE NOT NULL\n" +
        ");");
        
        go.ejecutaCualquierLineaSQL(""
                + "INSERT INTO Cargos (nombre_cargo) VALUES\n" +
                "('Gerente'),\n" +
                "('Administrador'),\n" +
                "('Vendedor'),\n" +
                "('Tecnico'),\n" +
                "('Contador');");

                    */
        
        
        /*PERMISOS
        go.ejecutaCualquierLineaSQL("CREATE TABLE Permisos (\n" +
        "id_permiso INT PRIMARY KEY AUTO_INCREMENT,\n" +
        "nombre_permiso VARCHAR(50) UNIQUE NOT NULL\n" +
        ");");
        
        go.ejecutaCualquierLineaSQL(""
                + "INSERT INTO Permisos (nombre_permiso) VALUES\n" +
                "('Reporte'),\n" +
                "('Ventas'),\n" +
                "('Almacen'),\n" +
                "('Proveedores'),\n" +
                "('Administrar');");
        
        
        go.ejecutaCualquierLineaSQL("CREATE TABLE Usuario_Permiso (\n" +
        "id_usuario INT,\n" +
        "id_permiso INT,\n" +
        "PRIMARY KEY (id_usuario, id_permiso),\n" +
        "FOREIGN KEY (id_usuario) REFERENCES Usuarios(codigo),\n" +
        "FOREIGN KEY (id_permiso) REFERENCES Permisos(id_permiso)\n" +
        ");");
        
        */
         
        /*PREGUNTAS DE SEGURIDAD
        
        go.ejecutaCualquierLineaSQL("CREATE TABLE Preguntas (\n" +
"       id_pregunta INT PRIMARY KEY AUTO_INCREMENT,\n" +
"       pregunta VARCHAR(100) NOT NULL\n" +
");     ");
        

        
         go.ejecutaCualquierLineaSQL("CREATE TABLE Usuario_Pregunta (\n" +
    "id_usuario INT,\n" +
    "id_pregunta INT,\n" +
    "respuesta VARCHAR(255) NOT NULL,\n" +
    "PRIMARY KEY (id_usuario, id_pregunta),\n" +
    "FOREIGN KEY (id_usuario) REFERENCES Usuarios(codigo),\n" +
    "FOREIGN KEY (id_pregunta) REFERENCES Preguntas(id_pregunta)\n" +
    ");");
        */
         
        /*Insertando Datos en Usuario:
        */
       // go.ejecutaCualquierLineaSQL("insert into Usuarios ( usuario, nombre, contrasena, id_cargo)"
       //         + "values('Pedro25','Pedro Talara','pedrito99',3)");
      /* go.ejecutaCualquierLineaSQL("insert into Usuario_Permiso (id_usuario, id_permiso) "
               + "values (1,3) , (1,2) , (1,4);");
        
       
       
       go.ejecutaCualquierLineaSQL("INSERT INTO Usuario_Pregunta (id_usuario, id_pregunta, respuesta) VALUES\n" +
                "(1,1,'Heroes del Cenepa'),\n" +
                "(1,2,'Rogelio'),\n" +
                "(1,3,'Repartidor delivery');");
        
       
               go.ejecutaCualquierLineaSQL("INSERT INTO Preguntas (pregunta) VALUES\n" +
                "('¿Cuál era el nombre de tu escuela primaria?'),\n" +
                "('¿Cómo se llamaba tu abuelo/a favorito/a?'),\n" +
                "('¿Cuál fue tu primer trabajo?');");
        */
        

    }
    
}

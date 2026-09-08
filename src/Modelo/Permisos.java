/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author GoodF
 */
public class Permisos {
    private int id_usuario;
    private int id_permiso;
    private String nombre_permiso;

    public Permisos(int id_usuario, int id_permiso, String nombre_permiso) {
        this.id_usuario = id_usuario;
        this.id_permiso = id_permiso;
        this.nombre_permiso = nombre_permiso;
    }

    public Permisos() {
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(int id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getNombre_permiso() {
        return nombre_permiso;
    }

    public void setNombre_permiso(String nombre_permiso) {
        this.nombre_permiso = nombre_permiso;
    }
    
}

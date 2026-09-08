/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author GoodF
 */
public class Preguntas {
    private int id_usuario;
    private int id_pregunta;
    private String respuesta;

    public Preguntas() {
    }

    public Preguntas(int id_usuario, int id_pregunta, String respuesta, String nombre_pregunta) {
        this.id_usuario = id_usuario;
        this.id_pregunta = id_pregunta;
        this.respuesta = respuesta;
        this.nombre_pregunta = nombre_pregunta;
    }

    private String nombre_pregunta;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public String getNombre_pregunta() {
        return nombre_pregunta;
    }

    public void setNombre_pregunta(String nombre_pregunta) {
        this.nombre_pregunta = nombre_pregunta;
    }
    
    
}

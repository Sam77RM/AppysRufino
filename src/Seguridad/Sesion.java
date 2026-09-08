/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Seguridad;
import Modelo.Usuarios;
/**
 *Patron Singlenton - persistencia de sesion
 * @author GoodF
 */
public class Sesion {
private static Usuarios usuarioActual;

    public static void iniciarSesion(Usuarios usuario) { // abre sesion
        usuarioActual = usuario;
    }

    public static Usuarios getUsuarioActual() {  //Lee usuario
        return usuarioActual;
    }

    public static void cerrarSesion() { //cierra sesion
        usuarioActual = null;
    }
}

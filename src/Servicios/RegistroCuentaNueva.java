package Servicios;

import ModeloDAO.UsuariosDAO;
import ModeloDAO.PreguntasDAO;
import java.util.ArrayList;
import Modelo.Preguntas;
import Modelo.Permisos;
import Modelo.Usuarios;
import ModeloDAO.PermisosDAO;
import javax.swing.JOptionPane;

public class RegistroCuentaNueva {

    Usuarios miusuario;
    UsuariosDAO myuser;
    String[] diccionariodeletras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    String[] diccionariomayuscula = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    String[] diccionarionumeros = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

    //Obtiene los valores y verifica si cumplen con las condiciones(usuarios: no esten registrados antes, pass: que tenga mayuscula, minuscula y numeros,nuevapass: que sea igual a pass, nombre: que sea mayor a 3,cargo: que sea difernte de 0)
    /**/
    public String verificarRegistroUsuario(String usuario, String pass, String nuevapass, String nombre, int cargo) {
        if (!UsuarioDisponible(usuario)) {
            return "El usuario ya está registrado";
        }
        if (!CantidadDeCaracteres(usuario, pass)) {
            return "El usuario o la contraseña no cumplen con el requisito de caracteres";
        }
        if (!VerificarContrasena(pass, nuevapass)) {
            return "La contraseña no cumple con los requisitos o no coincide";
        }
        if (nombre.length() <= 2) {
            return "El nombre es muy corto";
        }
        if (cargo <= 0) {
            return "Selecciona un cargo para continuar";
        }

        return null; // si devulve nulo significa que si pasa
    }

    /*en frame:
String error = verificarRegistroUsuario(usuario, pass, nuevapass, nombre, cargo);
if (error != null) {
    JOptionPane.showMessageDialog(null, error, "Validación", JOptionPane.WARNING_MESSAGE);
    return false;
}
// Continúa con el proceso
return true;
     */
    //Toma los valores de crear cuenta y dependiendo de que boton se haya seleccionado haya su equivalencia y lo designa como string al final retornando un solo string que tiene todos los valores
    /**/
    public ArrayList<Permisos> recolentadoPermisos(int id_usuario, boolean ventas, boolean almacen, boolean cliente, boolean reporte, boolean administrar) {
        ArrayList<Permisos> Mispermisos = new ArrayList<>();
        PermisosDAO myperm = new PermisosDAO();
        if (ventas) {
            Mispermisos.add(new Permisos(id_usuario, 2, myperm.obtenerNombrePermisoPorId(2)));
        }
        if (almacen) {
            Mispermisos.add(new Permisos(id_usuario, 3, myperm.obtenerNombrePermisoPorId(3)));
        }
        if (cliente) {
            Mispermisos.add(new Permisos(id_usuario, 4, myperm.obtenerNombrePermisoPorId(4)));
        }
        if (reporte) {
            Mispermisos.add(new Permisos(id_usuario, 1, myperm.obtenerNombrePermisoPorId(1)));
        }
        if (administrar) {
            Mispermisos.add(new Permisos(id_usuario, 5, myperm.obtenerNombrePermisoPorId(5)));
        }

        return Mispermisos;
    }

    //Obtiene los valores de las preguntas y verifica que no haya ningún cuadro vacio además verifica que en los cuadros haya al menos 3 caracteres para garantizar una respuesta de seguridad correcta
    /**/
    public ArrayList<Preguntas> recolentadoRespuestas(int id_usuario, String respuesta1, String respuesta2, String respuesta3, int id_pregunta1, int id_pregunta2, int id_pregunta3) {
        PreguntasDAO mypreg = new PreguntasDAO();
        ArrayList<Preguntas> Mispreguntas = new ArrayList<>();
        if (respuesta1 == null || respuesta2 == null || respuesta3 == null
                || respuesta1.length() < 2 || respuesta2.length() < 2 || respuesta3.length() < 2) {
            return null;
        }
        Mispreguntas.add(new Preguntas(id_usuario, id_pregunta1, respuesta1, mypreg.obtenerNombrePreguntaPorId(id_pregunta1)));
        Mispreguntas.add(new Preguntas(id_usuario, id_pregunta2, respuesta2, mypreg.obtenerNombrePreguntaPorId(id_pregunta2)));
        Mispreguntas.add(new Preguntas(id_usuario, id_pregunta3, respuesta3, mypreg.obtenerNombrePreguntaPorId(id_pregunta3)));

        return Mispreguntas;
    }

    //verifica que el usuario no este tomado
    /**/
    public boolean UsuarioDisponible(String usuario) {
        myuser = new UsuariosDAO();
        miusuario = (myuser.listarUno(usuario));

        if (miusuario == null) {
            return true;
        } else {
            return false;
        }
    }

    //verifica el cumplimiento de la cantidad de caracteres para usuario y contrasena
    /*????*/
    public boolean CantidadDeCaracteres(String usuario, String pass) {
        if (((usuario.length() >= 5) && (usuario.length() <= 10)) || ((pass.length() > 7) && (pass.length() < 16))) {
            return true;
        } else {
            return false;
        }
    }

    /*Verifica que contrasena cumpla requisitos y que la nueva contrasena sea igual a la anterior (confirmacion)*/
 /**/
    public boolean VerificarContrasena(String pass, String nuevapass) {
        boolean letras = false, mayuscula = false, numeros = false; // Bandera para corroborar que se cumpla cada valor
        for (int i = 0; i < pass.length(); i++) {
            for (int j = 0; j < diccionariodeletras.length; j++) {
                if (String.valueOf(pass.charAt(i)).equals(diccionariodeletras[j])) { // verificando si existe una letra minuscula en todo
                    letras = true;          // si la encuentra marca en la bandera
                    break;                  // cierra bucle para evitar sobreescritura
                }
            }

        }

        for (int i = 0; i < pass.length(); i++) {
            for (int j = 0; j < diccionariomayuscula.length; j++) {
                if (String.valueOf(pass.charAt(i)).equals(diccionariomayuscula[j])) { // lo mismo pero con mayusculas
                    mayuscula = true;
                    break;
                }
            }

        }

        for (int i = 0; i < pass.length(); i++) {
            for (int j = 0; j < diccionarionumeros.length; j++) {
                if (String.valueOf(pass.charAt(i)).equals(diccionarionumeros[j])) {  // lo mismo pero con numeros
                    numeros = true;
                    break;
                }
            }

        }
        if (numeros && mayuscula && letras && (pass.equals(nuevapass))) {
            return true;
        } else {
            return false;
        }
    }

}

package Servicios;

import ModeloDAO.UsuariosDAO;
import Modelo.Usuarios;
import ModeloDAO.PreguntasDAO;

public class RecuperarCuenta {

    //Obtiene los valores de Recuperar cuenta, compara si el usuario existe y si la respuesta de seguridad es correcta
    /**/
    public int verificarUsuario(String cusuario, String crespuesta, int id_pregunta) {

        UsuariosDAO conector = new UsuariosDAO();
        Usuarios miusu;
        PreguntasDAO conector2 = new PreguntasDAO();
        miusu = conector.listarUno(cusuario);
        if (miusu == null) {
            return -1;
        } else {
            if (crespuesta.equalsIgnoreCase(conector2.obtenerRespuestaporIdPregunta(id_pregunta, miusu.getCodigo()))) {
                return miusu.getCodigo();
            } else {
                return 0;
            }
        }
    }

// Verifica si la nueva contraseña cumple con las reglas y si coincide con la confirmación
    /**/
    public boolean autorizadordeCambiodePassword(String password, String nuevapassword) {
        RegistroCuentaNueva conector = new RegistroCuentaNueva();        // Objeto llamado para reciclar el codigo y verificar la contrasena

        if (conector.VerificarContrasena(password, password) && conector.CantidadDeCaracteres("", password)) {  // usamos el algoritmo creado para validar si es valida la password
            if (password.equals(nuevapassword)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

}

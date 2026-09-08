package Servicios;

import Vista.Ingreso.Ventana_Principal;

public class InterfazUsuarioService {

    //Usa una instanciacion de la clase Frames.App para poder definir el estado de los logos segun el cargo que tiene y asi personalizar mejor la interfaz
    public static void logoUserApp(Ventana_Principal conec, int id_cargo) {

        conec.definirLogoVendedor(id_cargo == 3);
        conec.definirLogoAdministrador(id_cargo == 2);
        conec.definirLogoContador(id_cargo == 5);
        conec.definirLogoTecnico(id_cargo == 4);
        conec.definirLogoGerente(id_cargo == 1);

    }
    //de acuerdo al los permisos que tenga el usuario este metodo permite que que aparezcan habilitados los botones de interfaces (ventas,almacen,etc) y asi pueda acceder a lo que le corresponde  

    public static void iconosPermisosUsuarios(Ventana_Principal conec, int id_permiso) {
        switch (id_permiso) {
            case 1:
                conec.setIconSinAccesoReporte(false);
                conec.setBotonReporte(true);
                break;
            case 2:
                conec.setIconSinAccesoVentas(false);
                conec.setBotonVentas(true);
                break;
            case 3:
                conec.setIconSinAccesoAlmacen(false);
                conec.setBotonAlmacen(true);
                break;
            case 4:
                conec.setIconSinAccesoClientes(false);
                conec.setBotonClientes(true);
                break;
            case 5:
                conec.setIconSinAccesoAdministrar(false);
                conec.setBotonAdministar(true);
                break;
        }

    }
    //Defaults
    //Este método sirve para que el código se vea mejor organizado ya que con solo llamar solamente define que el logo no se vera

    public static void logosUsuariosDefaults(Ventana_Principal conec) {

        conec.definirLogoVendedor(false);

        conec.definirLogoAdministrador(false);

        conec.definirLogoContador(false);

        conec.definirLogoTecnico(false);

        conec.definirLogoGerente(false);

    }
    //Este método sirve para que el código se vea mejor organizado ya que con solo llamar solamente define que el icono no se vera pero que el boton se vea de acuerdo al icono

    public static void iconosPermisosDefaults(Ventana_Principal conec) {

        conec.setIconSinAccesoAdministrar(true);
        conec.setBotonAdministar(false);

        conec.setIconSinAccesoVentas(true);
        conec.setBotonVentas(false);

        conec.setIconSinAccesoClientes(true);
        conec.setBotonClientes(false);

        conec.setIconSinAccesoReporte(true);
        conec.setBotonReporte(false);

        conec.setIconSinAccesoAlmacen(true);
        conec.setBotonAlmacen(false);
    }

}

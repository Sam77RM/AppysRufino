

package Modelo;
import java.util.ArrayList;
import java.sql.*;
import Modelo.Preguntas;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Sql_Tablas_Op.OperandoTablasUsuarios;
import Modelo.Cargos;
public class Usuarios {
    private int codigo;
    private String nombre;
    private String usuario;
    private String password;
    private ArrayList <Preguntas> lasPreguntas = new ArrayList<>();
    private ArrayList<Permisos> losPermisos = new ArrayList<>();
    private Cargos losCargos;
    
    public Usuarios() {
    }

    public Usuarios(int codigo, String nombre, String usuario, String password, Cargos losCargos, ArrayList<Preguntas> mipregunta, ArrayList<Permisos> mipermiso) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.usuario = usuario;
        this.password = password;
        this.losCargos = losCargos;
        this.lasPreguntas = mipregunta;
        this.losPermisos = mipermiso;
    }
        
    
    
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList <Preguntas> getLasPreguntas() {
        return lasPreguntas;
    }

    public void setLasPreguntas(ArrayList <Preguntas> lasPreguntas) {
        this.lasPreguntas = lasPreguntas;
    }

    public ArrayList<Permisos> getLosPermisos() {
        return losPermisos;
    }

    public void setLosPermisos(ArrayList<Permisos> losPermisos) {
        this.losPermisos = losPermisos;
    }

    public Cargos getLosCargos() {
        return losCargos;
    }

    public void setLosCargos(Cargos losCargos) {
        this.losCargos = losCargos;
    }
    
    /*
    public void pruebaAgregandoUsuarios(String user, String nombre, String pass, Cargos elcargo,ArrayList <Preguntas> misPreguntas, ArrayList <Permisos> misPermisosL ){
        OperandoTablasUsuarios go =new OperandoTablasUsuarios();
        String sql = "insert into Usuarios (usuario, contrasena, nombre ,id_cargo) values('"+user+"','"+pass+"','"+nombre+"',"+elcargo.getId_cargo()+");";
        int nuevoID = go.ejecutaCualquierLineaSQLyRetornaelID(sql);
        
        for (int i = 0; i < misPreguntas.size(); i++) {
        String sql2 = "insert into Usuario_Pregunta (id_usuario, id_pregunta, respuesta) values ("+nuevoID+","+misPreguntas.get(i).getId_pregunta()+",'"+misPreguntas.get(i).getRespuesta()+"');" ;
        go.ejecutaCualquierLineaSQL(sql2);
        }
        
        for (int i = 0; i < misPermisosL.size(); i++) {
            for (int j = 0; j < misPermisosL.get(i).getMisPermisos().size(); j++) {
                      String sql3 = "insert into Usuario_Permiso (id_usuario, id_permiso) values ("+nuevoID+","+misPermisosL.get(i).getMisPermisos().get(j)+");" ;
                      go.ejecutaCualquierLineaSQL(sql3);
            }
        }
    }
    */
    /*
    public static void main (String args[]){
    Preguntas gogo = new Preguntas();
    gogo.setId_pregunta(1);
    gogo.setRespuesta("Capibarismo");
    Preguntas gogo2 = new Preguntas();
    gogo2.setId_pregunta(2);
    gogo2.setRespuesta("IBIZArap");
    Preguntas gogo3 = new Preguntas();
    gogo3.setId_pregunta(3);
    gogo3.setRespuesta("Sebastian Villalobos");
    ArrayList <Preguntas> agogo = new ArrayList<>();
    agogo.add(gogo);
    agogo.add(gogo2);
    agogo.add(gogo3);
    Usuarios oky = new Usuarios();
    Permisos yeye = new Permisos();
    ArrayList <Integer> permisitos = new ArrayList<>();
    permisitos.add(3);
    permisitos.add(2);
    permisitos.add(1);
    yeye.setMisPermisos(permisitos);
    ArrayList<Permisos> permisongos = new ArrayList<>();
    permisongos.add(yeye);
    Cargos yape = new Cargos(1,"Gerente");
    
    oky.pruebaAgregandoUsuarios("Pepian12", "Pepe", "pepito123", yape, agogo, permisongos);
    }
*/

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}

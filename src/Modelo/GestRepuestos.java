
package Modelo;


public class GestRepuestos {
    private static Repuesto[] repuestos = new Repuesto [100]; // limite de 100 items
    private static int repuestoSelec; // Cable seleccionado
    private static int repuestoCont = 0; // Contador de cables
    
        static{
        //Esquema: codigo , tipo: tipo de repuesto,marca,cantidad, tamano
        repuestos[repuestoCont]=new Repuesto("R2001","tope","Tevez",10,"1x2 cm");
        repuestoCont++;
        repuestos[repuestoCont]=new Repuesto("R2211","gancho","Desconocido",1,"1x1x3cm");
        repuestoCont++;
        repuestos[repuestoCont]=new Repuesto("R2034","reten","Coreano",4,"1 pulgada");
        repuestoCont++;
        repuestos[repuestoCont]=new Repuesto("R2011","funda","Desconocido",20,"10 cm");
        repuestoCont++;  
    }
        
    public static boolean agregarRepuesto(String codigo,String tipo,String marca,int cantidad,String tamano){
        if(repuestoCont < 100){
            repuestos[repuestoCont]=new Repuesto(codigo,tipo,marca,cantidad,tamano);
            repuestoCont++;
            return true;
        }else{
            return false;
        }
    }
    
    public static Repuesto[] getRepuestos() {
        return repuestos;
    }
    public boolean EliminarRepuesto(int indicerepuesto){
        repuestos[indicerepuesto-1] = new Repuesto(null,null,null,0,null);
        repuestoCont --;
        return true;
    }
            //Contador de cables get y set
    public static int getRepuestoCont() {
        return repuestoCont;
    }

    public static void setRepuestoCont(int repuestoCont) {
        GestRepuestos.repuestoCont = repuestoCont;
    }
    //Identificador de cables get y set
    public static int getRepuestoSelec() {
        return repuestoSelec;
    }
    public static void setRepuestoSelec(int repuestoSelec) {
        GestRepuestos.repuestoSelec = repuestoSelec;
    }
    

    //Atributos
    public static String getCodigos(int indice){
        return repuestos[indice].getCodigo();
    }
    
    public static void setCodigos(int indice,String codigo) {
        repuestos[indice].setCodigo(codigo);
    }
    public static String getTipos(int indice){
        return repuestos[indice].getTipo();
    }
    
    public static void setTipos(int indice,String tipos) {
        repuestos[indice].setTipo(tipos);
    }
    public static String getMarcas(int indice){
        return repuestos[indice].getMarca();
    }
    
    public static void setMarcas(int indice,String marca) {
        repuestos[indice].setMarca(marca);
    }
    public static int getCantidades(int indice){
        return repuestos[indice].getCantidad();
    }
    public static void setCantidades(int indice,int cantidad) {
        repuestos[indice].setCantidad(cantidad);
    }
    public static String getTamanos(int indice){
        return repuestos[indice].getTamano();
    }
    
    public static void setTamanos(int indice,String tamano) {
        repuestos[indice].setTamano(tamano);
    }    
    
}

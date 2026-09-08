
package Modelo;

public class GestCables {
    private static Cable[] cables = new Cable [100]; // limite de 100 items
    private static int cableSelec; // Cable seleccionado
    private static int cableCont = 0; // Contador de cables
    

 
    public static Cable[] getCables() {
        return cables;
    }

    
        //Contador de cables get y set
    public static int getCableCont() {
        return cableCont;
    }

    public static void setCableCont(int cableCont) {
        GestCables.cableCont = cableCont;
    }
    //Identificador de cables get y set
    public static int getCableSelec() {
        return cableSelec;
    }

    public static void setCableSelec(int cableSelec) {
        GestCables.cableSelec = cableSelec;
    }
    //Atributos
    public static String getCodigos(int indice){
        return cables[indice].getCodigo();
    }
    
    public static void setCodigos(int indice,String codigo) {
        cables[indice].setCodigo(codigo);
    }
    
    public static String getTipos(int indice){
        return cables[indice].getTipo();
    }
    
    public static void setTipos(int indice,String tipo) {
        cables[indice].setTipo(tipo);
    }
    public static String getMarca_autos(int indice){
        return cables[indice].getMarca_auto();
    }
    
    public static void setMarca_autos(int indice,String marca_auto) {
        cables[indice].setMarca_auto(marca_auto);
    }
    public static String getModelo_autos(int indice){
        return cables[indice].getModelo_auto();
    }
    
    public static void setModelo_autos(int indice,String modelo_auto) {
        cables[indice].setModelo_auto(modelo_auto);
    }
    public static int getCantidades(int indice){
        return cables[indice].getCantidad();
    }
    public static void setCantidades(int indice,int cantidad) {
        cables[indice].setCantidad(cantidad);
    }
    public static String getMarcaCable(int indice){
        return cables[indice].getMarcaC();
    }
    
    public static void setMarcaCable(int indice,String marcaC) {
        cables[indice].setMarcaC(marcaC);
    }    
    
    public static double getPrecioUnts(int indice){
        return cables[indice].getPrecioUnt();
    }
    public static void setPrecioUnts(int indice,double precioUnts){
        cables[indice].setPrecioUnt(precioUnts);
    }
    
}

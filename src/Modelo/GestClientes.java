
package Modelo;

public class GestClientes {
    private static Cliente[] clientes= new Cliente[100]; // limite de 100 clientes
    private static int clienteSelec; // Cable seleccionado
    private static int clienteCont = 0; // Contador de cables
    private static String factura;
    
    static{
        //Esquema: String nombre,String rucDni,String numeroFactura,String codigosPedidos,String cantidadesPedidos,String montoT
        clientes[clienteCont]=new Cliente("Pedro Ramirez","17652344","F0010","C20617","1",20.50);
        clienteCont++;
        clientes[clienteCont]=new Cliente("Italy Colors","20312320","F0011","C20617","1",20.50);
        clienteCont++;        
    }
    
    public static boolean agregarCliente(String nombre,String rucDni,String numeroFactura,String codigosPedidos,String cantidadesPedidos,double montoT){
        if(clienteCont < 100){
            clientes[clienteCont] = new Cliente(nombre,rucDni,numeroFactura,codigosPedidos,cantidadesPedidos,montoT);
            clienteCont++;
            return true;
        }else{
            return false;
        }
    }
    
    
    
    public boolean EliminarCliente(int indice){
        clientes[clienteCont-1] = new Cliente(null,null,null,null,null,0);
        clienteCont --;
        return true;
    }
    public static Cliente[] getClientes() {
        return clientes;
    } 
    
    public static String getFactura(){
        return factura;
    }
    public static void setFactura(String factura){
        GestClientes.factura = factura;
    }
    //Contador de cables get y set
    public static int getClienteCont() {
        return clienteCont;
    }

    public static void setClienteCont(int clienteCont) {
        GestClientes.clienteCont = clienteCont;
    }
    //Identificador de cables get y set
    public static int getClienteSelec() {
        return clienteSelec;
    }

    public static void setCableSelec(int clienteSelec) {
        GestClientes.clienteSelec = clienteSelec;
    }
    //atributos
    public static String getNombres(int indice){
        return clientes[indice].getNombre();
    }
    
    public static void setNombres(int indice,String nombre) {
        clientes[indice].setNombre(nombre);
    }

    public static String getRucDnis(int indice){
        return clientes[indice].getRucDni();
    }
    
    public static void setRucDnis(int indice,String rucDni) {
        clientes[indice].setRucDni(rucDni);
    }
    
    public static String getNumeroFacturas(int indice){
        return clientes[indice].getNumeroFactura();
    }
    
    public static void setNumeroFacturas(int indice,String numeroFactura) {
        clientes[indice].setNumeroFactura(numeroFactura);
    }
    
    public static String getCodigosPedidoss(int indice){
        return clientes[indice].getCodigosPedidos();
    }
    
    public static void setCodigosPedidoss(int indice,String codigosPedidos) {
        clientes[indice].setCodigosPedidos(codigosPedidos);
    }
    public static String getCantidadesPedidoss(int indice){
        return clientes[indice].getCantidadesPedidos();
    }
    
    public static void setCantidadesPedidoss(int indice,String cantidadesPedidos) {
        clientes[indice].setCantidadesPedidos(cantidadesPedidos);
    }

    public static double getMontoTs(int indice){
        return clientes[indice].getMontoT();
    }
    
    public static void setMontoTs(int indice,double montoT) {
        clientes[indice].setMontoT(montoT);
    }    
}

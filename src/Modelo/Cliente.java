
package Modelo;

public class Cliente {
    private String nombre;
    private String rucDni;
    private String numeroFactura;
    private String codigosPedidos;
    private String cantidadesPedidos;
    private double montoT;
    
    public Cliente(String nombre,String rucDni,String numeroFactura,String codigosPedidos,String cantidadesPedidos,double montoT){
    
        this.nombre = nombre;
        this.rucDni = rucDni;
        this.numeroFactura = numeroFactura;
        this.cantidadesPedidos = cantidadesPedidos;
        this.montoT = montoT;
        
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRucDni() {
        return rucDni;
    }

    public void setRucDni(String rucDni) {
        this.rucDni = rucDni;
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getCodigosPedidos() {
        return codigosPedidos;
    }

    public void setCodigosPedidos(String codigosPedidos) {
        this.codigosPedidos = codigosPedidos;
    }

    public String getCantidadesPedidos() {
        return cantidadesPedidos;
    }

    public void setCantidadesPedidos(String cantidadesPedidos) {
        this.cantidadesPedidos = cantidadesPedidos;
    }

    public double getMontoT() {
        return montoT;
    }

    public void setMontoT(double montoT) {
        this.montoT = montoT;
    }
    
}

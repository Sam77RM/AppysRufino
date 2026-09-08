
package Modelo;


public class Cable {
    private String codigo;
    private String tipo;
    private String marca_auto;
    private String modelo_auto;
    private int anio_auto;
    private int cantidad;
    private String marcaC;
    private double precioUnt;
    private double precioCosto;
    
    public Cable(){
    }

    public Cable(String codigo, String tipo, String marca_auto, String modelo_auto, int anio_auto, int cantidad, String marcaC, double precioUnt, double precioCosto) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.marca_auto = marca_auto;
        this.modelo_auto = modelo_auto;
        this.anio_auto = anio_auto;
        this.cantidad = cantidad;
        this.marcaC = marcaC;
        this.precioUnt = precioUnt;
        this.precioCosto = precioCosto;
    }
    
    
    public String getCodigo(){
        return codigo;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca_auto() {
        return marca_auto;
    }

    public void setMarca_auto(String marca_auto) {
        this.marca_auto = marca_auto;
    }

    public String getModelo_auto() {
        return modelo_auto;
    }

    public void setModelo_auto(String modelo_auto) {
        this.modelo_auto = modelo_auto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMarcaC() {
        return marcaC;
    }

    public void setMarcaC(String marcaC) {
        this.marcaC = marcaC;
    }
    public double getPrecioUnt(){
        return precioUnt;
    }
    public void setPrecioUnt(double precioUnt){
        this.precioUnt = precioUnt;
    }

    public int getAnio_auto() {
        return anio_auto;
    }

    public void setAnio_auto(int anio_auto) {
        this.anio_auto = anio_auto;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }
    
}

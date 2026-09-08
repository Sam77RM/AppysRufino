/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GeneradorBoleta {


 public static void generarBoletaYGuardarEnArchivo(
        String nombreVendedor,
        String cargoVendedor,
        String nombreObjeto,
        String precioUnitario,
        String cantidad,
        String descuento,
        String montoTotal,
        String idCliente // 👈 nuevo parámetro
    ) {
        try {
            // Ruta al escritorio del usuario
            String ruta = System.getProperty("user.home") + "/Desktop/boleta.txt";
            FileWriter writer = new FileWriter(ruta);

            String fecha = LocalDate.now().toString();

            // Contenido de la boleta
            String contenido = "";
            contenido += "========= RufinoAppSys =========\n";
            contenido += "Fecha: " + fecha + "\n";
            contenido += "ID/RUC Cliente: " + idCliente + "\n"; // 👈 ID o RUC del cliente
            contenido += "--------------------------------\n";
            contenido += "Vendedor: " + nombreVendedor + "\n";
            contenido += "Cargo: " + cargoVendedor + "\n";
            contenido += "--------------------------------\n";
            contenido += "Producto: " + nombreObjeto + "\n";
            contenido += "Precio Unitario: S/ " + precioUnitario + "\n";
            contenido += "Cantidad: " + cantidad + "\n";
            contenido += "Descuento: " + descuento + "%\n";
            contenido += "--------------------------------\n";
            contenido += "TOTAL A PAGAR: S/ " + montoTotal + "\n";
            contenido += "================================\n";
            contenido += "Gracias por su compra. ¡Vuelva pronto!\n";

            // Escribir y cerrar
            writer.write(contenido);
            writer.close();

            System.out.println("Boleta generada correctamente en el escritorio.");

        } catch (IOException e) {
            System.err.println("Error al generar la boleta: " + e.getMessage());
        }
    }
}

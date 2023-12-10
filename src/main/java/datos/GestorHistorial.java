package datos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class GestorHistorial {
    private static final String ARCHIVO_HISTORIAL = "historial.csv";

    public static void agregarEntradaHistorial(String nombreProducto) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_HISTORIAL, true))) {
            // Formato: fecha_hora,producto
            writer.println(System.currentTimeMillis() + "," + nombreProducto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



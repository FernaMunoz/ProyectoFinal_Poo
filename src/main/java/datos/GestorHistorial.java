package datos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestorHistorial {
    private List<String> listaProductosAgregados;

    public GestorHistorial() {
        listaProductosAgregados = new ArrayList<>();
    }

    public List<String> getHistorial() {
        return listaProductosAgregados;
    }

    public void agregarEntradaHistorial(String producto) {
        // Obtener la hora actual
        String horaActual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Agregar entrada al historial
        String entrada = producto + " - " + horaActual;
        listaProductosAgregados.add(entrada);

        // Guardar en el archivo CSV
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("historial.csv", true));
            writer.append(producto).append(",").append(horaActual).append("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

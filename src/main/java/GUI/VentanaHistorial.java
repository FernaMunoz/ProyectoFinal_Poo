package GUI;

import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VentanaHistorial extends JFrame {
    private JTextArea historialTextArea;
    private List<String> listaProductosAgregados;

    public VentanaHistorial(Usuario usuarioActual) {
        super("Historial");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        historialTextArea = new JTextArea();
        historialTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historialTextArea);
        add(scrollPane, BorderLayout.CENTER);

        listaProductosAgregados = new ArrayList<>();

        cargarHistorial();

        setVisible(true);
    }

    private void cargarHistorial() {
        // Lógica para cargar el historial desde el archivo CSV (si es necesario)
        // Puedes implementar esto según tus necesidades
        // ...

        // Ejemplo de cómo podría verse el contenido del historial
        historialTextArea.setText("Historial de productos:\n\n");
        for (String entrada : listaProductosAgregados) {
            historialTextArea.append(entrada + "\n");
        }
    }

    public void agregarEntradaHistorial(String producto) {
        // Obtener la hora actual
        String horaActual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Agregar entrada al historial
        String entrada = producto + " - " + horaActual;
        historialTextArea.append(entrada + "\n");
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

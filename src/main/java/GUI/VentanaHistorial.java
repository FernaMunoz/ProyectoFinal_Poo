package GUI;

import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VentanaHistorial extends JFrame {
    private JTextArea historialTextArea;

    public VentanaHistorial(Usuario usuarioActual) {
        super("Historial");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        historialTextArea = new JTextArea();
        historialTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historialTextArea);
        add(scrollPane, BorderLayout.CENTER);

        cargarHistorial();

        setVisible(true);
    }

    private void cargarHistorial() {
        // Lógica para cargar el historial desde el archivo CSV
        // Implementa esto según tus necesidades
        // ...

        // Ejemplo de cómo podría verse el contenido del historial
        historialTextArea.setText("Historial de productos:\n\n" +
                "Producto A - 2023-01-01 12:00:00\n" +
                "Producto B - 2023-01-02 14:30:00\n");
    }

    public void agregarEntradaHistorial(String producto) {
        // Obtener la hora actual
        String horaActual = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // Agregar entrada al historial
        historialTextArea.append(producto + " - " + horaActual + "\n");

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

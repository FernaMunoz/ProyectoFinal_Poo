package GUI;

import Modelo.Usuario;
import datos.GestorHistorial;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaHistorial extends JFrame {
    private JTextArea historialTextArea;
    private GestorHistorial gestorHistorial;

    public VentanaHistorial(Usuario usuarioActual, GestorHistorial gestorHistorial) {
        super("Historial");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.gestorHistorial = gestorHistorial;

        historialTextArea = new JTextArea();
        historialTextArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(historialTextArea);
        add(scrollPane, BorderLayout.CENTER);

        cargarHistorial();

        setVisible(true);
    }

    public VentanaHistorial(Usuario usuarioActual) {
    }

    private void cargarHistorial() {
        List<String> historial = gestorHistorial.getHistorial();

        historialTextArea.setText("Historial de productos:\n\n");
        for (String entrada : historial) {
            historialTextArea.append(entrada + "\n");
        }
    }

    public void agregarEntradaHistorial(String producto) {
        gestorHistorial.agregarEntradaHistorial(producto);
        cargarHistorial();
    }
}

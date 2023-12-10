package guis;

import javax.swing.*;

public class VentanaNotificadorExito extends JFrame {
    public VentanaNotificadorExito(String productoSeleccionado) {
        super("VentanaNotificadorExito");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel mensaje = new JLabel("Producto " + productoSeleccionado + " fue modificado con éxito");
        mensaje.setHorizontalAlignment(JLabel.CENTER);
        add(mensaje);

        setVisible(true);
    }
}


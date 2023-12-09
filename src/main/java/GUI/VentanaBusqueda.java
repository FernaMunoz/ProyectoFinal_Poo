package GUI;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VentanaBusqueda extends JFrame implements ActionListener {
    public VentanaBusqueda() {
        super("Busqueda Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo rosado3.png"));
        etiqueta1.setBounds(0, 0, 375, 667);
        JLabel etiqueta2 = new JLabel(new ImageIcon("buscar.png"));
        etiqueta2.setBounds(22, 109, 327, 68);

    }
}

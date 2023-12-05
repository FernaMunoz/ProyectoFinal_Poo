package guis;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaRegistro extends JFrame {
    public ventanaRegistro() {
        super("Inventario");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-05 195951.png"));

        etiqueta1.setBounds(0,0,375,667);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

    }
}
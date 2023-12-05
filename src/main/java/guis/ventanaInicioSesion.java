package guis;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ventanaInicioSesion extends JFrame {
    public ventanaInicioSesion(){
        super("Inicio sesion");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-05 202200.png"));
        JTextField nombre = new JTextField("Nombre*");
        JTextField contrasena = new JTextField("Contraseña*");

        etiqueta1.setBounds(0,0,375,667);
        nombre.setBounds(187,333,100,50);
        contrasena.setBounds(30,400,100,50);

        panel.add(nombre);
        panel.add(contrasena);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

    }

}

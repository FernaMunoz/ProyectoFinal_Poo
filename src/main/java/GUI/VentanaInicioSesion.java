package GUI;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.GestorInicioUsuarios;
import datos.GestorRegistroUsuarios;
import Modelo.Usuario;

public class VentanaInicioSesion extends JFrame {
    private JTextField nombre;
    private JPasswordField contrasena;

    public VentanaInicioSesion(){
        super("Inicio sesion");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-05 202200.png"));
        JLabel etiqueta2 = new JLabel("Nombre*");
        nombre = new JTextField();
        JLabel etiqueta3 = new JLabel("Contraseña*");
        contrasena = new JPasswordField();
        JButton botonRegistrar = new JButton("Registrar");
        JButton botonVolver = new JButton("Back");

        etiqueta1.setBounds(0,0,375,667);
        etiqueta2.setBounds(60,238,82,23);
        etiqueta3.setBounds(60,322,102,23);
        nombre.setBounds(47,261,281,51);
        contrasena.setBounds(47,347,281,52);
        botonRegistrar.setBounds(104,418,166,42);
        botonVolver.setBounds(5,5,70,30);

        etiqueta2.setForeground(Color.GRAY);
        etiqueta3.setForeground(Color.GRAY);

        botonRegistrar.setBackground(Color.CYAN);
        botonVolver.setBackground(Color.CYAN);
        nombre.setBorder(new LineBorder(Color.WHITE,2,true));
        contrasena.setBorder(new LineBorder(Color.WHITE,2,true));

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = nombre.getText();
                String password = String.valueOf(contrasena.getPassword());

                GestorInicioUsuarios gestorUsuarios = new GestorInicioUsuarios();
                Usuario usuarioAutenticado = gestorUsuarios.obtAutenticacion(usuario, password);
                if (usuarioAutenticado != null) {
                    dispose();

                    VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuarioAutenticado);
                    ventanaMenuPrincipal.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Autenticacion fallida" );
                }
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
            }
        });

        panel.add(etiqueta2);
        panel.add(etiqueta3);
        panel.add(botonVolver);
        panel.add(nombre);
        panel.add(contrasena);
        panel.add(botonRegistrar);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);
    }
}
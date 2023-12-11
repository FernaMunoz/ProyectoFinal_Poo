package guis;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;
import datos.gestorRegistroUsuarios;
import datos.GestorHistorial;

public class VentanaRegistro extends JFrame {
    private Usuario usuario;
    private JTextField nombre;
    private JTextField nombreEmpresa;
    private JPasswordField contrasena;
    private JPasswordField confContrasena;
    private gestorRegistroUsuarios gestor;
    private GestorHistorial gestorHistorial;

    public VentanaRegistro() {
        super("Registro de usuario");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        gestor = new gestorRegistroUsuarios();
        gestorHistorial = new GestorHistorial();

        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-05 195951.png"));
        JLabel etiqueta2 = new JLabel("Nombre*");
        nombre = new JTextField();
        JLabel etiqueta3 = new JLabel("Nombre empresa*");
        nombreEmpresa = new JTextField();
        JLabel etiqueta4 = new JLabel("Contraseña*");
        contrasena = new JPasswordField();
        JLabel etiqueta5 = new JLabel("Confirmar contraseña*");
        confContrasena = new JPasswordField();

        JButton botonRegistrar = new JButton("Registrar");
        JButton botonVolver = new JButton("Back");

        etiqueta1.setBounds(0,0,375,667);
        etiqueta2.setBounds(65,215,82,23);
        etiqueta3.setBounds(65,292,152,23);
        etiqueta4.setBounds(65,371,100,23);
        etiqueta5.setBounds(65,448,216,23);
        nombre.setBounds(47,240,281,40);
        nombreEmpresa.setBounds(47,320,281,40);
        contrasena.setBounds(47,400,281,40);
        confContrasena.setBounds(47,475,281,40);
        botonRegistrar.setBounds(110,545,166,42);
        botonVolver.setBounds(5,5,70,30);

        etiqueta2.setForeground(Color.GRAY);
        etiqueta3.setForeground(Color.GRAY);
        etiqueta4.setForeground(Color.GRAY);
        etiqueta5.setForeground(Color.GRAY);

        botonRegistrar.setBackground(Color.CYAN);
        botonVolver.setBackground(Color.CYAN);
        nombre.setBorder(new LineBorder(Color.WHITE,2,true));
        nombreEmpresa.setBorder(new LineBorder(Color.WHITE,2,true));
        contrasena.setBorder(new LineBorder(Color.WHITE,2,true));
        confContrasena.setBorder(new LineBorder(Color.WHITE,2,true));

        botonRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nombre.getText();
                    String empresaName = nombreEmpresa.getText();
                    String password = String.valueOf(contrasena.getPassword());
                    String confPassword = String.valueOf(confContrasena.getPassword());

                    usuario = gestor.registrarUsuario(name, empresaName, password, confPassword);
                    gestorHistorial.crearHistorial(usuario);
                    dispose();

                    VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuario);
                    ventanaMenuPrincipal.setVisible(true);

                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "pruebe de nuevo", JOptionPane.ERROR_MESSAGE);
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
        panel.add(etiqueta4);
        panel.add(etiqueta5);
        panel.add(botonVolver);
        panel.add(nombre);
        panel.add(contrasena);
        panel.add(nombreEmpresa);
        panel.add(confContrasena);
        panel.add(botonRegistrar);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);
    }
}
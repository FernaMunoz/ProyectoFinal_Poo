package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame implements ActionListener {
    public VentanaInicio(){
        super("Inventario");
        setSize(375,667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-05 181240.png"));

        etiqueta1.setBounds(0,0,375,667);

        JButton boton1 = new JButton("Iniciar sesión");
        JButton boton2 = new JButton("Registrar");
        boton1.setBackground(Color.WHITE);
        boton2.setBackground(Color.WHITE);
        boton1.setBorder(new LineBorder(Color.WHITE,2,true));
        boton2.setBorder(new LineBorder(Color.WHITE,2,true));

        boton1.setBounds(87,333,200,50);
        boton2.setBounds(87,400,200,50);

        boton1.addActionListener(this);
        boton2.addActionListener(this);

        panel.add(boton1);
        panel.add(boton2);
        panel.add(etiqueta1);

        add(panel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if (e.getActionCommand().equals("Iniciar sesión")) {
            VentanaInicioSesion ventanaIniciosesion = new VentanaInicioSesion();
            ventanaIniciosesion.setVisible(true);
        } else if(e.getActionCommand().equals("Registrar")) {
            VentanaRegistro ventanaRegistro = new VentanaRegistro();
            ventanaRegistro.setVisible(true);
        }
    }
}
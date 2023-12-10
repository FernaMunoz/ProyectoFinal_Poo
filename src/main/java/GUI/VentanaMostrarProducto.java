package GUI;

import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMostrarProducto extends JFrame implements ActionListener {
    public VentanaMostrarProducto(Usuario usuarioActual) {
        super("Mostrar Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo mostrar.png"));
        etiqueta1.setBounds(0, 0, 375, 667);

        JLabel etiqueta2 = new JLabel("Nombre del Producto:");
        JLabel etiqueta3 = new JLabel("Stock:");
        JLabel etiqueta4 = new JLabel("Codigo de barras:");
        JLabel etiqueta5 = new JLabel("Precio:");

        JButton boton = new JButton();
        ImageIcon editar = new ImageIcon("icono Editar.png");

        JButton boton1 = new JButton();
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        etiqueta1.setBounds(198, 184, 375, 667);
        etiqueta2.setBounds(198, 184, 200, 29);
        etiqueta3.setBounds(41, 283, 200, 23);
        etiqueta4.setBounds(41, 334, 200, 23);
        etiqueta5.setBounds(41, 414, 235, 30);
        boton.setBounds(26, 150, 39, 36);
        boton1.setBounds(18, 13, 45, 48);

        boton.setIcon(new ImageIcon(editar.getImage().getScaledInstance(boton.getWidth(), boton.getHeight(), Image.SCALE_SMOOTH)));
        boton1.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));

        etiqueta2.setForeground(Color.GRAY);
        etiqueta3.setForeground(Color.GRAY);
        etiqueta4.setForeground(Color.GRAY);
        etiqueta5.setForeground(Color.GRAY);

        panel.add(boton);
        panel.add(boton1);
        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(etiqueta3);
        panel.add(etiqueta4);
        panel.add(etiqueta5);
        add(panel);
        setVisible(true);

        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaEditarProducto ventanaEditarProducto = new VentanaEditarProducto(usuarioActual);
                ventanaEditarProducto.setVisible(true);

            }
        });

        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaOpciones ventanaOpciones = new VentanaOpciones(usuarioActual);
                ventanaOpciones.setVisible(true);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
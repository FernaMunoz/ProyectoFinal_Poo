package guis;

import modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEditarProducto extends JFrame implements ActionListener {
    private JTextField nombre;
    private JTextField stock;
    private JTextField codigo;
    private JTextField precio;


    public VentanaEditarProducto(Usuario usuarioActual) {
        super("Editar Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo mostrar.png"));
        etiqueta1.setBounds(0, 0, 375, 667);


        nombre = new JTextField();
        stock = new JTextField();
        codigo = new JTextField();
        precio = new JTextField();

        JButton boton = new JButton("Confirmar");

        JButton boton1 = new JButton();
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        etiqueta1.setBounds(198, 184, 375, 667);
        nombre.setBounds(198, 184, 200, 29);
        stock.setBounds(41, 283, 200, 23);
        codigo.setBounds(41, 334, 200, 23);
        precio.setBounds(41, 414, 235, 30);
        boton.setBounds(26, 150, 39, 36);
        boton1.setBounds(18, 13, 45, 48);


        panel.add(boton1);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
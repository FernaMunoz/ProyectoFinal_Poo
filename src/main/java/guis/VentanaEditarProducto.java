package guis;

import modelo.Usuario;
import datos.GestorInventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaEditarProducto extends JFrame implements ActionListener {
    private JTextField nombreEditar;
    private JTextField stockEditar;
    private JTextField codigoEditar;
    private JTextField precioEditar;

    public VentanaEditarProducto(Usuario usuarioActual, String productoSeleccionado) {
        super("Editar Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo mostrar.png"));
        etiqueta1.setBounds(0, 0, 375, 667);

        nombreEditar = new JTextField();
        stockEditar = new JTextField();
        codigoEditar = new JTextField();
        precioEditar = new JTextField();

        JButton boton = new JButton("Confirmar");

        JButton boton1 = new JButton();
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        etiqueta1.setBounds(198, 184, 375, 667);
        nombreEditar.setBounds(198, 184, 200, 29);
        stockEditar.setBounds(41, 283, 200, 23);
        codigoEditar.setBounds(41, 334, 200, 23);
        precioEditar.setBounds(41, 414, 235, 30);
        boton.setBounds(26, 150, 39, 36);
        boton1.setBounds(18, 13, 45, 48);

        panel.add(nombreEditar);
        panel.add(stockEditar);
        panel.add(codigoEditar);
        panel.add(precioEditar);
        panel.add(boton);
        panel.add(boton1);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);


        GestorInventario gestorInventario = new GestorInventario();
        List<String> atributosProducto = gestorInventario.buscarProducto(usuarioActual, productoSeleccionado);
        if (atributosProducto != null) {
            nombreEditar.setText(atributosProducto.get(0));
            stockEditar.setText(atributosProducto.get(1));
            codigoEditar.setText(atributosProducto.get(2));
            precioEditar.setText(atributosProducto.get(3));
        }

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

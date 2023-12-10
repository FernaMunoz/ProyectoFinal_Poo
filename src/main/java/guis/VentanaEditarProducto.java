package guis;

import datos.GestorInventario;
import modelo.Usuario;
import datos.GestorProductos;
import datos.GestorInventario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaEditarProducto extends JFrame implements ActionListener {
    private JTextField nombreEditar;
    private JTextField stockEditar;
    private JTextField precioEditar;
    private GestorProductos gestorProductos;

    public VentanaEditarProducto(Usuario usuarioActual, String productoSeleccionado) {
        super("Editar Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gestorProductos = new GestorProductos();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nombreLabel = new JLabel();
        nombreLabel.setBounds(50, 50, 200, 30);
        nombreEditar = new JTextField();
        nombreEditar.setBounds(50, 80, 200, 30);

        JLabel stockLabel = new JLabel();
        stockLabel.setBounds(50, 120, 200, 30);
        stockEditar = new JTextField();
        stockEditar.setBounds(50, 150, 200, 30);

        JLabel precioLabel = new JLabel();
        precioLabel.setBounds(50, 190, 200, 30);
        precioEditar = new JTextField();
        precioEditar.setBounds(50, 220, 200, 30);

        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(50, 260, 200, 30);


        JButton boton = new JButton("Confirmar");
        boton.setBounds(50, 330, 200, 30);

        panel.add(nombreLabel);
        panel.add(nombreEditar);
        panel.add(stockLabel);
        panel.add(stockEditar);
        panel.add(imagenLabel);
        panel.add(precioLabel);
        panel.add(precioEditar);
        panel.add(boton);
        add(panel);
        setVisible(true);

        GestorInventario gestorUsuario = new GestorInventario();
        List<String> atributosProducto = gestorUsuario.buscarProducto(usuarioActual, productoSeleccionado);
        if (atributosProducto != null) {
            nombreLabel.setText(atributosProducto.get(0));
            stockLabel.setText(atributosProducto.get(1));
            precioLabel.setText(atributosProducto.get(2));
            imagenLabel.setText(atributosProducto.get(3));
        }

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreEditar.getText();
                    int stock = Integer.parseInt(stockEditar.getText());
                    double precio = Double.parseDouble(precioEditar.getText());

                    gestorProductos.modificarProducto(productoSeleccionado, nombre, stock, precio, usuarioActual);
                    new VentanaNotificadorExito(productoSeleccionado);
                    dispose();
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor, introduce un número válido.");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}




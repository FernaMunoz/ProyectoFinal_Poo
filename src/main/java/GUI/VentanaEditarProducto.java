package GUI;

import datos.GestorInventario;
import Modelo.Usuario;
import datos.GestorProductos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaEditarProducto extends JFrame {
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

        JLabel etiqueta1 = new JLabel(new ImageIcon("buscarExistencias-buscarNombre-lentes1.png"));
        ImageIcon volver = new ImageIcon("Group 23 (1).png");

        JLabel nombreLabel = new JLabel();
        nombreEditar = new JTextField();
        JLabel stockLabel = new JLabel();
        stockEditar = new JTextField();
        JLabel precioLabel = new JLabel();
        precioEditar = new JTextField();
        JLabel imagenLabel = new JLabel();
        JButton btnvolver = new JButton();
        JButton boton = new JButton("Confirmar");

        nombreLabel.setBounds(50, 148, 200, 30);
        nombreEditar.setBounds(50, 188, 200, 30);
        stockLabel.setBounds(50, 228, 200, 30);
        stockEditar.setBounds(50, 268, 200, 30);
        precioLabel.setBounds(50, 308, 200, 30);
        precioEditar.setBounds(50, 348, 200, 30);
        imagenLabel.setBounds(50, 388, 200, 30);
        btnvolver.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0, 0, 375, 667);
        boton.setBounds(85, 450, 200, 30);

        btnvolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnvolver.getWidth(), btnvolver.getHeight(), Image.SCALE_SMOOTH)));

        boton.setBackground(Color.WHITE);

        panel.add(nombreLabel);
        panel.add(nombreEditar);
        panel.add(stockLabel);
        panel.add(stockEditar);
        panel.add(imagenLabel);
        panel.add(precioLabel);
        panel.add(precioEditar);
        panel.add(boton);
        panel.add(btnvolver);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        GestorInventario gestorInventario = new GestorInventario();
        List<String> atributosProducto = gestorInventario.buscarProducto(usuarioActual, productoSeleccionado);
        if (atributosProducto != null && atributosProducto.size() >= 4) {
            nombreLabel.setText("Nombre: " + atributosProducto.get(0));
            stockLabel.setText("Stock: " + atributosProducto.get(1));
            precioLabel.setText("Precio: " + atributosProducto.get(2));
            imagenLabel.setText("Imagen: " + atributosProducto.get(3));
        }

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nuevoNombre = nombreEditar.getText();
                    int nuevoStock = Integer.parseInt(stockEditar.getText());
                    double nuevoPrecio = Double.parseDouble(precioEditar.getText());

                    gestorProductos.modificarProducto(productoSeleccionado, nuevoNombre, nuevoStock, nuevoPrecio, usuarioActual);

                    dispose();
                    JOptionPane.showMessageDialog(null, "Producto modificado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                VentanaMostrarProducto ventanaMostrarProducto = new VentanaMostrarProducto(usuarioActual, productoSeleccionado);
                ventanaMostrarProducto.setVisible(true);
            }
        });
    }
}
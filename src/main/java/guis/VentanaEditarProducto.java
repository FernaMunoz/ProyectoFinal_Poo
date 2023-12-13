package guis;

import datos.GestorInventario;
import modelo.Usuario;
import datos.GestorProductos;
import datos.GestorHistorial;
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
    private Usuario usuarioActual;

    private GestorHistorial gestorHistorial;

    public VentanaEditarProducto(Usuario usuarioActual, String productoSeleccionado) {
        super("Editar Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gestorProductos = new GestorProductos();
        gestorHistorial = new GestorHistorial();
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

        JLabel imagenTitleLabel = new JLabel("Imagen:");
        JLabel imagenLabel = new JLabel();
        JLabel barcodeTitleLabel = new JLabel("Código de barras:");
        JLabel barcodeLabel = new JLabel();
        JButton boton = new JButton("Confirmar");

        JButton btnvolver = new JButton();

        nombreLabel.setBounds(50, 148, 200, 30);
        nombreEditar.setBounds(50, 178, 200, 30);
        stockLabel.setBounds(50, 218, 200, 30);
        stockEditar.setBounds(50, 248, 200, 30);
        precioLabel.setBounds(50, 278, 200, 30);
        precioEditar.setBounds(50, 308, 200, 30);
        imagenTitleLabel.setBounds(50, 348, 200, 30);
        imagenLabel.setBounds(50, 378, 200, 30);
        barcodeTitleLabel.setBounds(50, 418, 200, 30);
        barcodeLabel.setBounds(50, 458, 200, 30);
        boton.setBounds(85, 500, 200, 30);
        btnvolver.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0, 0, 375, 667);

        btnvolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnvolver.getWidth(), btnvolver.getHeight(), Image.SCALE_SMOOTH)));

        boton.setBackground(Color.WHITE);

        panel.add(nombreLabel);
        panel.add(nombreEditar);
        panel.add(stockLabel);
        panel.add(stockEditar);
        panel.add(imagenTitleLabel);
        panel.add(imagenLabel);
        panel.add(imagenLabel);
        panel.add(precioLabel);
        panel.add(precioEditar);
        panel.add(barcodeTitleLabel);
        panel.add(barcodeLabel);
        panel.add(boton);
        panel.add(btnvolver);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        GestorInventario gestorUsuario = new GestorInventario();
        List<String> atributosProducto = gestorUsuario.buscarProducto(usuarioActual, productoSeleccionado);
        if (atributosProducto != null) {
            nombreLabel.setText(atributosProducto.get(0));
            stockLabel.setText(atributosProducto.get(1));
            precioLabel.setText(atributosProducto.get(2));
            imagenLabel.setText(atributosProducto.get(3));
            String barcode;
            if (atributosProducto.size() > 4) {
                barcode = atributosProducto.get(4);
            } else {
                barcode = "No tiene código de barras";
            }
            barcodeLabel.setText(barcode);
        }

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreEditar.getText();
                    int stock = Integer.parseInt(stockEditar.getText());
                    double precio = Double.parseDouble(precioEditar.getText());

                    gestorProductos.modificarProducto(productoSeleccionado, nombre, stock, precio, usuarioActual);
                    gestorHistorial.registrarModificacion(usuarioActual, productoSeleccionado, nombre);
                    dispose();
                    JOptionPane.showMessageDialog(null, "Producto modificado con éxito", "Exito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor, introduce un número válido.");
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

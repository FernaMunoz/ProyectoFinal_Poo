package guis;

import datos.GestorProductos;
import modelo.Producto;
import modelo.Usuario;
import modelo.CodigoBarra;
//import modelo.CodigoBarra.CodigoBarraInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaGenerar extends JFrame {
    private Usuario usuarioActual;
    private JComboBox<String> comboBox;
    private JLabel codigoBarra;
    private GestorProductos gestorProductos = new GestorProductos();

    public VentanaGenerar(Usuario usuarioActual, String textoBusqueda) {
        super("Generar Codigo");

        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.usuarioActual = usuarioActual;

        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo rosado3.png"));

        comboBox = new JComboBox<>();
        JButton btnvolver = new JButton();
        JButton btnGenerar = new JButton("Generar código");

        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        codigoBarra = new JLabel();

        btnvolver.setBounds(18, 13, 45, 48);
        comboBox.setBounds(25, 173, 316, 48);
        etiqueta1.setBounds(0, 0, 375, 667);
        codigoBarra.setBounds(50, 380, 50, 50);
        btnGenerar.setBounds(87, 300, 200, 50);
        btnvolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnvolver.getWidth(), btnvolver.getHeight(), Image.SCALE_SMOOTH)));

        btnvolver.setBackground(Color.PINK);
        btnGenerar.setBackground(Color.PINK);
        comboBox.setBackground(Color.WHITE);

        panel.add(comboBox);
        panel.add(btnvolver);
        panel.add(btnGenerar);
        panel.add(codigoBarra);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        buscarProducto(textoBusqueda, usuarioActual);

        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generarYMostrarCodigoAutomatico();
            }
        });

        btnvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaGenerarCodigo ventanaGenerarCodigo = new VentanaGenerarCodigo(usuarioActual);
                ventanaGenerarCodigo.setVisible(true);
            }
        });
    }

    private void buscarProducto(String textoBusqueda, Usuario usuarioActual) {
        List<Producto> productos = gestorProductos.obtenerProductosSimilares(textoBusqueda, usuarioActual);

        for (Producto producto : productos) {
            comboBox.addItem(producto.getNombre());
        }
    }

    private void generarYMostrarCodigoAutomatico() {
            try {
                String productoSeleccionadoNombre = (String) comboBox.getSelectedItem();
                Producto productoSeleccionado = obtenerProducto(productoSeleccionadoNombre);

                if (productoSeleccionado != null) {
                    if (!gestorProductos.productoTieneCodigoBarra(usuarioActual, productoSeleccionado)) {

                        CodigoBarra codigoBarraGenerator = new CodigoBarra();
                        CodigoBarra.CodigoBarraInfo codigoBarraInfo = codigoBarraGenerator.generarCodigoBarra(usuarioActual, productoSeleccionado);

                        gestorProductos.actualizarCSV(usuarioActual, productoSeleccionado);

                        JOptionPane.showMessageDialog(this,
                                "Código generado para '" + productoSeleccionadoNombre + "':\n" + codigoBarraInfo.getCodigoBarras(),
                                "Código de Barras",
                                JOptionPane.INFORMATION_MESSAGE,
                                codigoBarraInfo.getImagenCodigoBarras());
                        System.out.println("El producto '" + productoSeleccionadoNombre + "' ya tiene un código de barras.");

                    } else {
                        JOptionPane.showMessageDialog(this,
                                "El producto '" + productoSeleccionadoNombre + "' ya tiene un código de barras.",
                                "Código de Barras Existente",
                                JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Producto no encontrado: " + productoSeleccionadoNombre, "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
    }

    private Producto obtenerProducto(String nombreProducto) {
        List<Producto> productos = gestorProductos.obtenerProductosSimilares(nombreProducto, usuarioActual);

        if (!productos.isEmpty()) {
            return productos.get(0);
        } else {
            // Si no se encuentra el producto
            throw new IllegalArgumentException("Producto no encontrado: " + nombreProducto);
        }
    }
}

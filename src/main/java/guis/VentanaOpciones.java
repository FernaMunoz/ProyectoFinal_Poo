package guis;
import modelo.Usuario;
import modelo.Producto;
import datos.GestorProductos;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaOpciones extends JFrame {
    private Usuario usuarioActual;
    private JComboBox<String> comboBox;
    private GestorProductos gestorProductos = new GestorProductos();

    public VentanaOpciones(Usuario usuarioActual, String textoBusqueda) {

        super("Resultados de Búsqueda");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.usuarioActual = usuarioActual;

        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo rosado3.png"));

        comboBox = new JComboBox<>();
        JLabel BordeRosa = new JLabel(new ImageIcon("buscarNueva.png"));

        JButton botonSalida = new JButton();
        JButton botonEntrada = new JButton();
        JButton botonBuscar = new JButton();
        JButton botonVolver = new JButton();

        ImageIcon salida = new ImageIcon("salidasProductos.png");
        ImageIcon entrada = new ImageIcon("ingresarProductos icon.png");
        ImageIcon buscar = new ImageIcon("Group 10.png");
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        botonSalida.setBounds(41, 295, 117, 118);
        botonEntrada.setBounds(210, 295, 117, 118);
        botonBuscar.setBounds(128, 451, 117, 118);
        botonVolver.setBounds(18, 13, 45, 48);
        comboBox.setBounds(29, 173, 316, 48);
        etiqueta1.setBounds(0, 0, 375, 667);
        BordeRosa.setBounds(18, 161, 341, 69);

        botonSalida.setIcon(new ImageIcon(salida.getImage().getScaledInstance(botonSalida.getWidth(), botonSalida.getHeight(), Image.SCALE_SMOOTH)));
        botonEntrada.setIcon(new ImageIcon(entrada.getImage().getScaledInstance(botonEntrada.getWidth(), botonEntrada.getHeight(), Image.SCALE_SMOOTH)));
        botonBuscar.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));

        botonSalida.setBackground(Color.WHITE);
        botonEntrada.setBackground(Color.WHITE);
        botonBuscar.setBackground(Color.WHITE);
        botonVolver.setBackground(Color.PINK);
        comboBox.setBackground(Color.WHITE);

        botonSalida.setBorder(new LineBorder(Color.WHITE, 6, true));
        botonEntrada.setBorder(new LineBorder(Color.WHITE, 6, true));
        botonBuscar.setBorder(new LineBorder(Color.WHITE, 6, true));


        panel.add(comboBox);
        panel.add(BordeRosa);
        panel.add(botonSalida);
        panel.add(botonEntrada);
        panel.add(botonBuscar);
        panel.add(botonVolver);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        buscarProducto(textoBusqueda, usuarioActual);

        botonSalida.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String productoSeleccionado = (String) comboBox.getSelectedItem();
                new VentanaSalidaProducto(usuarioActual, productoSeleccionado);
            }
        });

        botonEntrada.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String productoSeleccionado = (String) comboBox.getSelectedItem();
                new VentanaEntradaProducto(usuarioActual, productoSeleccionado);
            }
        });
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                String productoSeleccionado = (String) comboBox.getSelectedItem();
                VentanaMostrarProducto ventanaMostrarProducto = new VentanaMostrarProducto(usuarioActual, productoSeleccionado);
                ventanaMostrarProducto.setVisible(true);
            }
        });

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBuscarPorTexto ventanaBuscarPorTexto = new VentanaBuscarPorTexto(usuarioActual);
                ventanaBuscarPorTexto.setVisible(true);
            }
        });
    }

    private void buscarProducto(String textoBusqueda, Usuario usuarioActual) {
        List<Producto> productos = gestorProductos.obtenerProductosSimilares(textoBusqueda, usuarioActual);

        for (Producto producto : productos) {
            comboBox.addItem(producto.getNombre());
        }
    }
}
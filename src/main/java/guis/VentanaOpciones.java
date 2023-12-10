package guis;
import modelo.Usuario;
import modelo.Producto;
import modelo.Inventario;
import datos.GestorProductos;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaOpciones extends JFrame implements ActionListener{
    private Usuario usuarioActual;
    private JFrame frame;
    private JComboBox<String> comboBox;
    private GestorProductos gestorProductos = new GestorProductos();

    public VentanaOpciones(Usuario usuarioActual, String textoBusqueda) {
        this.usuarioActual = usuarioActual;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame("Resultados de Búsqueda");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(375, 667);
        frame.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon(".png"));

        etiqueta1.setBounds(0, 0, 375, 667);
        comboBox = new JComboBox<>();
        comboBox.setBounds(33, 112, 316, 48);
        panel.add(comboBox);


        JButton boton1 = new JButton();
        JButton boton2 = new JButton();
        JButton boton3 = new JButton();
        JButton boton4 = new JButton();

        ImageIcon entrada = new ImageIcon("ingresarProductos icon.png");
        ImageIcon salida = new ImageIcon("salidasProductos.png");
        ImageIcon buscar = new ImageIcon("buscarExistencias icon.png");
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        boton1.setBounds(50, 334, 117, 118);
        boton2.setBounds(221, 334, 117, 118);
        boton3.setBounds(126,492, 117, 118);
        boton4.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0, 0, 375, 667);

        boton1.setIcon(new ImageIcon(salida.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setIcon(new ImageIcon(entrada.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton4.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));

        boton1.setBackground(Color.WHITE);
        boton2.setBackground(Color.WHITE);
        boton3.setBackground(Color.WHITE);

        boton1.setBorder(new LineBorder(Color.WHITE, 6, true));
        boton2.setBorder(new LineBorder(Color.WHITE, 6, true));
        boton3.setBorder(new LineBorder(Color.WHITE, 6, true));

        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        buscarProducto(textoBusqueda, usuarioActual);

        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String productoSeleccionado = (String) comboBox.getSelectedItem();
                new VentanaSalidaProducto(usuarioActual, productoSeleccionado);
            }
        });

        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String productoSeleccionado = (String) comboBox.getSelectedItem();
                new VentanaEntradaProducto(usuarioActual, productoSeleccionado);
            }
        });

        boton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String productoSeleccionado = (String) comboBox.getSelectedItem();
                VentanaMostrarProducto ventanaMostrarProducto = new VentanaMostrarProducto(usuarioActual, productoSeleccionado);
                ventanaMostrarProducto.setVisible(true);
            }
        });


        boton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaBuscarPorTexto ventanaBuscarPorTexto = new VentanaBuscarPorTexto();
                ventanaBuscarPorTexto.setVisible(true);
            }
        });
    }

    public VentanaOpciones(Usuario usuarioActual) {
    }

    private void buscarProducto(String textoBusqueda, Usuario usuarioActual) {
        List<Producto> productos = gestorProductos.obtenerProductosSimilares(textoBusqueda, usuarioActual);

        for (Producto producto : productos) {
            comboBox.addItem(producto.getNombre());
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
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

        JButton boton1 = new JButton();
        JButton boton2 = new JButton();
        JButton boton3 = new JButton();
        JButton botonvolver = new JButton();

        ImageIcon salida = new ImageIcon("salidasProductos.png");
        ImageIcon entrada = new ImageIcon("ingresarProductos icon.png");
        ImageIcon buscar = new ImageIcon("Group 10.png");
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        boton1.setBounds(41, 295, 117, 118);
        boton2.setBounds(210, 295, 117, 118);
        boton3.setBounds(128, 451, 117, 118);
        botonvolver.setBounds(18, 13, 45, 48);
        comboBox.setBounds(29, 173, 316, 48);
        etiqueta1.setBounds(0, 0, 375, 667);

        boton1.setIcon(new ImageIcon(salida.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setIcon(new ImageIcon(entrada.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        botonvolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonvolver.getWidth(), botonvolver.getHeight(), Image.SCALE_SMOOTH)));

        boton1.setBackground(Color.WHITE);
        boton2.setBackground(Color.WHITE);
        boton3.setBackground(Color.WHITE);
        botonvolver.setBackground(Color.PINK);
        comboBox.setBackground(Color.WHITE);

        boton1.setBorder(new LineBorder(Color.WHITE, 6, true));
        boton2.setBorder(new LineBorder(Color.WHITE, 6, true));
        boton3.setBorder(new LineBorder(Color.WHITE, 6, true));

        panel.add(comboBox);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(botonvolver);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        buscarProducto(textoBusqueda, usuarioActual);

        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        boton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        botonvolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaBuscarPorTexto ventanaBuscarPorTexto = new VentanaBuscarPorTexto();
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

   /* public void mostrarVentana() {
        .setVisible(true);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
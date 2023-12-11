package GUI;
import Modelo.Usuario;
import Modelo.Producto;
import Modelo.Inventario;
import datos.GestorProductos;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class VentanaOpcionesBarras extends JFrame implements ActionListener{
    private String nombreProducto;
    private Usuario usuarioActual;
    private JFrame frame;
    private JLabel label;
    private GestorProductos gestorProductos = new GestorProductos();

    public VentanaOpcionesBarras(Usuario usuarioActual, String nombreProducto) {
        this.usuarioActual = usuarioActual;
        this.nombreProducto = nombreProducto;
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame = new JFrame("Resultados de Búsqueda");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(375, 667);
        frame.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon(".png"));

        etiqueta1.setBounds(0, 0, 375, 667);
        label = new JLabel(nombreProducto);
        label.setBounds(33, 112, 316, 48);
        panel.add(label);

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

        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nombreProducto = (String) label.getText();
                new VentanaSalidaProducto(usuarioActual, nombreProducto);
            }
        });

        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nombreProducto = (String) label.getText();
                new VentanaEntradaProducto(usuarioActual, nombreProducto);
            }
        });

        boton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String nombreProductoSinComillas = nombreProducto.replace("\"", "");
                VentanaMostrarProducto ventanaMostrarProducto = new VentanaMostrarProducto(usuarioActual, nombreProductoSinComillas);
                ventanaMostrarProducto.setVisible(true);
            }
        });




        boton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaBuscarCodigoBarras ventanaBuscarCodigoBarras = new VentanaBuscarCodigoBarras();
                ventanaBuscarCodigoBarras.setVisible(true);
            }
        });
    }

    public VentanaOpcionesBarras(Usuario usuarioActual) {
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
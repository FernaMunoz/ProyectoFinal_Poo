package guis;
import modelo.Usuario;
import datos.GestorProductos;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaOpcionesBarras extends JFrame {

    private String nombreProducto;
    private Usuario usuarioActual;
    private JLabel label;
    private GestorProductos gestorProductos = new GestorProductos();

    public VentanaOpcionesBarras(Usuario usuarioActual, String nombreProducto) {
        super("Resultados de Búsqueda");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.usuarioActual = usuarioActual;
        this.nombreProducto = nombreProducto;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("buscarExistencias-buscarNombre-lentes1.png"));

        label = new JLabel(nombreProducto);

        JButton boton1 = new JButton();
        JButton boton2 = new JButton();
        JButton boton3 = new JButton();
        JButton boton4 = new JButton();

        ImageIcon entrada = new ImageIcon("ingresarProductos icon.png");
        ImageIcon salida = new ImageIcon("salidasProductos.png");
        ImageIcon buscar = new ImageIcon("Group 10.png");
        ImageIcon volver = new ImageIcon("Group 23 (1).png");

        label.setBounds(33, 130, 316, 48);
        boton1.setBounds(50, 234, 117, 118);
        boton2.setBounds(221, 234, 117, 118);
        boton3.setBounds(126,392, 117, 118);
        boton4.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0, 0, 375, 667);

        boton1.setIcon(new ImageIcon(salida.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setIcon(new ImageIcon(entrada.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton4.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));

        boton1.setBackground(Color.WHITE);
        boton2.setBackground(Color.WHITE);
        boton3.setBackground(Color.WHITE);

        boton1.setBorder(new LineBorder(Color.WHITE, 6, true));
        boton2.setBorder(new LineBorder(Color.WHITE, 6, true));
        boton3.setBorder(new LineBorder(Color.WHITE, 6, true));

        panel.add(label);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        VentanaOpcionesBarras ventanaActual = this;

        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                String nombreProductoSinComillas = nombreProducto.replace("\"", "");
                new VentanaSalidaProducto(usuarioActual, nombreProductoSinComillas);
            }
        });

        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                String nombreProductoSinComillas = nombreProducto.replace("\"", "");
                new VentanaEntradaProducto(usuarioActual, nombreProductoSinComillas);
            }
        });

        boton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                String nombreProductoSinComillas = nombreProducto.replace("\"", "");
                VentanaMostrarProducto ventanaMostrarProducto = new VentanaMostrarProducto(usuarioActual, nombreProductoSinComillas);
                ventanaMostrarProducto.setVisible(true);
            }
        });


        boton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscarCodigoBarras ventanaBuscarCodigoBarras = new VentanaBuscarCodigoBarras(usuarioActual);
                ventanaBuscarCodigoBarras.setVisible(true);
            }
        });
    }

}

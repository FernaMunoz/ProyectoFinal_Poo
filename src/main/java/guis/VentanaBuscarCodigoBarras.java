package guis;
import modelo.Usuario;
import datos.GestorInventario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaBuscarCodigoBarras extends JFrame {
    private JTextField codigobarrasbusqueda;
    private GestorInventario gestorInventario;

    public VentanaBuscarCodigoBarras(Usuario usuarioActual) {
        super("Buscar producto por código de barras");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo rosado3.png"));

        JLabel etiqueta2 = new JLabel(new ImageIcon("buscar.png"));
        codigobarrasbusqueda = new JTextField();
        JButton boton1 = new JButton("Buscar");
        JButton boton2 = new JButton();
        ImageIcon volver = new ImageIcon("Group 9 (1).png");

        etiqueta2.setBounds(22, 109, 327, 68);
        etiqueta1.setBounds(0, 0, 375, 667);
        codigobarrasbusqueda.setBounds(26, 150, 310, 50);
        boton1.setBounds(115, 228, 137, 53);
        boton2.setBounds(18, 13, 45, 48);

        boton2.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));

        boton1.setBackground(Color.pink);
        boton2.setBackground(Color.pink);

        boton1.setBorder(new LineBorder(Color.WHITE, 2, true));
        boton2.setBorder(new LineBorder(Color.WHITE, 2, true));

        panel.add(etiqueta2);
        panel.add(codigobarrasbusqueda);
        panel.add(boton1);
        panel.add(boton2);
        panel.add(etiqueta1);

        add(panel);
        setVisible(true);

        gestorInventario = new GestorInventario();

        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                String codigoBarraBusqueda = codigobarrasbusqueda.getText();
                List<String> producto = gestorInventario.buscarProductoPorCodigoBarra(usuarioActual, codigoBarraBusqueda);
                if (producto != null) {
                    VentanaOpcionesBarras ventanaOpcionesBarras = new VentanaOpcionesBarras(usuarioActual, producto.get(0));
                    ventanaOpcionesBarras.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "El producto no tiene un código de barras asociado.");
                }
            }
        });

        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscar ventanaBuscar = new VentanaBuscar(usuarioActual);
                ventanaBuscar.setVisible(true);
            }
        });
    }
}

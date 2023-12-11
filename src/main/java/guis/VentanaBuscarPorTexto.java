package guis;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBuscarPorTexto extends JFrame {
    private JTextField buscar;
    public VentanaBuscarPorTexto(Usuario usuarioActual) {
        super("Buscar producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel labelFondo = new JLabel(new ImageIcon("fondo rosado3.png"));

        JLabel BordeRosa = new JLabel(new ImageIcon("buscarNueva.png"));
        buscar = new JTextField();

        JButton botonBuscar = new JButton("Buscar");
        JButton botonVolver = new JButton();

        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        botonBuscar.setBounds(115, 228, 137, 53);
        botonVolver.setBounds(18, 13, 45, 48);
        BordeRosa.setBounds(18, 141, 327, 68);
        buscar.setBounds(26, 150, 310, 50);
        labelFondo.setBounds(0, 0, 375, 667);

        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));

        botonBuscar.setBackground(Color.pink);
        botonVolver.setBackground(Color.pink);

        botonBuscar.setBorder(new LineBorder(Color.WHITE, 2, true));
        botonVolver.setBorder(new LineBorder(Color.WHITE, 2, true));

        panel.add(BordeRosa);
        panel.add(buscar);
        panel.add(botonBuscar);
        panel.add(botonVolver);
        panel.add(labelFondo);

        add(panel);
        setVisible(true);

        botonBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                String textoBusqueda = buscar.getText();
                VentanaOpciones ventanaOpciones = new VentanaOpciones(usuarioActual, textoBusqueda);
                ventanaOpciones.setVisible(true);
            }
        });

        botonVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscar ventanaBuscar = new VentanaBuscar(usuarioActual);
                ventanaBuscar.setVisible(true);
            }
        });

    }

}

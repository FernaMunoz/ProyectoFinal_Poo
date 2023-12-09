package guis;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBuscarPorTexto extends JFrame implements ActionListener {
    private JTextField buscar;
    public VentanaBuscarPorTexto(Usuario usuarioActual) {
        super("Buscar producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo rosado3.png"));
        etiqueta1.setBounds(0, 0, 375, 667);
        JLabel etiqueta2 = new JLabel(new ImageIcon("buscar.png"));
        etiqueta2.setBounds(22, 109, 327, 68);
        buscar = new JTextField();

        JButton boton1 = new JButton("Buscar");
        JButton boton2 = new JButton();

        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        buscar.setBounds(26, 150, 310, 50);

        boton1.setBounds(115, 228, 137, 53);
        boton2.setBounds(18, 13, 45, 48);


        boton2.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));


        boton1.setBackground(Color.pink);
        boton2.setBackground(Color.pink);

        boton1.setBorder(new LineBorder(Color.WHITE, 2, true));
        boton2.setBorder(new LineBorder(Color.WHITE, 2, true));

        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(buscar);
        panel.add(boton1);
        panel.add(boton2);

        add(panel);
        setVisible(true);


        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String textoBusqueda = buscar.getText();
                VentanaOpciones ventanaOpciones = new VentanaOpciones(usuarioActual, textoBusqueda);
                ventanaOpciones.setVisible(true);
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

    public VentanaBuscarPorTexto() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

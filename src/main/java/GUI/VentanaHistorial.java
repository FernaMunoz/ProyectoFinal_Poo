package GUI;
import Modelo.Usuario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VentanaHistorial extends JFrame implements ActionListener {
    public VentanaHistorial(Usuario usuarioActual){
        super("Menu principal");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo naranjo1.png"));

        JButton boton1 = new JButton();
        JButton boton2 = new JButton();
        JButton boton3 = new JButton();
        JButton boton4 = new JButton();

        ImageIcon calendario = new ImageIcon("calendario.png");
        ImageIcon buscar = new ImageIcon("buscarExistencias icon.png");
        ImageIcon scanner = new ImageIcon("Group 5.png");

        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        boton1.setBounds(115, 140, 125, 126);
        boton2.setBounds(32, 329, 125, 126);
        boton3.setBounds(202, 329, 125, 126);
        boton4.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0,0,375,667);

        boton1.setIcon(new ImageIcon(calendario.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setIcon(new ImageIcon(scanner.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton4.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));

        boton1.setBackground(Color.WHITE);
        boton2.setBackground(Color.WHITE);
        boton3.setBackground(Color.WHITE);
        boton4.setBackground(Color.ORANGE);

        boton1.setBorder(new LineBorder(Color.WHITE,6,true));
        boton2.setBorder(new LineBorder(Color.WHITE,6,true));
        boton3.setBorder(new LineBorder(Color.WHITE,8,true));


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
        boton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuarioActual);
                ventanaMenuPrincipal.setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
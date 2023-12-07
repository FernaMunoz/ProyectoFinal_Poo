package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaMenu extends JFrame implements ActionListener {
    public VentanaMenu() {
        super("Inventario");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-06 150758.png"));


        JButton botonEntrada = new JButton("1");
        JButton botonSalida = new JButton("2");
        JButton botonBuscar = new JButton("3");
        JButton botonScanner = new JButton("4");
        JButton botonHistorial = new JButton("5");
        JButton botonAgregar = new JButton("6");

        botonEntrada.setBounds(43, 130, 117, 118);
        botonSalida.setBounds(196, 130, 117, 118);
        botonBuscar.setBounds(43, 280, 117, 117);
        botonScanner.setBounds(196, 280, 117, 118);
        botonHistorial.setBounds(43, 430, 117, 118);
        botonAgregar.setBounds(196, 430, 117, 118);
        etiqueta1.setBounds(0, 0, 375, 667);



        botonEntrada.addActionListener(this);
        botonSalida.addActionListener(this);
        botonBuscar.addActionListener(this);
        botonScanner.addActionListener(this);
        botonHistorial.addActionListener(this);
        botonAgregar.addActionListener(this);


        panel.add(botonEntrada);
        panel.add(botonSalida);
        panel.add(botonBuscar);
        panel.add(botonScanner);
        panel.add(botonHistorial);
        panel.add(botonAgregar);
        panel.add(etiqueta1);

        add(panel);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if (e.getActionCommand().equals("7")) {
            VentanaMenu ventanaMenu = new VentanaMenu();
        }

    }
}

package guis;

import datos.GestorInventario;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInventario extends JFrame {
    public VentanaInventario(Usuario usuarioActual) {
        super("Tabla de Productos");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("inventario 1.png"));
        ImageIcon volver = new ImageIcon("Group 25.png");

        DefaultTableModel modeloTabla = GestorInventario.cargarInventario(usuarioActual.getNombre());

        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        JButton boton = new JButton();

        boton.setBounds(18,13,45,48);
        scrollPane.setBounds(0,73,375,667);
        etiqueta1.setBounds(0,0,375,667);

        boton.setIcon(new ImageIcon(volver.getImage().getScaledInstance(45, 48, Image.SCALE_SMOOTH)));

        panel.add(boton);
        panel.add(scrollPane);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuarioActual);
                ventanaMenuPrincipal.setVisible(true);
            }

        });


    }
}

package guis;

import datos.GestorInventario;
import modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaInventario extends JFrame {
    public VentanaInventario(Usuario usuarioActual) {
        super("Tabla de Productos");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Crear el panel principal con BorderLayout
        JPanel panel = new JPanel(new BorderLayout());

        // Crear el fondo con una etiqueta
        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo naranja2.png"));
        etiqueta1.setOpaque(false);
        panel.add(etiqueta1, BorderLayout.CENTER);


        DefaultTableModel modeloTabla = GestorInventario.cargarInventario(usuarioActual.getNombre());


        JTable tabla = new JTable(modeloTabla);


        JScrollPane scrollPane = new JScrollPane(tabla);


        panel.add(scrollPane, BorderLayout.CENTER);


        JButton boton = new JButton();
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");
        boton.setIcon(new ImageIcon(volver.getImage().getScaledInstance(45, 48, Image.SCALE_SMOOTH)));
        boton.addActionListener(e -> {
            VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuarioActual);
            ventanaMenuPrincipal.setVisible(true);

        });

        panel.add(boton, BorderLayout.NORTH);
        add(panel);
        setVisible(true);
    }
}

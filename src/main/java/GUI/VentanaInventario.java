package GUI;

import Modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        etiqueta1.setOpaque(false); //
        panel.add(etiqueta1, BorderLayout.CENTER);

        // Crear el modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("nombre");
        modeloTabla.addColumn("stock");
        modeloTabla.addColumn("precio");

        // Leer los datos del CSV y agregarlos al modelo de la tabla
        try (BufferedReader br = new BufferedReader(new FileReader("fer_inventario.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                modeloTabla.addRow(datos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Crear la tabla con el modelo
        JTable tabla = new JTable(modeloTabla);

        // Agregar la tabla a un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Agregar el JScrollPane al panel
        panel.add(scrollPane, BorderLayout.CENTER);

        // Crear el botón de volver
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

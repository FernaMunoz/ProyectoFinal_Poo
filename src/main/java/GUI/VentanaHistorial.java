package GUI;

import Modelo.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class VentanaHistorial extends JFrame {
    private JTable tablaHistorial;
    private DefaultTableModel modeloHistorial;

    public VentanaHistorial(Usuario usuarioActual) {
        super("Historial de Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Crear la tabla para mostrar el historial
        modeloHistorial = new DefaultTableModel();
        modeloHistorial.addColumn("Fecha y Hora");
        modeloHistorial.addColumn("Producto");
        tablaHistorial = new JTable(modeloHistorial);

        JScrollPane scrollPane = new JScrollPane(tablaHistorial);
        add(scrollPane);

        setVisible(false);
    }

    // Método para agregar una entrada al historial
    public void agregarEntradaHistorial(String producto) {
        Date fechaHoraActual = new Date();
        modeloHistorial.addRow(new Object[]{fechaHoraActual, producto});
    }
}

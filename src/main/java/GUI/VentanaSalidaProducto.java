package GUI;

import Modelo.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaSalidaProducto extends JFrame implements ActionListener{

    private JFrame frame;
    private JLabel labelCantidad;
    private int cantidad = 0; // Cantidad inicial

    public VentanaSalidaProducto(Usuario usuarioActual) {

        frame = new JFrame("Seleccionar Stock de sañida");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375, 667);
        frame.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("salidasProductos.png"));

        etiqueta1.setBounds(0, 0, 375, 667);

        // Etiqueta para mostrar la cantidad actual
        labelCantidad = new JLabel("Cantidad: " + cantidad);
        labelCantidad.setBounds(150, 250, 150, 25);
        frame.add(labelCantidad);

        // Botón "Más" para aumentar la cantidad
        JButton masButton = new JButton("+");
        masButton.setBounds(265, 235, 52, 49);
        masButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarCantidad();
            }
        });
        frame.add(masButton);

        // Botón "Menos" para disminuir la cantidad
        JButton menosButton = new JButton("-");
        menosButton.setBounds(45, 235, 52, 49);
        menosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disminuirCantidad();
            }
        });
        frame.add(menosButton);

        // Botón para mostrar la cantidad seleccionada
        JButton mostrarCantidadButton = new JButton("Completar Salida");
        mostrarCantidadButton.setBounds(95, 316, 166, 42);
        mostrarCantidadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCantidad();
            }
        });
        frame.add(mostrarCantidadButton);

        // Hacer la ventana visible
        frame.setVisible(true);
    }

    // Método para aumentar la cantidad
    private void aumentarCantidad() {
        cantidad++;
        actualizarLabelCantidad();
    }

    // Método para disminuir la cantidad
    private void disminuirCantidad() {
        if (cantidad > 0) {
            cantidad--;
            actualizarLabelCantidad();
        }
    }

    // Método para actualizar la etiqueta de la cantidad
    private void actualizarLabelCantidad() {
        labelCantidad.setText("Cantidad: " + cantidad);
    }

    // Método para mostrar la cantidad seleccionada
    private void mostrarCantidad() {
        JOptionPane.showMessageDialog(frame, "Cantidad seleccionada: " + cantidad);
    }


    public void setVisible(boolean b) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



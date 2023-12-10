package GUI;
import Modelo.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.GestorProductos;

public class VentanaEntradaProducto extends JFrame implements ActionListener {

    private JFrame frame;
    private JTextField textFieldCantidad;
    private int cantidad = 0;
    private Usuario usuarioActual;
    private String productoSeleccionado;
    private GestorProductos gestorProductos = new GestorProductos();

    public VentanaEntradaProducto(Usuario usuarioActual, String productoSeleccionado) {
        this.usuarioActual = usuarioActual;
        this.productoSeleccionado = productoSeleccionado;

        frame = new JFrame("Seleccionar Stock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(375, 667);
        frame.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("fondoEntrada.png"));
        etiqueta1.setBounds(0, 0, 375, 667);

        JLabel label = new JLabel("Cantidad");
        label.setBounds(135, 230, 150, 25);
        frame.add(label);

        textFieldCantidad = new JTextField("0");
        textFieldCantidad.setBounds(135, 250, 120, 25);
        frame.add(textFieldCantidad);

        JButton masButton = new JButton();
        ImageIcon mas = new ImageIcon("mas.png");
        masButton.setBounds(265, 235, 52, 49);
        masButton.setIcon(new ImageIcon(mas.getImage().getScaledInstance(masButton.getWidth(), masButton.getHeight(), Image.SCALE_SMOOTH)));
        masButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarCantidad();
            }
        });
        frame.add(masButton);

        JButton menosButton = new JButton();
        ImageIcon menos = new ImageIcon("menos1.png");
        menosButton.setBounds(45, 235, 52, 49);
        menosButton.setIcon(new ImageIcon(menos.getImage().getScaledInstance(menosButton.getWidth(), menosButton.getHeight(), Image.SCALE_SMOOTH)));
        menosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disminuirCantidad();
            }
        });
        frame.add(menosButton);

        JButton confirmarButton = new JButton("Confirmar Entrada");
        confirmarButton.setBounds(95, 316, 166, 42);
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCantidad();
                gestorProductos.entradaStock(cantidad, usuarioActual, productoSeleccionado);
            }
        });
        frame.add(confirmarButton);

        JButton botonVolver = new JButton();
        botonVolver.setBounds(18, 13, 45, 48);
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");
        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VentanaOpciones ventanaOpciones = new VentanaOpciones(usuarioActual, productoSeleccionado);
                ventanaOpciones.setVisible(true);
            }
        });
        frame.add(confirmarButton);

        frame.setVisible(true);
    }

    private void aumentarCantidad() {
        cantidad = Integer.parseInt(textFieldCantidad.getText());
        cantidad++;
        actualizarTextFieldCantidad();
    }

    private void disminuirCantidad() {
        cantidad = Integer.parseInt(textFieldCantidad.getText());
        if (cantidad > 0) {
            cantidad--;
            actualizarTextFieldCantidad();
        }
    }

    private void actualizarTextFieldCantidad() {
        textFieldCantidad.setText(String.valueOf(cantidad));
    }

    private void mostrarCantidad() {
        JOptionPane.showMessageDialog(frame, "Cantidad seleccionada: " + cantidad);
    }

    public void setVisible(boolean b) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
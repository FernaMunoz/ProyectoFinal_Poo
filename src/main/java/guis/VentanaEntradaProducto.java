package guis;
import datos.GestorHistorial;
import modelo.Usuario;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.GestorProductos;

public class VentanaEntradaProducto extends JFrame  {

    private JTextField textFieldCantidad;
    private int cantidad = 0;
    private Usuario usuarioActual;
    private String productoSeleccionado;
    private GestorProductos gestorProductos = new GestorProductos();

    private GestorHistorial gestorHistorial = new GestorHistorial();

    public VentanaEntradaProducto(Usuario usuarioActual, String productoSeleccionado) {

        super("Entrada de productos");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.usuarioActual = usuarioActual;
        this.productoSeleccionado = productoSeleccionado;

        JLabel fondo = new JLabel(new ImageIcon("entradaProductos-Nombre.png"));
        JLabel label = new JLabel();
        ImageIcon volver = new ImageIcon("Group 19.png");
        ImageIcon imagenCantidad = new ImageIcon("cantidadEntrada.png");
        ImageIcon sumar = new ImageIcon("Group 20.png");
        ImageIcon restar = new ImageIcon("Group 21.png");
        ImageIcon btnCompletar = new ImageIcon("Group 23.png");


        fondo.setBounds(0, 0, 375, 667);


        textFieldCantidad = new JTextField("0");
        JButton masButton = new JButton();
        JButton menosButton = new JButton();
        JButton confirmarButton = new JButton();
        JButton btnVolver = new JButton();

        label.setBounds(130, 151, 112, 38);
        textFieldCantidad.setBounds(133, 213, 105, 63);
        masButton.setBounds(256, 210, 58, 62);
        menosButton.setBounds(62, 236, 56, 25);
        confirmarButton.setBounds(105, 316, 166, 42);
        btnVolver.setBounds(18, 13, 45, 48);

        btnVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH)));
        masButton.setIcon(new ImageIcon(sumar.getImage().getScaledInstance(masButton.getWidth(), masButton.getHeight(), Image.SCALE_SMOOTH)));
        menosButton.setIcon(new ImageIcon(restar.getImage().getScaledInstance(menosButton.getWidth(), menosButton.getHeight(), Image.SCALE_SMOOTH)));
        confirmarButton.setIcon(new ImageIcon(btnCompletar.getImage().getScaledInstance(confirmarButton.getWidth(), confirmarButton.getHeight(), Image.SCALE_SMOOTH)));
        label.setIcon(new ImageIcon(imagenCantidad.getImage().getScaledInstance(label.getWidth(), confirmarButton.getHeight(), Image.SCALE_SMOOTH)));

        label.setBorder(new LineBorder(Color.BLACK, 1, true));
        textFieldCantidad.setBorder(new LineBorder(Color.WHITE, 3, true));

        panel.add(label);
        panel.add(textFieldCantidad);
        panel.add(masButton);
        panel.add(menosButton);
        panel.add(confirmarButton);
        panel.add(btnVolver);
        panel.add(fondo);
        add(panel);
        setVisible(true);

        masButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aumentarCantidad();
            }
        });

        menosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disminuirCantidad();
            }
        });

        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cantidad = Integer.parseInt(textFieldCantidad.getText());
                } catch (NumberFormatException ex) {
                }
                mostrarCantidad();
                gestorProductos.salidaStock(cantidad, usuarioActual, productoSeleccionado);
                gestorHistorial.registrarSalida(usuarioActual, productoSeleccionado, cantidad);
            }
        });

        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuarioActual);
                ventanaMenuPrincipal.setVisible(true);
            }
        });
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
        JOptionPane.showMessageDialog(this, "Cantidad seleccionada: " + cantidad);
    }


}








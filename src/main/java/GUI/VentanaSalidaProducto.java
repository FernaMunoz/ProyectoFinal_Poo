package GUI;
import Modelo.Usuario;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import datos.GestorProductos;

public class VentanaSalidaProducto extends JFrame{

    private JTextField textFieldCantidad;
    private int cantidad = 0;
    private Usuario usuarioActual;
    private String productoSeleccionado;
    private GestorProductos gestorProductos = new GestorProductos();

    public VentanaSalidaProducto(Usuario usuarioActual, String productoSeleccionado) {
        super("Salida de productos");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        this.usuarioActual = usuarioActual;
        this.productoSeleccionado = productoSeleccionado;

        JLabel etiqueta1 = new JLabel(new ImageIcon("Group 14.png"));
        ImageIcon volver = new ImageIcon("Group 15.png");
        ImageIcon sumar = new ImageIcon("Group 17.png");
        ImageIcon restar = new ImageIcon("Group 16 (1).png");
        ImageIcon btnCompletar = new ImageIcon("Group 16.png");

        etiqueta1.setBounds(0, 0, 375, 667);

        JLabel label = new JLabel("Cantidad");
        textFieldCantidad = new JTextField("0");
        JButton masButton = new JButton();
        JButton menosButton = new JButton();
        JButton confirmarButton = new JButton();
        JButton btnVolver = new JButton();

        label.setBounds(140, 220, 100, 30);
        textFieldCantidad.setBounds(133, 250, 95, 50);
        masButton.setBounds(248, 251, 52, 49);
        menosButton.setBounds(73, 270, 50, 20);
        confirmarButton.setBounds(98, 326, 166, 42);
        btnVolver.setBounds(18, 13, 45, 48);

        btnVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnVolver.getWidth(), btnVolver.getHeight(), Image.SCALE_SMOOTH)));
        masButton.setIcon(new ImageIcon(sumar.getImage().getScaledInstance(masButton.getWidth(), masButton.getHeight(), Image.SCALE_SMOOTH)));
        menosButton.setIcon(new ImageIcon(restar.getImage().getScaledInstance(menosButton.getWidth(), menosButton.getHeight(), Image.SCALE_SMOOTH)));
        confirmarButton.setIcon(new ImageIcon(btnCompletar.getImage().getScaledInstance(confirmarButton.getWidth(), confirmarButton.getHeight(), Image.SCALE_SMOOTH)));

        label.setForeground(Color.WHITE);
        textFieldCantidad. setBorder(new LineBorder(Color.WHITE, 3, true));

        panel.add(label);
        panel.add(textFieldCantidad);
        panel.add(masButton);
        panel.add(menosButton);
        panel.add(confirmarButton);
        panel.add(btnVolver);
        panel.add(etiqueta1);
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
                mostrarCantidad();
                gestorProductos.salidaStock(cantidad, usuarioActual, productoSeleccionado);
            }
        });
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                VentanaBuscarPorTexto ventanaBuscarPorTexto = new VentanaBuscarPorTexto(usuarioActual);
                ventanaBuscarPorTexto.setVisible(true);
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
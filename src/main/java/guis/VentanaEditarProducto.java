package guis;
import modelo.Usuario;
import datos.GestorInventario;
import datos.GestorProductos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaEditarProducto extends JFrame implements ActionListener {
    private JTextField nombreEditar;
    private JTextField stockEditar;
    private JTextField precioEditar;
    private GestorProductos gestorProductos;

    private Usuario usuarioActual;

    public VentanaEditarProducto(Usuario usuarioActual, String productoSeleccionado) {
        super("Editar Producto");
        this.usuarioActual = usuarioActual;
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        gestorProductos = new GestorProductos();

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nombreLabel = new JLabel();
        nombreLabel.setBounds(50, 50, 200, 30);
        nombreEditar = new JTextField();
        nombreEditar.setBounds(50, 80, 200, 30);

        JLabel stockLabel = new JLabel();
        stockLabel.setBounds(50, 120, 200, 30);
        stockEditar = new JTextField();
        stockEditar.setBounds(50, 150, 200, 30);

        JLabel precioLabel = new JLabel();
        precioLabel.setBounds(50, 190, 200, 30);
        precioEditar = new JTextField();
        precioEditar.setBounds(50, 220, 200, 30);

        JLabel imagenTitleLabel = new JLabel("Imagen:");
        imagenTitleLabel.setBounds(50, 250, 200, 30);
        JLabel imagenLabel = new JLabel();
        imagenLabel.setBounds(50, 280, 200, 30);

        JLabel barcodeTitleLabel = new JLabel("Código de barras:");
        barcodeTitleLabel.setBounds(50, 320, 200, 30);
        JLabel barcodeLabel = new JLabel();
        barcodeLabel.setBounds(50, 350, 200, 30);

        JButton boton = new JButton("Confirmar");
        boton.setBounds(50, 390, 200, 30);

        panel.add(nombreLabel);
        panel.add(nombreEditar);
        panel.add(stockLabel);
        panel.add(stockEditar);
        panel.add(imagenTitleLabel); // Add new JLabel to panel
        panel.add(imagenLabel);
        panel.add(precioLabel);
        panel.add(precioEditar);
        panel.add(barcodeTitleLabel); // Add new JLabel to panel
        panel.add(barcodeLabel);
        panel.add(boton);
        add(panel);
        setVisible(true);

        GestorInventario gestorUsuario = new GestorInventario();
        List<String> atributosProducto = gestorUsuario.buscarProducto(usuarioActual, productoSeleccionado);
        if (atributosProducto != null) {
            nombreLabel.setText(atributosProducto.get(0));
            stockLabel.setText(atributosProducto.get(1));
            precioLabel.setText(atributosProducto.get(2));
            imagenLabel.setText(atributosProducto.get(3));
            barcodeLabel.setText(atributosProducto.get(4));
        }

        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreEditar.getText();
                    int stock = Integer.parseInt(stockEditar.getText());
                    double precio = Double.parseDouble(precioEditar.getText());

                    gestorProductos.modificarProducto(productoSeleccionado, nombre, stock, precio, usuarioActual);

                    dispose();
                    JOptionPane.showMessageDialog(null, "Producto modificado con éxito","Exito", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    System.out.println("Por favor, introduce un número válido.");
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}






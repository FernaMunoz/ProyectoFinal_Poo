package GUI;
import datos.GestorInventario;
import Modelo.Inventario;
import Modelo.Producto;
import Modelo.Usuario;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarProducto extends JFrame{
    private Usuario usuario;

    private JTextField nombreProducto;
    private JTextField stockInicial;
    private JTextField precio ;
    public VentanaAgregarProducto(Usuario usuarioActual) {
        super("Agregar Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        this.usuario = usuarioActual;

        JLabel etiqueta1 = new JLabel(new ImageIcon("AgregarProducto.png"));
        JButton btnvolver = new JButton();

        JLabel etiqueta2 = new JLabel("Nombre del producto*");
        nombreProducto = new JTextField();
        JLabel etiqueta3 = new JLabel("Stock inicial*");
        stockInicial = new JTextField();
        JLabel etiqueta4 = new JLabel("Precio*");
        precio = new JTextField();

        JButton agregarProducto = new JButton("Agregar producto");
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");
        ImageIcon agregar = new ImageIcon("Group 7 (2).png");

        etiqueta2.setBounds(47,137,158,23);
        nombreProducto.setBounds(40,160,281,40);
        etiqueta3.setBounds(47,210,152,23);
        stockInicial.setBounds(40,230,281,40);
        etiqueta4.setBounds(47,280,100,23);
        precio.setBounds(40,303,281,40);
        agregarProducto.setBounds(83,515,200,63);
        btnvolver.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0,0,375,667);

        btnvolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnvolver.getWidth(), btnvolver.getHeight(), Image.SCALE_SMOOTH)));
        agregarProducto.setIcon(new ImageIcon(agregar.getImage().getScaledInstance(agregarProducto.getWidth(), agregarProducto.getHeight(), Image.SCALE_SMOOTH)));

        etiqueta2.setForeground(Color.GRAY);
        etiqueta3.setForeground(Color.GRAY);
        etiqueta4.setForeground(Color.GRAY);
        btnvolver.setBackground(Color.GREEN);

        agregarProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreProducto.getText();
                int stock = Integer.parseInt(stockInicial.getText());
                double precios = Double.parseDouble(precio.getText());

                Inventario inventario = new Inventario(usuario);
                Producto producto = new Producto(nombre, stock, precios, null);

                GestorInventario gestorInventario = new GestorInventario();
                gestorInventario.agregarProductoAInventario(usuario, producto);

            }
        });


        btnvolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
            }
        });

        panel.add(nombreProducto);
        panel.add(etiqueta2);
        panel.add(stockInicial);
        panel.add(etiqueta3);
        panel.add(precio);
        panel.add(etiqueta4);
        panel.add(agregarProducto);
        panel.add(btnvolver);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);
    }
}
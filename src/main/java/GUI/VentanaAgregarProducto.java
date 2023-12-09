package GUI;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaAgregarProducto extends JFrame implements ActionListener{

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

        btnvolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(btnvolver.getWidth(), btnvolver.getHeight(), Image.SCALE_SMOOTH)));

        btnvolver.setBounds(18, 13, 45, 48);


        panel.add(nombreProducto);
        panel.add(etiqueta2);
        panel.add(stockInicial);
        panel.add(etiqueta3);
        panel.add(precio);
        panel.add(etiqueta4);
        panel.add(agregarProducto);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaBuscarEntrada extends JFrame implements ActionListener{
    private JTextField buscar;
    public VentanaBuscarEntrada() {
        super("Entrada Producto");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo azul1.png"));
        etiqueta1.setBounds(0, 0, 375, 667);
        JLabel etiqueta2 = new JLabel(new ImageIcon("buscar.png"));
        etiqueta2.setBounds(22, 109, 327, 68);
        buscar = new JTextField();

        JButton boton1 = new JButton("Buscar");
        JButton boton2 = new JButton();

        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        buscar.setBounds(26, 150, 310, 50);

        boton1.setBounds(115, 228, 137, 53);
        boton2.setBounds(18, 13, 45, 48);


        boton2.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));


        boton1.setBackground(Color.BLUE);
        boton2.setBackground(Color.BLUE);

        boton1.setBorder(new LineBorder(Color.WHITE, 2, true));
        boton2.setBorder(new LineBorder(Color.WHITE, 2, true));

        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(buscar);
        panel.add(boton1);
        panel.add(boton2);

        add(panel);
        setVisible(true);


        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscar ventanaBuscar = new VentanaBuscar();
                ventanaBuscar.setVisible(true);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}


package guis;
import modelo.Usuario;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class VentanaBuscar extends JFrame implements ActionListener {
    public VentanaBuscar(Usuario usuarioActual) {
        super("Buscar");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("fondo rosado3.png"));

        etiqueta1.setBounds(0, 0, 375, 667);

        JButton botonBuscar = new JButton();
        JButton botonScaner = new JButton();
        JButton botonVolver = new JButton();


        ImageIcon buscar = new ImageIcon("buscarExistencias icon.png");
        ImageIcon scanner = new ImageIcon("Group 5.png");
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        botonBuscar.setBounds(113, 150, 143, 144);
        botonScaner.setBounds(113, 330, 143, 144);
        botonVolver.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0, 0, 375, 667);


        botonBuscar.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonScaner.setIcon(new ImageIcon(scanner.getImage().getScaledInstance(botonScaner.getWidth(), botonScaner.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));

        botonBuscar.setBackground(Color.WHITE);
        botonScaner.setBackground(Color.WHITE);
        botonVolver.setBackground(Color.pink);

        botonBuscar.setBorder(new LineBorder(Color.WHITE, 6, true));
        botonScaner.setBorder(new LineBorder(Color.WHITE, 6, true));

        panel.add(botonBuscar);
        panel.add(botonScaner);
        panel.add(botonVolver);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        botonBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscarPorTexto ventanaBuscarPorTexto =new VentanaBuscarPorTexto(usuarioActual);
                ventanaBuscarPorTexto.setVisible(true);
            }
        });

        botonScaner.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscarCodigoBarras ventanaBuscarCodigoBarras = new VentanaBuscarCodigoBarras(usuarioActual);
                ventanaBuscarCodigoBarras.setVisible(true);
            }
        });
        botonVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuarioActual);
                ventanaMenuPrincipal.setVisible(true);

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

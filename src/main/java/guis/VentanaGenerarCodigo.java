package guis;
import modelo.Usuario;
import guis.VentanaGenerar;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGenerarCodigo extends JFrame {
        private JTextField buscar;

        public VentanaGenerarCodigo(Usuario usuarioActual) {

                super("Generar Codigo");

                setSize(375, 667);

                setLocationRelativeTo(null);

                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                JPanel panel = new JPanel();
                panel.setLayout(null);
                JLabel etiqueta1 = new JLabel(new ImageIcon("fondo rosado3.png"));
                ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

                buscar = new JTextField();
                JButton boton1 = new JButton("Buscar");

                JButton botonVolver = new JButton();

                boton1.setBounds(115, 228, 137, 53);
                botonVolver.setBounds(18, 13, 45, 48);
                buscar.setBounds(26, 150, 310, 50);

                botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));

                etiqueta1.setBounds(0, 0, 375, 667);
                boton1.setBackground(Color.PINK);
                botonVolver.setBackground(Color.PINK);

                add(buscar);
                add(boton1);
                add(botonVolver);
                add(etiqueta1);
                add(panel);
                setVisible(true);

                boton1.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                dispose();
                                String textoBusqueda = buscar.getText();
                                VentanaGenerar ventanaGenerar = new VentanaGenerar(usuarioActual, textoBusqueda);
                                ventanaGenerar.setVisible(true);
                        }
                });
                botonVolver.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dispose();
                        VentanaMenuPrincipal ventanaMenuPrincipal = new VentanaMenuPrincipal(usuarioActual);
                        ventanaMenuPrincipal.setVisible(true);

                    }
                });

        }

}


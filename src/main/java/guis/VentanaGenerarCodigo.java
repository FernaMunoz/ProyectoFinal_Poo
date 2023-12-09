package guis;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaGenerarCodigo extends JFrame {

        public VentanaGenerarCodigo() {

                super("Generar Codigo");

                setSize(375, 667);

                setLocationRelativeTo(null);

                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel panel = new JPanel();
                panel.setLayout(null);
                JLabel etiqueta1 = new JLabel(new ImageIcon("Group 8.png"));

                JButton botonVolver = new JButton("Back");

                ImageIcon volver = new ImageIcon("Group 9.png");
                botonVolver.setBounds(18, 13, 45, 48);

                etiqueta1.setBounds(0, 0, 375, 667);

                botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));

                add(botonVolver);
                add(etiqueta1);
                add(panel);
                setVisible(true);

        }
}


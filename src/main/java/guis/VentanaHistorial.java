package guis;

import datos.GestorHistorial;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VentanaHistorial extends JFrame {
    private Usuario usuario;

    public VentanaHistorial(Usuario usuarioActual) {
        super("Historial");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.usuario = usuarioActual;

        GestorHistorial gestorHistorial = new GestorHistorial();
        List<String> historial = gestorHistorial.leerHistorial(usuario);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("Historial.png"));
        ImageIcon volver = new ImageIcon("Group 25 (1).png");

        JTextArea areaTexto = new JTextArea();
        for (String linea : historial) {
            areaTexto.append(linea + "\n");
        }

        JButton botonVolver = new JButton();
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        botonVolver.setBounds(18, 13, 45, 48);
        scrollPane.setBounds(0, 73, 375, 667);
        etiqueta1.setBounds(0, 0, 375, 667);

        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));

        panel.add(botonVolver);
        panel.add(scrollPane);
        panel.add(etiqueta1);

        add(panel);
        setVisible(true);

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
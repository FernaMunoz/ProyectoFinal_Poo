package guis;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaInicio extends JFrame implements ActionListener {
    public VentanaInicio(){
        super("Inventario");
        setSize(375,667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-05 181240.png"));

        etiqueta1.setBounds(0,0,375,667);

        JButton iniciarSesion = new JButton("Iniciar sesión");
        JButton resgistrar = new JButton("Registrar");
        iniciarSesion.setBackground(Color.WHITE);
        resgistrar.setBackground(Color.WHITE);
        iniciarSesion.setBorder(new LineBorder(Color.WHITE,2,true));
        resgistrar.setBorder(new LineBorder(Color.WHITE,2,true));

        iniciarSesion.setBounds(87,333,200,50);
        resgistrar.setBounds(87,400,200,50);

        iniciarSesion.addActionListener(this);
        resgistrar.addActionListener(this);

        panel.add(iniciarSesion);
        panel.add(resgistrar);
        panel.add(etiqueta1);

        add(panel);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        if (e.getActionCommand().equals("Iniciar sesión")) {
            VentanaInicioSesion ventanaIniciosesion = new VentanaInicioSesion();
            ventanaIniciosesion.setVisible(true);
        } else if(e.getActionCommand().equals("Registrar")) {
            VentanaRegistro ventanaRegistro = new VentanaRegistro();
            ventanaRegistro.setVisible(true);
        }
    }
}

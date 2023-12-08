package GUI;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class VentanaBuscarPorTexto extends JFrame implements ActionListener {
    private JTextField buscar;
    public VentanaBuscarPorTexto() {
        super("Buscar");
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel etiqueta1 = new JLabel(new ImageIcon("Captura de pantalla 2023-12-06 150758.png"));
        etiqueta1.setBounds(0, 0, 375, 667);
        JLabel etiqueta2 = new JLabel(new ImageIcon("FONDO ROSADO.png"));
        etiqueta2.setBounds(21, 108, 126, 66);

        buscar = new JTextField();
        buscar.setBounds(77, 168, 218, 61);
        JButton buscarBoton = new JButton("Buscar");
        etiqueta2.setBounds(115, 228, 137, 53);
        JButton volver = new JButton();

        volver.setIcon(new ImageIcon(volver.getName().getScaledInstance(volver.getWidth(), volver.getHeight(), Image.SCALE_SMOOTH)));
        volver.setBounds(18, 13, 45, 48);

        buscar.setBackground(Color.CYAN);
        volver.setBackground(Color.CYAN);
        buscarBoton.setBackground(Color.PINK);
        buscar.setBorder(new LineBorder(Color.WHITE, 2, true));

        panel.add(etiqueta1);
        panel.add(etiqueta2);
        panel.add(volver);
        panel.add(buscarBoton);

        add(panel);
        setVisible(true);

        volver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

        buscarBoton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });
        buscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

    }
}
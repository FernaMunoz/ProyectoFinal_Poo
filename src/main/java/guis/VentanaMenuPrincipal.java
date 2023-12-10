package guis;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Usuario;


public class VentanaMenuPrincipal extends JFrame {
    private Usuario usuarioActual;

    public VentanaMenuPrincipal(Usuario usuarioActual) {
        super("Menu principal");
        this.usuarioActual = usuarioActual;
        setSize(375, 667);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("menu principal.png"));

        etiqueta1.setBounds(0, 0, 375, 667);


        JButton boton1 = new JButton();
        JButton boton2 = new JButton();
        JButton boton6 = new JButton();
        JButton boton3 = new JButton();
        JButton boton4 = new JButton();
        JButton boton5 = new JButton();


        ImageIcon buscar = new ImageIcon("buscarExistencias icon.png");
        ImageIcon generador = new ImageIcon("Group 5.png");
        ImageIcon inventario = new ImageIcon("inventario.png");
        ImageIcon historial = new ImageIcon("Group 3.png");
        ImageIcon agregar = new ImageIcon("Group 4.png");
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        boton1.setBounds(41, 130, 117, 117);
        boton2.setBounds(205, 130, 117, 117);
        boton3.setBounds(41, 459, 117, 117);
        boton4.setBounds(205, 459, 117, 117);
        boton5.setBounds(18, 13, 45, 48);
        boton6.setBounds(127,309, 117,117);
        etiqueta1.setBounds(0,0,375,667);

        boton1.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(boton1.getWidth(), boton1.getHeight(), Image.SCALE_SMOOTH)));
        boton2.setIcon(new ImageIcon(generador.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton3.setIcon(new ImageIcon(historial.getImage().getScaledInstance(boton3.getWidth(), boton3.getHeight(), Image.SCALE_SMOOTH)));
        boton4.setIcon(new ImageIcon(agregar.getImage().getScaledInstance(boton4.getWidth(), boton4.getHeight(), Image.SCALE_SMOOTH)));
        boton5.setIcon(new ImageIcon(volver.getImage().getScaledInstance(boton5.getWidth(), boton5.getHeight(), Image.SCALE_SMOOTH)));
        boton6.setIcon(new ImageIcon(inventario.getImage().getScaledInstance(boton6.getWidth(), boton6.getHeight(), Image.SCALE_SMOOTH)));

        boton1.setBackground(Color.WHITE);
        boton2.setBackground(Color.WHITE);
        boton3.setBackground(Color.WHITE);
        boton4.setBackground(Color.WHITE);
        boton5.setBackground(Color.CYAN);
        boton6.setBackground(Color.WHITE);


        boton1.setBorder(new LineBorder(Color.WHITE,6,true));
        boton2.setBorder(new LineBorder(Color.WHITE,6,true));
        boton3.setBorder(new LineBorder(Color.WHITE,8,true));
        boton4.setBorder(new LineBorder(Color.WHITE,6,true));
        boton6.setBorder(new LineBorder(Color.WHITE,6,true));


        panel.add(boton1);
        panel.add(boton2);
        panel.add(boton3);
        panel.add(boton4);
        panel.add(boton5);
        panel.add(boton6);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        boton1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscar ventanaBuscar = new VentanaBuscar(usuarioActual);
                ventanaBuscar.setVisible(true);
            }
        });

        boton2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaGenerarCodigo ventanaGenerarCodigo = new VentanaGenerarCodigo(usuarioActual);
                ventanaGenerarCodigo.setVisible(true);

            }
        });
        boton3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaHistorial ventanaHistorial = new VentanaHistorial(usuarioActual);
                ventanaHistorial.setVisible(true);

            }
        });
        boton4.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaHistorial ventanaHistorial = null;
                VentanaAgregarProducto ventanaAgregarProducto = new VentanaAgregarProducto(usuarioActual);
                ventanaAgregarProducto.setVisible(true);

            }
        });
        boton5.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaMenuPrincipal.this.dispose();
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
            }
        });

        boton6.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

            }
        });

    }
}
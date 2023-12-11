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
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel etiqueta1 = new JLabel(new ImageIcon("menu principal.png"));

        JButton botonBuscar = new JButton();
        JButton botonGenerador = new JButton();
        JButton botonInventario = new JButton();
        JButton botonHistorial = new JButton();
        JButton botonAgregar = new JButton();
        JButton botonVolver = new JButton();

        ImageIcon buscar = new ImageIcon("Buscar producto.png");
        ImageIcon generador = new ImageIcon("Group 5.png");
        ImageIcon inventario = new ImageIcon("inventario.png");
        ImageIcon historial = new ImageIcon("Group 3.png");
        ImageIcon agregar = new ImageIcon("Group 4.png");
        ImageIcon volver = new ImageIcon("mingcute_back-2-fill.png");

        botonBuscar.setBounds(45, 125, 117, 117);
        botonGenerador.setBounds(208, 125, 117, 117);
        botonInventario.setBounds(129, 290, 117, 117);
        botonHistorial.setBounds(48, 459, 117, 117);
        botonAgregar.setBounds(207,459, 117,117);
        botonVolver.setBounds(18, 13, 45, 48);
        etiqueta1.setBounds(0,0,375,667);

        botonBuscar.setIcon(new ImageIcon(buscar.getImage().getScaledInstance(botonBuscar.getWidth(), botonBuscar.getHeight(), Image.SCALE_SMOOTH)));
        botonGenerador.setIcon(new ImageIcon(generador.getImage().getScaledInstance(botonGenerador.getWidth(), botonGenerador.getHeight(), Image.SCALE_SMOOTH)));
        botonInventario.setIcon(new ImageIcon(inventario.getImage().getScaledInstance(botonInventario.getWidth(), botonInventario.getHeight(), Image.SCALE_SMOOTH)));
        botonHistorial.setIcon(new ImageIcon(historial.getImage().getScaledInstance(botonHistorial.getWidth(), botonHistorial.getHeight(), Image.SCALE_SMOOTH)));
        botonAgregar.setIcon(new ImageIcon(agregar.getImage().getScaledInstance(botonAgregar.getWidth(), botonAgregar.getHeight(), Image.SCALE_SMOOTH)));
        botonVolver.setIcon(new ImageIcon(volver.getImage().getScaledInstance(botonVolver.getWidth(), botonVolver.getHeight(), Image.SCALE_SMOOTH)));

        botonBuscar.setBackground(Color.WHITE);
        botonGenerador.setBackground(Color.WHITE);
        botonInventario.setBackground(Color.WHITE);
        botonHistorial.setBackground(Color.WHITE);
        botonAgregar.setBackground(Color.CYAN);
        botonVolver.setBackground(Color.CYAN);

        botonBuscar.setBorder(new LineBorder(Color.WHITE,6,true));
        botonGenerador.setBorder(new LineBorder(Color.WHITE,6,true));
        botonInventario.setBorder(new LineBorder(Color.WHITE,8,true));
        botonHistorial.setBorder(new LineBorder(Color.WHITE,6,true));
        botonAgregar.setBorder(new LineBorder(Color.WHITE,6,true));
        botonVolver.setBorder(new LineBorder(Color.WHITE,2,true));

        panel.add(botonBuscar);
        panel.add(botonGenerador);
        panel.add(botonInventario);
        panel.add(botonHistorial);
        panel.add(botonAgregar);
        panel.add(botonVolver);
        panel.add(etiqueta1);
        add(panel);
        setVisible(true);

        botonBuscar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaBuscar ventanaBuscar = new VentanaBuscar(usuarioActual);
                ventanaBuscar.setVisible(true);
            }
        });

        botonGenerador.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaGenerarCodigo ventanaGenerarCodigo = new VentanaGenerarCodigo(usuarioActual);
                ventanaGenerarCodigo.setVisible(true);

            }
        });
        botonInventario.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaInventario ventanaInventario = new VentanaInventario(usuarioActual);
                ventanaInventario.setVisible(true);
            }
        });
        botonHistorial.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaHistorial ventanaHistorial = new VentanaHistorial(usuarioActual);
                ventanaHistorial.setVisible(true);

            }
        });
        botonAgregar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                dispose();
                VentanaAgregarProducto ventanaAgregarProducto = new VentanaAgregarProducto(usuarioActual);
                ventanaAgregarProducto.setVisible(true);

            }
        });
        botonVolver.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                VentanaMenuPrincipal.this.dispose();
                VentanaInicio ventanaInicio = new VentanaInicio();
                ventanaInicio.setVisible(true);
            }
        });

    }
}
package guis;

import datos.GestorHistorial;
import modelo.Usuario;
import javax.swing.*;
import java.awt.*;
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

        JTextArea areaTexto = new JTextArea();
        for (String linea : historial) {
            areaTexto.append(linea + "\n");
        }

        add(new JScrollPane(areaTexto));

        setVisible(true);
    }
}
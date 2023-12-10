package org.example;
import GUI.VentanaInicio;
import Modelo.Usuario;


public class Main {
    private static Usuario usuarioActual;

    public static void main(String[] args) {
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
    }
}
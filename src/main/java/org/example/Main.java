package org.example;

import GUI.VentanaEntradaProducto;
import GUI.VentanaInicio;
import GUI.VentanaOpciones;
import Modelo.Usuario;


public class Main {
    private static Usuario usuarioActual;

    public static void main(String[] args) {
        VentanaInicio ventanaInicio = new VentanaInicio();
        ventanaInicio.setVisible(true);
    }
}
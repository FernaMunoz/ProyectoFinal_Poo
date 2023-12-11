package Modelo;


import datos.GestorProductos;
import java.util.Random;
import javax.swing.*;

public class CodigoBarra {

    public static class CodigoBarraInfo {
        private Producto producto;
        private String codigoBarras;
        private ImageIcon imagenCodigoBarras;

        public CodigoBarraInfo(Producto producto, String codigoBarras, ImageIcon imagenCodigoBarras) {
            this.producto = producto;
            this.codigoBarras = codigoBarras;
            this.imagenCodigoBarras = imagenCodigoBarras;
        }

        public String getCodigoBarras() {
            return codigoBarras;
        }

        public ImageIcon getImagenCodigoBarras() {
            return imagenCodigoBarras;
        }
    }

    public CodigoBarraInfo generarCodigoBarra(Usuario usuarioActual, Producto producto) {
        GestorProductos gestorProductos = new GestorProductos();

        if (gestorProductos.productoTieneCodigoBarra(usuarioActual, producto)) {
            System.out.println("El producto ya tiene un código de barras");
            return null;
        }

        String productoIdentificador = generarCodigoBarras();

        int suma = 0;
        for (int i = 0; i < 12; i++) {
            int digito = Character.getNumericValue(productoIdentificador.charAt(i));
            suma += (i % 2 == 0) ? digito * 3 : digito;
        }
        int digitoControl = (10 - (suma % 10)) % 10;

        String codigoBarras = productoIdentificador + digitoControl;
        producto.setCodigoDebarra(codigoBarras);

        // Actualizar CSV
        gestorProductos.actualizarCSV(usuarioActual, producto);

        // Cargar la imagen del código de barras desde el archivo (ajusta la ruta según tu estructura)
        ImageIcon imagenCodigoBarras = new ImageIcon("icons8-código-de-barras-50.png");

        return new CodigoBarraInfo(producto, codigoBarras, imagenCodigoBarras);
    }

    private String generarCodigoBarras() {
        Random random = new Random();
        StringBuilder identificador = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            identificador.append(random.nextInt(10));
        }

        return identificador.toString();
    }
}
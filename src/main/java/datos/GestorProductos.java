package datos;
import Modelo.Producto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    public void modificarProducto(Producto producto, String nuevoNombre, int nuevoStock, double nuevoPrecio, String nuevaImagen){
        String rutaCsv = producto.getInventario().getUsuario().getNombre() + "_inventario.csv";
        List<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");

                if (partes[0].equals("\"" + producto.getNombre() + "\"")) {

                    lineas.add("\"" + nuevoNombre + "\",\"" + nuevoStock + "\",\"" + nuevoPrecio + "\",\"" + nuevaImagen + "\"");
                } else {

                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv))) {
            for (String linea : lineas) {
                escritor.write(linea);
                escritor.newLine();
            }

            escritor.flush();

            System.out.println("Producto modificado exitosamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
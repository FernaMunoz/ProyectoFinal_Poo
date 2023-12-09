package datos;
import Modelo.Inventario;
import Modelo.Producto;
import Modelo.Usuario;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    public void modificarProducto(Producto producto, Usuario usuarioActual, String nuevoNombre, int nuevoStock, double nuevoPrecio, String nuevaImagen){
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
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

    public List<Producto> obtenerProductosSimilares(String textoBusqueda, Usuario usuarioActual) {
        List<Producto> productosSimilares = new ArrayList<>();
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");

                String nombreProducto = partes[0].replace("\"", "");

                if (nombreProducto.contains(textoBusqueda)) {
                    String nombre = partes[0].replace("\"", "");
                    int stock = Integer.parseInt(partes[1].replace("\"", ""));
                    double precio = Double.parseDouble(partes[2].replace("\"", ""));
                    String imagen = partes[3].replace("\"", "");

                    Inventario inventario = null;
                    Producto producto = new Producto(inventario, nombre, stock, precio, imagen);
                    productosSimilares.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productosSimilares;
    }


}
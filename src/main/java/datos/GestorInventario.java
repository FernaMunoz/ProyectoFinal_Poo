package datos;
import Modelo.Usuario;
import Modelo.Producto;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GestorInventario {
    public void agregarProductoAInventario(Usuario usuario, Producto producto){
        String rutaCsv = usuario.getNombre() + "_inventario.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write("\"" + producto.getNombre() + "\",");
            escritor.write("\"" + producto.getStock() + "\",");
            escritor.write("\"" + producto.getPrecio() + "\",");
            escritor.write("\"" + producto.getImagen() + "\"");
            escritor.newLine();

            escritor.flush();

            System.out.println("Producto agregado al inventario exitosamente");

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<String> buscarProducto(Usuario usuarioActual, String productoSeleccionado) {
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> atributosProducto = null;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))){
            String linea;

            while ((linea = lector.readLine()) != null) {
                List<String> atributos = Arrays.asList(linea.split(","));
                if (atributos.get(0).equals("\"" + productoSeleccionado + "\"")) {
                    atributosProducto = atributos;
                    break;
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return atributosProducto;
    }
}
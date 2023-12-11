package datos;
import modelo.Usuario;
import modelo.Producto;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.List;

public class GestorInventario {
    public void agregarProductoAInventario(Usuario usuario, Producto producto){
        String rutaCsv = usuario.getNombre() + "_inventario.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write("\"" + producto.getNombre() + "\",");
            escritor.write("\"" + producto.getStock() + "\",");
            escritor.write("\"" + producto.getPrecio() + "\",");
            escritor.write("\"" + producto.getImagen() + "\",");
            escritor.write("\"no hay código de barras asignado\"");
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
    public List<String> buscarProductoPorCodigoBarra(Usuario usuarioActual, String codigoBarra) {
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> atributosProducto = null;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))){
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String codigoBarraProducto = partes[4].replace("\"", "");

                    if (codigoBarraProducto.equals(codigoBarra)) {
                        atributosProducto = Arrays.asList(partes);
                        break;
                    }
                }
            }

            if (atributosProducto == null) {
                JOptionPane.showMessageDialog(null, "El producto no tiene un código de barras.");
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return atributosProducto;
    }

}

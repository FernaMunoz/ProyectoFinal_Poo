package datos;
import modelo.Usuario;
import modelo.Producto;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
}
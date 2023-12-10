package datos;

import modelo.Usuario;
import modelo.Producto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GestorHistorial {

    public void crearHistorial(Usuario usuarioActual) {
        String rutaCsv = usuarioActual.getNombre() + "_historial.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write("Fecha y Hora, Acción, Producto, Detalles\n");
            escritor.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void registrarModificacion(Usuario usuarioActual, String productoAnterior, String productoNuevo) {
        String rutaCsv = usuarioActual.getNombre() + "_historial.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", Modificación, " + productoAnterior + ", " + productoNuevo + "\n");
            escritor.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void registrarEntrada(Usuario usuarioActual, String productoSeleccionado, int cantidad) {
        String rutaCsv = usuarioActual.getNombre() + "_historial.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", Entrada, " + productoSeleccionado + ", Se agregaron " + cantidad + " unidades\n");
            escritor.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void registrarSalida(Usuario usuarioActual, String productoSeleccionado, int cantidad) {
        String rutaCsv = usuarioActual.getNombre() + "_historial.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", Salida, " + productoSeleccionado + ", Se retiraron " + cantidad + " unidades\n");
            escritor.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void registrarNuevoProducto(Usuario usuarioActual, Producto producto) {
        String rutaCsv = usuarioActual.getNombre() + "_historial.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + ", Nuevo Producto, " + producto.getNombre() + ", Se agregó al inventario\n");
            escritor.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

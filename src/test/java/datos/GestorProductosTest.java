package datos;

import datos.GestorProductos;
import modelo.Producto;
import modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorProductosTest {

    private GestorProductos gestorProductos;
    private Usuario usuario;

    @BeforeEach
    void setUp() {

        gestorProductos = new GestorProductos();
        usuario = new Usuario("test", "empresa", "password");
    }
    @Test
    void testModificarProducto() {

        String rutaCsv = "test_inventario.csv";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv))) {
            escritor.write("\"ProductoExistente\", \"10\", \"15.0\", \"imagen.jpg\"");
            escritor.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        gestorProductos.modificarProducto("ProductoExistente", "NuevoNombre", 20, 18.0, usuario);

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {

            String linea = lector.readLine();

            String lineaEsperada = "\"NuevoNombre\", \"20\", \"18.0\", \"null\"".replaceAll("\\s+", "");

            assertEquals(lineaEsperada, linea.replaceAll("\\s+", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testEntradaStock() {

        String rutaCsv = "test_inventario.csv";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv))) {
            escritor.write("\"ProductoExistente\", \"10\", \"15.0\", \"imagen.jpg\"");
            escritor.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        gestorProductos.entradaStock(5, usuario, "ProductoExistente");

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            List<String> lineas = List.of(lector.readLine().split(System.lineSeparator()));

            assertEquals("\"ProductoExistente\",\"15\",\"15.0\",\"imagen.jpg\"", lineas.get(0).replaceAll("\\s+", ""));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testSalidaStock() {

        String rutaCsv = "test_inventario.csv";
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv))) {
            escritor.write("\"ProductoExistente\",\"10\",\"15.0\",\"imagen.jpg\"");
            escritor.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        gestorProductos.salidaStock(3, usuario, "ProductoExistente");

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String lineaActual = lector.readLine();

            String lineaEsperada = "\"ProductoExistente\",\"7\",\"15.0\",\"imagen.jpg\"";

            assertEquals(lineaEsperada, lineaActual.trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




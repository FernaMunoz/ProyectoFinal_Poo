package datos;

import modelo.Producto;
import modelo.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.table.DefaultTableModel;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GestorInventarioTest {
    private GestorInventario gestorInventario;
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        gestorInventario = new GestorInventario();
        usuario = new Usuario("nombreUsuario", "empresa", "password");
    }

    @Test
    public void testAgregarProductoAInventario() {
        Producto producto = new Producto("ProductoTest", 10, 20.0, "imagen.jpg");

        gestorInventario.agregarProductoAInventario(usuario, producto);

        DefaultTableModel modeloTabla = GestorInventario.cargarInventario(usuario.getNombre());
        assertEquals(3, modeloTabla.getRowCount());
        assertEquals("ProductoTest", modeloTabla.getValueAt(0, 0));
        assertEquals("\"10\"", modeloTabla.getValueAt(0, 1));
        assertEquals("\"20.0\"", modeloTabla.getValueAt(0, 2));
    }

    @Test
    public void testBuscarProducto() {
        Producto producto = new Producto("Test", 10, 20.0, "imagen");

        gestorInventario.agregarProductoAInventario(usuario, producto);

        List<String> atributosProducto = gestorInventario.buscarProducto(usuario, "Test");

        assertNotNull(atributosProducto);

        if(atributosProducto != null) {
            assertEquals("Test", atributosProducto.get(0).replaceAll("\"", ""));
            assertEquals("10", atributosProducto.get(1).replaceAll("\"", ""));
            assertEquals("20.0", atributosProducto.get(2).replaceAll("\"", ""));
            assertEquals("imagen", atributosProducto.get(3).replaceAll("\"", ""));
        }
    }
}
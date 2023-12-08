package modelo;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private Usuario usuario;
    private List<Producto> productos;

    public Inventario(Usuario usuario) {
        this.usuario = usuario;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }


}

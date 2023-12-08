package modelo;

public class Producto {
    private Inventario inventario;
    private String nombre;
    private int stock;
    private double precio;
    private String imagen;

    public Producto(Inventario inventario, String nombre, int stock, double precio, String imagen) {
        this.inventario = inventario;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
    }

    public Inventario getInventario() {
        return this.inventario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getStock() {
        return this.stock;
    }

    public double getPrecio() {
        return this.precio;
    }

    public String getImagen() {
        return this.imagen;
    }
}

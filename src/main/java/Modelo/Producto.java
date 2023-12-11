package Modelo;

public class Producto {
    private String nombre;
    private int stock;
    private double precio;
    private String imagen;
    private String codigoBarra;

    public Producto(String nombre, int stock, double precio, String imagen) {

        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
        this.imagen = imagen;
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

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoDebarra(String codigoBarra) {
        if(this.codigoBarra == null){
            this.codigoBarra = codigoBarra;
        } else {
            System.out.println("El codigo de barra ya esta establecido");
        }
    }
}
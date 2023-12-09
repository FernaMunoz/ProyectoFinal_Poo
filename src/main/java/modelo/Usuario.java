package modelo;

public class Usuario {
    private String nombre;
    private String nombreEmpresa;
    private String contrasena;
    private Inventario inventario;

    public Usuario(String nombre, String nombreEmpresa, String contrasena) {
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
        this.contrasena = contrasena;
        this.inventario = new Inventario(this);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEmpresa() {
        return this.nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getContrasena() {
        return this.contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    public Inventario getInventario(){
        return this.inventario;
    }
}


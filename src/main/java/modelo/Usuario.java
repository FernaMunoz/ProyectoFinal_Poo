package modelo;

public class Usuario {
    private String nombre;
    private String nombreEmpresa;
    private String contrasena;

    public Usuario() {
        this.nombre = nombre;
        this.nombreEmpresa = nombreEmpresa;
        this.contrasena = contrasena;
    }


    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


}


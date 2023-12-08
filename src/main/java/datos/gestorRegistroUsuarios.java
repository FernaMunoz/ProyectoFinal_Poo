package datos;
import modelo.Usuario;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class gestorRegistroUsuarios {
    public Usuario usuario;

    public Usuario anadirUsuario(String nombre, String nombreEmpresa, String contrasena){
        Usuario usuario = null;
        String rutaCsv = "registro.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write("\"" + nombre + "\",");
            escritor.write("\"" + nombreEmpresa + "\",");
            escritor.write("\"" + contrasena + "\"");
            escritor.newLine();

            escritor.flush();

            usuario = new Usuario(nombre, nombreEmpresa, contrasena);

            System.out.println("Registro exitoso");

        } catch (IOException e){
            e.printStackTrace();
        }

        return usuario;
    }

    public Usuario registrarUsuario(String nombre, String nombreEmpresa, String contrasena, String confContrasena) {
        if (nombre.isEmpty() || nombreEmpresa.isEmpty() || contrasena.isEmpty()) {
            throw new IllegalArgumentException("por favor llene todos los campos");
        }
        if(!contrasena.equals(confContrasena)){
            throw new IllegalArgumentException("las contraseñas no coinciden");
        }

        return anadirUsuario(nombre, nombreEmpresa, contrasena);
    }
}


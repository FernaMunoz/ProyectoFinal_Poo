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

                usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setNombreEmpresa(nombreEmpresa);
                usuario.setContrasena(contrasena);

                System.out.println("Registro exitoso");

        } catch (IOException e){
            e.printStackTrace();
        }

        return usuario;
    }

}

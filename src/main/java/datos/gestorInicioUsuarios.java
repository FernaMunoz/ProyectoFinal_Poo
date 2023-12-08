package datos;
import modelo.Usuario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class gestorInicioUsuarios {
    public Usuario usuario;

    public boolean obtAutenticacion(String nombre, String contrasena) {
        boolean autenticacionExitosa = false;
        String rutaCsv = "registro.csv";

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] partes = linea.split(",");


                if (partes.length == 3 && partes[0].equals("\"" + nombre + "\"") && partes[2].equals("\"" + contrasena + "\"")) {
                    autenticacionExitosa = true;

                    usuario = new Usuario();
                    usuario.setNombre(partes[0].replace("\"", ""));
                    usuario.setNombreEmpresa(partes[1].replace("\"", ""));
                    usuario.setContrasena(partes[2].replace("\"", ""));

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return autenticacionExitosa;
    }
}



package datos;
import modelo.Usuario;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class gestorInicioUsuarios {
    public Usuario usuario;

    public Usuario obtAutenticacion(String nombre, String contrasena) {
        Usuario usuarioAutenticado = null;
        String rutaCsv = "registro.csv";

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {

                String[] partes = linea.split(",");

                if (partes.length == 3 && partes[0].equals("\"" + nombre + "\"") && partes[2].equals("\"" + contrasena + "\"")) {
                    usuarioAutenticado = new Usuario(partes[0].replace("\"", ""), partes[1].replace("\"", ""), partes[2].replace("\"", ""));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return usuarioAutenticado;
    }
}



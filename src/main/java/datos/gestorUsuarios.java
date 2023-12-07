package datos;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class gestorUsuarios {
    public Usuario usuario;

    public Usuario anadirUsuario(String nombre, String nombreEmpresa, String contrasena){
        Usuario usuario = null;
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/registro_schema";
        final String Usuario = "root";
        final String Password = "Valeria32.";

        try{
            Connection connection = DriverManager.getConnection(DB_URL, Usuario, Password);
            // conexion a la bases de datos exitoso...
            Statement estado = connection.createStatement();
            String sql = "INSERT INTO usuario (nombre, nombreEmpresa, contrasena) " + "VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2,nombreEmpresa);
            preparedStatement.setString(3,contrasena);

            int filaAnadida = preparedStatement.executeUpdate();
            if (filaAnadida > 0){
                usuario = new Usuario();
                usuario.setNombre(nombre);
                usuario.setNombreEmpresa(nombreEmpresa);
                usuario.setContrasena(contrasena);

                System.out.println("Registro exitoso");
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return usuario;
    }

}

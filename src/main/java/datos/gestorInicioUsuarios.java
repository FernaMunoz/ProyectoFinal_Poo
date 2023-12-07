package datos;

import modelo.Usuario;

import java.sql.*;

public class gestorInicioUsuarios {
    public Usuario usuario;

    public Usuario obtAutenticacion(String nombre, String contrasena) {
        Usuario usuario = null;
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/registro_schema";
        final String Usuario = "root";
        final String Password = "Valeria32.";

        try{
            Connection connection = DriverManager.getConnection(DB_URL, Usuario, Password);
            // conexion a la bases de datos exitoso...
            Statement estado = connection.createStatement();
            String sql = "SELECT * FROM usuario WHERE nombre=? AND contrasena=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2,contrasena);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){
                usuario = new Usuario();
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setNombreEmpresa(resultSet.getString("nombreEmpresa"));
                usuario.setContrasena(resultSet.getString("contrasena"));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return usuario;
    }

}

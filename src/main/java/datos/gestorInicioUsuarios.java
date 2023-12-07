package datos;
import modelo.Usuario;
import java.sql.*;

public class gestorInicioUsuarios {
    public Usuario usuario;

    public boolean obtAutenticacion(String nombre, String contrasena) {
        boolean autenticacionExitosa = false;
       // Usuario usuario = null;
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

                autenticacionExitosa = true;
                usuario = new Usuario();
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setNombreEmpresa(resultSet.getString("nombreEmpresa"));
                usuario.setContrasena(resultSet.getString("contrasena"));
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();


        } catch (Exception e){
            e.printStackTrace();
        }

        return autenticacionExitosa;

    }

}

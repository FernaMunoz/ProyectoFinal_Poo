package datos;

import modelo.Producto;
import modelo.Usuario;

import java.sql.*;

public class Inventario {

    public Producto producto;

    public Producto anadirProducto(String nombreProducto, int stock, int precio) {
        Usuario usuario = null;
        final String DB_URL = "jdbc:mysql://127.0.0.1:3306/productos_schema";
        final String Usuario = "root";
        final String Password = "Valeria32.";

        try {
            Connection connection = DriverManager.getConnection(DB_URL, Usuario, Password);
            // conexion a la bases de datos exitoso...
            Statement estado = connection.createStatement();
            String sql = "INSERT INTO usuario (nombre, nombreEmpresa, contrasena) " + "VALUES (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, nombreProducto);
            preparedStatement.setString(2, String.valueOf(stock));
            preparedStatement.setString(3, String.valueOf(precio));

            int filaAnadida = preparedStatement.executeUpdate();
            if (filaAnadida > 0) {
                producto = new Producto();
                producto.setNombre(nombreProducto);
                producto.setStock(stock);
                producto.setPrecio(precio);

                System.out.println("Registro exitoso");

            }
        }catch(Exception e){
                e.printStackTrace();
            }

            return producto;
    }
}

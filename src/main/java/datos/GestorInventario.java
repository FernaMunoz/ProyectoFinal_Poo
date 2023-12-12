package datos;
import modelo.Usuario;
import modelo.Producto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.Arrays;
import java.util.List;

public class GestorInventario {
    public void agregarProductoAInventario(Usuario usuario, Producto producto){
        String rutaCsv = usuario.getNombre() + "_inventario.csv";

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv, true))){
            escritor.write( producto.getNombre() + ",");
            escritor.write("\"" + producto.getStock() + "\",");
            escritor.write("\"" + producto.getPrecio() + "\",");
            escritor.write("\"" + producto.getImagen() + "\"");
            escritor.newLine();

            escritor.flush();

            System.out.println("Producto agregado al inventario exitosamente");

            GestorHistorial gestorHistorial = new GestorHistorial();
            gestorHistorial.registrarNuevoProducto(usuario, producto);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static DefaultTableModel cargarInventario(String nombre) {
        DefaultTableModel modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("nombre");
        modeloTabla.addColumn("stock");
        modeloTabla.addColumn("precio");

        try (BufferedReader br = new BufferedReader(new FileReader(nombre + "_inventario.csv"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                modeloTabla.addRow(datos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modeloTabla;
    }


    public List<String> buscarProducto(Usuario usuarioActual, String productoSeleccionado) {
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> atributosProducto = null;

        System.out.println("Ruta del archivo: " + rutaCsv);

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))){
            String linea;

            while ((linea = lector.readLine()) != null) {
                List<String> atributos = Arrays.asList(linea.split(","));
                if (atributos.get(0).equals(productoSeleccionado)) {
                    atributosProducto = atributos;
                    break;
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return atributosProducto;
    }
public List<String> buscarProductoPorCodigoBarra(Usuario usuarioActual, String codigoBarra) {
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> atributosProducto = null;

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))){
            String linea;

            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String codigoBarraProducto = partes[4].replace("\"", "");

                    if (codigoBarraProducto.equals(codigoBarra)) {
                        atributosProducto = Arrays.asList(partes);
                        break;
                    }
                }
            }

            if (atributosProducto == null) {
                JOptionPane.showMessageDialog(null, "El producto no tiene un código de barras.");
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        return atributosProducto;
    }

}

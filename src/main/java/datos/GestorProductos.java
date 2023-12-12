package datos;

import modelo.Producto;
import modelo.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorProductos {
    public void modificarProducto(String productoSeleccionado, String nuevoNombre, int nuevoStock, double nuevoPrecio, Usuario usuarioActual){
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");

                String nombreProducto = partes[0].replace("\"", "");

                if (nombreProducto.equals(productoSeleccionado)) {
                    lineas.add("\"" + nuevoNombre + "\",\"" + nuevoStock + "\",\"" + nuevoPrecio + "\",\"null\"");

                    GestorHistorial gestorHistorial = new GestorHistorial();
                    gestorHistorial.registrarModificacion(usuarioActual, productoSeleccionado, nuevoNombre);

                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv))) {
            for (String linea : lineas) {
                escritor.write(linea);
                escritor.newLine();
            }

            escritor.flush();

            System.out.println("Producto modificado exitosamente");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Producto> obtenerProductosSimilares(String textoBusqueda, Usuario usuarioActual) {
        List<Producto> productosSimilares = new ArrayList<>();
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");

                String nombreProducto = partes[0].replace("\"", "");

                if (nombreProducto.contains(textoBusqueda)) {
                    String nombre = partes[0].replace("\"", "");
                    int stock = Integer.parseInt(partes[1].replace("\"", ""));
                    double precio = Double.parseDouble(partes[2].replace("\"", ""));
                    String imagen = partes[3].replace("\"", "");

                    Producto producto = new Producto(nombre, stock, precio, imagen);
                    productosSimilares.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return productosSimilares;
    }

    public void entradaStock(int cantidadStock, Usuario usuarioActual, String productoSeleccionado){
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreProducto = partes[0].replace("\"", "");
                int stockActual = Integer.parseInt(partes[1].trim().replace("\"", ""));

                if (nombreProducto.equals(productoSeleccionado)) {
                    int nuevoStock = stockActual + cantidadStock;
                    lineas.add("\"" + nombreProducto + "\",\"" + nuevoStock + "\"," + partes[2] + "," + partes[3]);

                    GestorHistorial gestorHistorial = new GestorHistorial();
                    gestorHistorial.registrarEntrada(usuarioActual, productoSeleccionado, nuevoStock);

                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        escribirCSV(rutaCsv, lineas);
    }

    public void salidaStock(int cantidadStock, Usuario usuarioActual, String productoSeleccionado){
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreProducto = partes[0].replace("\"", "");
                int stockActual = Integer.parseInt(partes[1].replace("\"", ""));

                if (nombreProducto.equals(productoSeleccionado)) {
                    int nuevoStock = stockActual - cantidadStock;
                    lineas.add("\"" + nombreProducto + "\",\"" + nuevoStock + "\"," + partes[2] + "," + partes[3]);

                    GestorHistorial gestorHistorial = new GestorHistorial();
                    gestorHistorial.registrarSalida(usuarioActual, productoSeleccionado, nuevoStock);

                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        escribirCSV(rutaCsv, lineas);
    }

    public boolean productoTieneCodigoBarra(Usuario usuarioActual, Producto producto) {
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String nombreProducto = partes[0].replace("\"", "");
                    String codigoBarra = partes[4].replace("\"", "");

                    if (nombreProducto.equals(producto.getNombre()) && codigoBarra != null && !codigoBarra.isEmpty() && !codigoBarra.equals("no hay código de barras asignado")) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }


    public void actualizarCSV(Usuario usuarioActual, Producto producto) {
        String rutaCsv = usuarioActual.getNombre() + "_inventario.csv";
        List<String> lineas = new ArrayList<>();

        try (BufferedReader lector = new BufferedReader(new FileReader(rutaCsv))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] partes = linea.split(",");
                String nombreProducto = partes[0].replace("\"", "");

                if (nombreProducto.equals(producto.getNombre())) {
                    lineas.add("\"" + producto.getNombre() + "\",\"" + producto.getStock() + "\",\"" + producto.getPrecio() + "\",\"" + producto.getImagen() + "\",\"" + producto.getCodigoBarra() + "\"");
                } else {
                    lineas.add(linea);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        escribirCSV(rutaCsv, lineas);
    }



    private void escribirCSV(String rutaCsv, List<String> lineas) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(rutaCsv))) {
            for (String linea : lineas) {
                escritor.write(linea);
                escritor.newLine();
            }

            escritor.flush();

            System.out.println("Stock modificado exitosamente");

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

}


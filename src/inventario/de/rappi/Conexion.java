package inventario.de.rappi;

import java.awt.Component;
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Conexion {

    private static final String controlador = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/inventariorappi";
    private static final String usr = "root";
    private static final String pass = "";

    // Variables productos
    public String ID_Producto;
    public String Nombre;
    public String Descripcion;
    public String Stock;
    public String Categoria;
    public String Precio;

    // Variables Order
    public String ID_Orden;
    public String Fecha_Orden;
    public String ID_Producto_Ordenado;
    public String Cantidad_Orden;
    public String Fecha_llegada;
    public String ID_Proveedor_Orden;
    public String Precio_Compra;
    public String Metodo_Compra;

    // Variables Delivery
    public String ID_Delivery;
    public String Fecha_Entrega;
    public String Fecha_Envio;
    public String Precio_Venta;
    public String ID_Producto_Transferido;
    public String Cantidad_Delivery;
    public String ID_Cliente_Delivery;
    public String Metodo_Pago;

    // Variables Cliente
    public String ID_Cliente;
    public String Nombre_Cliente;
    public String Telefono_Cliente;
    public String Correo_Cliente;
    public String Direccion_Cliente;
 

    static {
        try {
            Class.forName(controlador);
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el controlador");
            e.printStackTrace();
        }
    }

    public Connection conectar() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexion correcta");
        } catch (SQLException e) {
            System.out.println("Error de conexion");
            e.printStackTrace();
        }
        return con;
    }

    // CRUD para la tabla productos
    public PreparedStatement insertarProducto() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String insertar = "INSERT INTO productos (ID_Producto, Nombre, Descripcion, Stock, Categoria,precio) VALUES (?, ?, ?, ?, ?, ?)";
            pstm = cn.prepareStatement(insertar);
            pstm.setString(1, ID_Producto);
            pstm.setString(2, Nombre);
            pstm.setString(3, Descripcion);
            pstm.setString(4, Stock);
            pstm.setString(5, Categoria);
           pstm.setString(6, Precio);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar producto");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement seleccionarProducto() {
        Conexion con = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            cn = con.conectar();
            String seleccionar = "SELECT * FROM productos WHERE ID_Producto=?";
            pstm = cn.prepareStatement(seleccionar);
            pstm.setString(1, ID_Producto);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ID_Producto = rs.getString(1);
                Nombre = rs.getString(2);
                Descripcion = rs.getString(3);
                Stock = rs.getString(4);
                Categoria = rs.getString(5);
                Precio = rs.getString(6);
            }
            JOptionPane.showMessageDialog(null, "Consulta de producto exitosa");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto");
            e.printStackTrace();
        }
        return pstm;
    }

    public PreparedStatement actualizarProducto() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String actualizar = "UPDATE productos SET Nombre=?, Descripcion=?, Stock=?, Categoria=?,Precio? WHERE ID_Producto=?";
            pstm = cn.prepareStatement(actualizar);
            pstm.setString(1, Nombre);
            pstm.setString(2, Descripcion);
            pstm.setString(3, Stock);
            pstm.setString(4, Categoria);
            pstm.setString(5, Precio    );
            pstm.setString(6, ID_Producto);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar producto");
            e.printStackTrace();
        }
        return pstm;
    }

    public PreparedStatement eliminarProducto() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conexion.conectar();
            String eliminar = "DELETE FROM productos WHERE ID_Producto=?";
            ps = cn.prepareStatement(eliminar);
            ps.setString(1, ID_Producto);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto");
            e.setNextException(e);
        }
        return ps;
    }

    // CRUD para la tabla delivery
    public PreparedStatement insertarDelivery() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String insertar = "INSERT INTO delivery VALUES (?, ?, ?, ?, ?, ?,?)";
            pstm = cn.prepareStatement(insertar);
            pstm.setString(1, ID_Delivery);
            pstm.setString(2, Fecha_Entrega);
            pstm.setString(3, Fecha_Envio);
            pstm.setString(4, ID_Producto_Transferido);
            pstm.setString(5, Cantidad_Delivery);
            pstm.setString(6, ID_Cliente);
            pstm.setString(7, Metodo_Pago);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delivery agregado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar delivery");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement seleccionarDelivery() {
        Conexion con = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            cn = con.conectar();
            String seleccionar = "SELECT * FROM delivery WHERE ID_Delivery=?";
            pstm = cn.prepareStatement(seleccionar);
            pstm.setString(1, ID_Delivery);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ID_Delivery = rs.getString(1);
                Fecha_Entrega = rs.getString(2);
                Fecha_Envio = rs.getString(3);
                ID_Producto_Transferido = rs.getString(4);
                Cantidad_Delivery = rs.getString(5);
                ID_Cliente = rs.getString(6);
                Metodo_Pago = rs.getString(7);
            }
            JOptionPane.showMessageDialog(null, "Consulta de delivery exitosa");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar delivery");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement actualizarDelivery() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String actualizar = "UPDATE delivery SET Fecha_Entrega=?, Fecha_Envio=?, ID_Producto_Transferido=?, Cantidad=?, ID_Cliente=?, Metodo_Pago =? WHERE ID_Delivery=?";
            pstm = cn.prepareStatement(actualizar);
            pstm.setString(1, Fecha_Entrega);
            pstm.setString(2, Fecha_Envio);
            pstm.setString(3, ID_Producto_Transferido);
            pstm.setString(4, Cantidad_Delivery);
            pstm.setString(5, ID_Cliente);
            pstm.setString(6, Metodo_Pago);
            pstm.setString(7, ID_Delivery);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delivery actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar delivery");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement eliminarDelivery() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conexion.conectar();
            String eliminar = "DELETE FROM delivery WHERE ID_Delivery=?";
            ps = cn.prepareStatement(eliminar);
            ps.setString(1, ID_Delivery);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Delivery eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar delivery");
            e.setNextException(e);
        }
        return ps;
    }

        // CRUD para la tabla cliente
    public PreparedStatement insertarCliente() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String insertar = "INSERT INTO cliente VALUES (?, ?, ?, ?, ?)";
            pstm = cn.prepareStatement(insertar);
            pstm.setString(1, ID_Cliente);
            pstm.setString(2, Nombre_Cliente);
            pstm.setString(3, Telefono_Cliente);
            pstm.setString(4, Correo_Cliente);
            pstm.setString(5, Direccion_Cliente);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar cliente");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement seleccionarCliente() {
        Conexion con = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            cn = con.conectar();
            String seleccionar = "SELECT * FROM cliente WHERE Id_Cliente=?";
            pstm = cn.prepareStatement(seleccionar);
            pstm.setString(1, ID_Cliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ID_Cliente = rs.getString(1);
                Nombre_Cliente = rs.getString(2);
                Telefono_Cliente = rs.getString(3);
                Correo_Cliente = rs.getString(4);
                Direccion_Cliente = rs.getString(5);
            }
            JOptionPane.showMessageDialog(null, "Consulta de cliente exitosa");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar cliente");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement actualizarCliente() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String actualizar = "UPDATE cliente SET Nombre_Cliente=?, Telefono_Cliente=?, Correo_Cliente=?, Direccion_Cliente=? WHERE Id_Cliente=?";
            pstm = cn.prepareStatement(actualizar);
            pstm.setString(1, Nombre_Cliente);
            pstm.setString(2, Telefono_Cliente);
            pstm.setString(3, Correo_Cliente);
            pstm.setString(4, Direccion_Cliente);
            pstm.setString(5, ID_Cliente);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement eliminarCliente() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conexion.conectar();
            String eliminar = "DELETE FROM cliente WHERE Id_Cliente=?";
            ps = cn.prepareStatement(eliminar);
            ps.setString(1, ID_Cliente);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente");
            e.setNextException(e);
        }
        return ps;
    }

        // CRUD para la tabla orden
    public PreparedStatement insertarOrden() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String insertar = "INSERT INTO orden VALUES (?, ?, ?, ?, ?, ?,?)";
            pstm = cn.prepareStatement(insertar);
            pstm.setString(1, ID_Orden);
            pstm.setString(2, Fecha_Orden);
            pstm.setString(3, ID_Producto_Ordenado);
            pstm.setString(4, Cantidad_Orden);
            pstm.setString(5, Fecha_llegada);
           pstm.setString(6, Precio_Compra);
           pstm.setString(7, Metodo_Compra);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Orden agregada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al insertar orden");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement seleccionarOrden() {
        Conexion con = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            cn = con.conectar();
            String seleccionar = "SELECT * FROM orden WHERE ID_Order=?";
            pstm = cn.prepareStatement(seleccionar);
            pstm.setString(1, ID_Orden);
            rs = pstm.executeQuery();
            while (rs.next()) {
                ID_Orden = rs.getString(1);
                Fecha_Orden = rs.getString(2);
                ID_Producto_Ordenado = rs.getString(3);
                Cantidad_Orden = rs.getString(4);
                Fecha_llegada = rs.getString(5);
               Precio_Compra = rs.getString(6);
              Metodo_Compra = rs.getString(7);
            }
            JOptionPane.showMessageDialog(null, "Consulta de orden exitosa");
        } catch (SQLException e) {
            System.out.println("Error al seleccionar orden");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement actualizarOrden() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement pstm = null;
        try {
            cn = conexion.conectar();
            String actualizar = "UPDATE orden SET Fecha_Orden=?, ID_Producto_Ordenado=?, ID_Cantidad=?, Fecha_llegada=?, Precio_Compra=?, Metodo_Compra=? WHERE ID_Order=?";
            pstm = cn.prepareStatement(actualizar);
            pstm.setString(1, Fecha_Orden);
            pstm.setString(2, ID_Producto_Ordenado);
            pstm.setString(3, Cantidad_Orden);
            pstm.setString(4, Fecha_llegada);
            pstm.setString(5, Precio_Compra);
            pstm.setString(6, Metodo_Compra);
            pstm.setString(6, ID_Orden);

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Orden actualizada correctamente");

        } catch (SQLException e) {
            System.out.println("Error al actualizar orden");
            e.setNextException(e);
        }
        return pstm;
    }

    public PreparedStatement eliminarOrden() {
        Conexion conexion = new Conexion();
        Connection cn = null;
        PreparedStatement ps = null;
        try {
            cn = conexion.conectar();
            String eliminar = "DELETE FROM orden WHERE ID_Order=?";
            ps = cn.prepareStatement(eliminar);
            ps.setString(1, ID_Orden);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Orden eliminada correctamente");
        } catch (SQLException e) {
            System.out.println("Error al eliminar orden");
            e.setNextException(e);
        }
        return ps;
    }
    
    public ArrayList<String> obtenerProductos() {
        ArrayList<String> resultados = new ArrayList<>();
        Connection cn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            cn = conectar();
            String seleccionar = "SELECT Nombre, Descripcion, Stock FROM productos";
            pstm = cn.prepareStatement(seleccionar);
            rs = pstm.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                String descripcion = rs.getString("Descripcion");
                String stock = rs.getString("Stock");

                // Agregar la información al resultado
                resultados.add("Nombre: " + nombre + ", Descripción: " + descripcion + ", Stock: " + stock);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener productos");
            e.setNextException(e);
        } finally {
            // Cerrar recursos
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (cn != null) cn.close();
            } catch (SQLException e) {
                e.setNextException(e);
            }
        }

        return resultados;
    }

        public PreparedStatement limpiarCamposTexto(Container container) {
        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setText("");
            } else if (component instanceof Container) {
                limpiarCamposTexto((Container) component);
            }
        }
        return null;
    }

        public void cerrarConexion() {
        }

        public String[] buscarProductos(String busqueda) {
            Connection con = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            ArrayList<String> resultados = new ArrayList<>();

            try {
                con = conectar();
                String consulta = "SELECT Nombre FROM productos WHERE Nombre LIKE ?";
                pstm = con.prepareStatement(consulta);
                pstm.setString(1, "%" + busqueda + "%");
                rs = pstm.executeQuery();

                while (rs.next()) {
                    resultados.add(rs.getString("Nombre"));
                    /*resultados.add(rs.getString("Stock"));
                    resultados.add(rs.getString("Precio"));*/
                }
            } catch (SQLException e) {
                System.out.println("Error al buscar productos");
                e.setNextException(e);
            } finally {
                cerrarConexion(con, pstm, rs);
            }

            return resultados.toArray(new String[0]);
        }

        public ArrayList<String> obtenerCategorias() {
            Connection con = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            ArrayList<String> categorias = new ArrayList<>();

            try {
                con = conectar();
                String consulta = "SELECT DISTINCT Categoria FROM productos";
                pstm = con.prepareStatement(consulta);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    categorias.add(rs.getString("Categoria"));
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener categorías");
                e.setNextException(e);
            } finally {
                cerrarConexion(con, pstm, rs);
            }

            return categorias;
        }
        public String[] obtenerProductosPorCategoria (String categoria) {
            Connection con = null;
            PreparedStatement pstm = null;
            ResultSet rs = null;
            ArrayList<String> productos = new ArrayList<>();

            try {
                con = conectar();
                String consulta = "SELECT Nombre FROM productos WHERE Categoria = ?";
                pstm = con.prepareStatement(consulta);
                pstm.setString(1, categoria);
                rs = pstm.executeQuery();

                while (rs.next()) {
                    productos.add(rs.getString("Nombre"));
                }
            } catch (SQLException e) {
                System.out.println("Error al obtener productos por categoría");
                e.setNextException(e);
            } finally {
                cerrarConexion(con, pstm, rs);
            }

            return productos.toArray(new String[0]);
        }
        private void cerrarConexion(Connection con, PreparedStatement pstm, ResultSet rs) {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión");
                e.printStackTrace();
            }
        }
}

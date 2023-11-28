package inventario.de.rappi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfazBusquedaProductos {

    private JFrame frame;
    private JTextField textFieldBusqueda;
    private JList<String> resultList;
    private DefaultListModel<String> listModel;

    Conexion conexionProducto = new Conexion();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazBusquedaProductos window = new InterfazBusquedaProductos();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public InterfazBusquedaProductos() {
        initialize();
        mostrarTodosLosProductos();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Búsqueda de Productos");
        frame.setBounds(100, 100, 837, 568);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        textFieldBusqueda = new JTextField();
        textFieldBusqueda.setBounds(10, 11, 250, 34);
        frame.getContentPane().add(textFieldBusqueda);
        textFieldBusqueda.setColumns(10);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> buscarProductos(textFieldBusqueda.getText()));
        btnBuscar.setBounds(286, 9, 137, 36);
        frame.getContentPane().add(btnBuscar);

        listModel = new DefaultListModel<>();
        resultList = new JList<>(listModel);
        resultList.setBounds(1, 1, 812, 520);
        frame.getContentPane().add(resultList);

        JButton btnRegresar = new JButton("Regresar al Menú Principal");
        btnRegresar.addActionListener(e -> mostrarTodosLosProductos());
        btnRegresar.setBounds(433, 7, 230, 41);
        frame.getContentPane().add(btnRegresar);

        JScrollPane scrollPane = new JScrollPane(resultList);
        scrollPane.setBounds(10, 74, 896, 600);
        frame.getContentPane().add(scrollPane);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(e -> {
            String selectedProduct = resultList.getSelectedValue();
            if (selectedProduct != null) {
                JOptionPane.showMessageDialog(null, "Producto seleccionado: " + selectedProduct);
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona un producto primero");
            }
        });
        btnSeleccionar.setBounds(289, 684, 187, 47);
        frame.getContentPane().add(btnSeleccionar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> System.exit(0));
        btnSalir.setBounds(780, 684, 126, 47);
        frame.getContentPane().add(btnSalir);
    }

    private void buscarProductos(String busqueda) {
        listModel.clear();
        String[] resultados = conexionProducto.buscarProductos(busqueda);
        if (resultados != null && resultados.length > 0) {
            for (String producto : resultados) {
                listModel.addElement(producto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron resultados");
        }
    }

    private void mostrarTodosLosProductos() {
        listModel.clear();
        ArrayList<String> productos = conexionProducto.obtenerProductos();
        if (productos != null && !productos.isEmpty()) {
            for (String producto : productos) {
                listModel.addElement(producto);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos disponibles");
        }
    }

    public void mostrarVentanaBusquedaProductos() {
        frame.setVisible(true);
    }
}

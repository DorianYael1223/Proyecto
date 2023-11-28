package inventario.de.rappi;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Menu {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu window = new Menu();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Menu() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 347, 409);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btn_productos = new JButton("PRODUCTOS");
        btn_productos.setBounds(90, 74, 110, 23);
        frame.getContentPane().add(btn_productos);
        btn_productos.addActionListener(e -> {
            InterfazProductos delivery = new InterfazProductos();
            delivery.mostrarVentanaProducto();
        });
        
        JButton btn_Customers = new JButton("CUSTOMERS");
        btn_Customers.setBounds(90, 171, 110, 23);
        frame.getContentPane().add(btn_Customers);
        btn_Customers.addActionListener(e -> {
            InterfazClientes delivery = new InterfazClientes();
            delivery.mostrarVentanaClientes();
        });
         JButton btn_Proveedores = new JButton("MOSTRAR PRODUCTOS");
        btn_Proveedores.setBounds(90, 122, 110, 23);
        frame.getContentPane().add(btn_Proveedores);
        btn_Proveedores.addActionListener(e -> {
            InterfazBusquedaProductos delivery = new InterfazBusquedaProductos();
            delivery.mostrarVentanaBusquedaProductos();
        });

        JButton btn_Order = new JButton("ORDER");
        btn_Order.setBounds(90, 228, 110, 23);
        frame.getContentPane().add(btn_Order);
        btn_Order.addActionListener(e -> {
            InterfazOrden delivery = new InterfazOrden();
            delivery.mostrarVentanaOrden();
        });

        JButton btn_Delivery = new JButton("DELIVERY");
        btn_Delivery.setBounds(90, 280, 110, 23);
        frame.getContentPane().add(btn_Delivery);

        btn_Delivery.addActionListener(e -> {
            InterfazDelivery delivery = new InterfazDelivery();
            delivery.mostrarVentanaDelivery();
        });

        JButton btn_Salir = new JButton("Salir");
        btn_Salir.addActionListener(e -> System.exit(0));
        btn_Salir.setBounds(217, 324, 89, 23);
        frame.getContentPane().add(btn_Salir);

        JLabel lblNewLabel = new JLabel("Inventario Rappi .");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(45, 11, 212, 44);
        frame.getContentPane().add(lblNewLabel);
    }
}

package inventario.de.rappi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class InterfazProductos {

    private JFrame frame;
    private JTextField text_Id;
    private JTextField text_Nom;
    private JTextField text_Desc;
    private JTextField text_Stoc;
    private JTextField text_Cat;
    private JTextField text_Prec;

    Conexion conexion = new Conexion();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazProductos window = new InterfazProductos();
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
    public InterfazProductos() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 454, 402);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblId_Produc = new JLabel("ID_Producto");
        lblId_Produc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblId_Produc.setBounds(20, 80, 101, 14);
        frame.getContentPane().add(lblId_Produc);

        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNombre.setBounds(20, 122, 80, 14);
        frame.getContentPane().add(lblNombre);

        JLabel lblDescripcion = new JLabel("Descripcion");
        lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDescripcion.setBounds(20, 169, 80, 14);
        frame.getContentPane().add(lblDescripcion);

        JLabel lblStock = new JLabel("Stock");
        lblStock.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblStock.setBounds(20, 214, 67, 14);
        frame.getContentPane().add(lblStock);

        JLabel lblCategorias = new JLabel("Categoria");
        lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCategorias.setBounds(20, 261, 80, 19);
        frame.getContentPane().add(lblCategorias);

        JLabel lbl_Prec = new JLabel("Precio");
        lbl_Prec.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Prec.setBounds(20, 304, 67, 14);
        frame.getContentPane().add(lbl_Prec);

        text_Id = new JTextField();
        text_Id.setBounds(157, 79, 86, 20);
        frame.getContentPane().add(text_Id);
        text_Id.setColumns(10);

        text_Nom = new JTextField();
        text_Nom.setBounds(157, 121, 86, 20);
        frame.getContentPane().add(text_Nom);
        text_Nom.setColumns(10);

        text_Desc = new JTextField();
        text_Desc.setBounds(157, 168, 86, 20);
        frame.getContentPane().add(text_Desc);
        text_Desc.setColumns(10);

        text_Stoc = new JTextField();
        text_Stoc.setBounds(157, 213, 86, 20);
        frame.getContentPane().add(text_Stoc);
        text_Stoc.setColumns(10);

        text_Cat = new JTextField();
        text_Cat.setBounds(157, 260, 86, 20);
        frame.getContentPane().add(text_Cat);
        text_Cat.setColumns(10);

        text_Prec = new JTextField();
        text_Prec.setBounds(157, 303, 86, 20);
        frame.getContentPane().add(text_Prec);
        text_Prec.setColumns(10);

        JLabel lblNewLabel = new JLabel("Productos");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(160, 21, 93, 32);
        frame.getContentPane().add(lblNewLabel);

        JButton btn_Ins = new JButton("Insertar");
        btn_Ins.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de agregar estos datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    conexion.ID_Producto = text_Id.getText();
                    conexion.Nombre = text_Nom.getText();
                    conexion.Descripcion = text_Desc.getText();
                    conexion.Stock = text_Stoc.getText();
                    conexion.Categoria = text_Cat.getText();
                    conexion.Precio = text_Prec.getText();
                    conexion.insertarProducto();
                    limpiarCajas();
                }
            }
        });
        btn_Ins.setBounds(313, 78, 89, 23);
        frame.getContentPane().add(btn_Ins);

        JButton btn_Act = new JButton("Actualizar");
        btn_Ins.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                conexion.ID_Producto = text_Id.getText();
                conexion.Nombre = text_Nom.getText();
                conexion.Descripcion = text_Desc.getText();
                conexion.Stock = text_Stoc.getText();
                conexion.Categoria = text_Cat.getText();
                conexion.Precio = text_Prec.getText();
                conexion.actualizarProducto();
                limpiarCajas();
            }
        });
        btn_Act.setBounds(313, 120, 89, 23);
        frame.getContentPane().add(btn_Act);

        JButton btn_Selec = new JButton("Seleccionar");
        btn_Selec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Producto = text_Id.getText();
                conexion.seleccionarProducto();
                text_Nom.setText(conexion.Nombre);
                text_Desc.setText(conexion.Descripcion);
                text_Stoc.setText(conexion.Stock);
                text_Cat.setText(conexion.Categoria);
                text_Prec.setText(conexion.Precio);

            }
        });
        btn_Selec.setBounds(313, 167, 89, 23);
        frame.getContentPane().add(btn_Selec);

        JButton btn_Elim = new JButton("Eliminar");
        btn_Elim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Producto = text_Id.getText();
                conexion.eliminarProducto();
                limpiarCajas();
            }
        });
        btn_Elim.setBounds(313, 212, 89, 23);
        frame.getContentPane().add(btn_Elim);

        JButton btn_Sal = new JButton("Salir");
        btn_Sal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btn_Sal.setBounds(313, 329, 89, 23);
        frame.getContentPane().add(btn_Sal);
    }
    private void limpiarCajas() {
        text_Id.setText("");
        text_Nom.setText("");
        text_Desc.setText("");
        text_Stoc.setText("");
        text_Cat.setText("");
        text_Prec.setText("");
    }
    
     public void mostrarVentanaProducto() {
    frame.setVisible(true);
}
    
    }
    

package inventario.de.rappi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class InterfazOrden {

    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;

    Conexion conexion = new Conexion();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazOrden window = new InterfazOrden();
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
    public InterfazOrden() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 505, 456);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Orden");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel.setBounds(184, 11, 78, 22);
        frame.getContentPane().add(lblNewLabel);

        JLabel lbl_Orden_id = new JLabel("ID_Orden");
        lbl_Orden_id.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Orden_id.setBounds(22, 63, 78, 14);
        frame.getContentPane().add(lbl_Orden_id);

        JLabel lbl_fec = new JLabel("Fecha Orden");
        lbl_fec.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_fec.setBounds(22, 107, 85, 14);
        frame.getContentPane().add(lbl_fec);

        JLabel lbl_Prod = new JLabel("Id_Producto_Ordenado");
        lbl_Prod.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Prod.setBounds(22, 154, 159, 14);
        frame.getContentPane().add(lbl_Prod);

        JLabel lbl_canti = new JLabel("Cantidad Ordenada");
        lbl_canti.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_canti.setBounds(22, 198, 130, 14);
        frame.getContentPane().add(lbl_canti);

        JLabel lbl_Fech = new JLabel("Fecha llegada");
        lbl_Fech.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Fech.setBounds(22, 242, 117, 14);
        frame.getContentPane().add(lbl_Fech);

        JLabel lbl_Pre = new JLabel("Precio compra");
        lbl_Pre.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Pre.setBounds(22, 278, 102, 14);
        frame.getContentPane().add(lbl_Pre);

        JLabel lbl_MetCom = new JLabel("Metodo compra");
        lbl_MetCom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_MetCom.setBounds(22, 318, 102, 14);
        frame.getContentPane().add(lbl_MetCom);

        textField = new JTextField();
        textField.setBounds(194, 62, 130, 20);
        frame.getContentPane().add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(194, 106, 130, 20);
        frame.getContentPane().add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBounds(194, 153, 133, 20);
        frame.getContentPane().add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(194, 197, 140, 20);
        frame.getContentPane().add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(195, 241, 139, 20);
        frame.getContentPane().add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(194, 277, 140, 20);
        frame.getContentPane().add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(194, 317, 140, 20);
        frame.getContentPane().add(textField_6);
        textField_6.setColumns(10);

        JButton btnNewButton = new JButton("Insertar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de agregar estos datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    conexion.ID_Orden = textField.getText();
                    conexion.Fecha_Orden = textField_1.getText();
                    conexion.ID_Producto_Ordenado = textField_2.getText();
                    conexion.Cantidad_Orden = textField_3.getText();
                    conexion.Fecha_llegada = textField_4.getText();
                    conexion.Precio_Compra = textField_5.getText();
                    conexion.Metodo_Compra = textField_6.getText();
                    conexion.insertarOrden();
                    limpiarCajas();
                }
            }
        });
        btnNewButton.setBounds(372, 61, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Actualizar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    conexion.ID_Orden = textField.getText();
                    conexion.Fecha_Orden = textField_1.getText();
                    conexion.ID_Producto_Ordenado = textField_2.getText();
                    conexion.Cantidad_Orden = textField_3.getText();
                    conexion.Fecha_llegada = textField_4.getText();
                    conexion.Precio_Compra = textField_5.getText();
                    conexion.Metodo_Compra = textField_6.getText();
                    conexion.actualizarOrden();
                    limpiarCajas();
            }
        });
        btnNewButton_1.setBounds(372, 105, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Seleccionar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Orden = textField.getText();
                conexion.seleccionarOrden();
                textField_1.setText(conexion.Fecha_Orden);
                textField_2.setText(conexion.ID_Producto_Ordenado);
                textField_3.setText(conexion.Cantidad_Orden);
                textField_4.setText(conexion.Fecha_llegada);
                textField_5.setText(conexion.Precio_Compra);
                textField_6.setText(conexion.Metodo_Compra);
                limpiarCajas();
            }
        });
        btnNewButton_2.setBounds(372, 152, 89, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Eliminar");
         btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Orden = textField.getText();
                conexion.eliminarOrden();
                limpiarCajas();
            }
        });
        btnNewButton_3.setBounds(372, 196, 89, 23);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Salir");
          btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnNewButton_4.setBounds(372, 353, 89, 23);
        frame.getContentPane().add(btnNewButton_4);
    }
     private void limpiarCajas() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
        textField_4.setText("");
        textField_5.setText("");
        textField_6.setText("");
    }
     public void mostrarVentanaOrden() {
    frame.setVisible(true);
}

}

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

public class InterfazDelivery {

    private JFrame frame;
    private JTextField textid;
    private JTextField textFec;
    private JTextField text_Fec2;
    private JTextField text_IdProd;
    private JTextField text_Can;
    private JTextField text_IdClien;
    private JTextField text_Mpago;

    Conexion conexion = new Conexion();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazDelivery window = new InterfazDelivery();
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
    public InterfazDelivery() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 469, 416);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Delivery");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(176, 25, 96, 29);
        frame.getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("ID_Delivery");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(26, 75, 83, 14);
        frame.getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("Fecha entrega");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(26, 116, 102, 14);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("Fecha envio");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(26, 158, 83, 14);
        frame.getContentPane().add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("Id_Producto");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_4.setBounds(26, 196, 83, 14);
        frame.getContentPane().add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("Cantidad Delivery");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_5.setBounds(26, 232, 126, 14);
        frame.getContentPane().add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("Id Cliente");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_6.setBounds(26, 273, 67, 14);
        frame.getContentPane().add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("Metodo Pago");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_7.setBounds(26, 311, 83, 17);
        frame.getContentPane().add(lblNewLabel_7);

        textid = new JTextField();
        textid.setBounds(176, 74, 116, 20);
        frame.getContentPane().add(textid);
        textid.setColumns(10);

        textFec = new JTextField();
        textFec.setBounds(176, 115, 116, 20);
        frame.getContentPane().add(textFec);
        textFec.setColumns(10);

        text_Fec2 = new JTextField();
        text_Fec2.setBounds(176, 157, 116, 20);
        frame.getContentPane().add(text_Fec2);
        text_Fec2.setColumns(10);

        text_IdProd = new JTextField();
        text_IdProd.setBounds(176, 195, 116, 20);
        frame.getContentPane().add(text_IdProd);
        text_IdProd.setColumns(10);

        text_Can = new JTextField();
        text_Can.setBounds(176, 231, 116, 20);
        frame.getContentPane().add(text_Can);
        text_Can.setColumns(10);

        text_IdClien = new JTextField();
        text_IdClien.setBounds(176, 272, 116, 20);
        frame.getContentPane().add(text_IdClien);
        text_IdClien.setColumns(10);

        text_Mpago = new JTextField();
        text_Mpago.setBounds(176, 311, 116, 20);
        frame.getContentPane().add(text_Mpago);
        text_Mpago.setColumns(10);

        JButton btn_Insertar = new JButton("Insertar");
        btn_Insertar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro de agregar estos datos?", "Confirmar", JOptionPane.YES_NO_OPTION);
                if (opcion == JOptionPane.YES_OPTION) {
                    conexion.ID_Delivery = textid.getText();
                    conexion.Fecha_Entrega = textFec.getText();
                    conexion.Fecha_Envio = text_Fec2.getText();
                    conexion.ID_Producto_Transferido = text_IdProd.getText();
                    conexion.Cantidad_Delivery = text_Can.getText();
                    conexion.ID_Cliente_Delivery = text_IdClien.getText();
                    conexion.insertarDelivery();
                    limpiarCajas();
                }
            }
        });
        btn_Insertar.setBounds(339, 73, 89, 23);
        frame.getContentPane().add(btn_Insertar);

        JButton btn_Act = new JButton("Actualizar");
        btn_Act.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Delivery = textid.getText();
                    conexion.Fecha_Entrega = textFec.getText();
                    conexion.Fecha_Envio = text_Fec2.getText();
                    conexion.ID_Producto_Transferido = text_IdProd.getText();
                    conexion.Cantidad_Delivery = text_Can.getText();
                    conexion.ID_Cliente_Delivery = text_IdClien.getText();
                    conexion.actualizarDelivery();
                limpiarCajas();
            }
        });
        btn_Act.setBounds(339, 114, 89, 23);
        frame.getContentPane().add(btn_Act);

        JButton btn_Selec = new JButton("Seleccionar");
         btn_Selec.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Delivery = textid.getText();
                conexion.seleccionarDelivery();
                textFec.setText(conexion.Fecha_Entrega);
                text_Fec2.setText(conexion.Fecha_Envio);
                text_IdProd.setText(conexion.ID_Producto_Transferido);
                text_Can.setText(conexion.Cantidad_Delivery);
                text_IdClien.setText(conexion.ID_Cliente_Delivery);
            }
        });
        btn_Selec.setBounds(339, 156, 89, 23);
        frame.getContentPane().add(btn_Selec);

        JButton btn_Elimi = new JButton("Eliminar");
         btn_Elimi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Delivery = textid.getText();
                conexion.eliminarDelivery();
                limpiarCajas();
            }
        });
        btn_Elimi.setBounds(339, 208, 89, 23);
        frame.getContentPane().add(btn_Elimi);

        JButton btn_Sal = new JButton("Salir");
          btn_Sal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btn_Sal.setBounds(339, 310, 89, 23);
        frame.getContentPane().add(btn_Sal);
    }

    private void limpiarCajas() {
        textid.setText("");
        textFec.setText("");
        text_Fec2.setText("");
        text_IdProd.setText("");
        text_Can.setText("");
        text_IdClien.setText("");
    }

    public void mostrarVentanaDelivery() {
        frame.setVisible(true);
    }
}

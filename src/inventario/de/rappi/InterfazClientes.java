package inventario.de.rappi;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class InterfazClientes {

    private JFrame frame;
    private JTextField text_id;
    private JTextField text_Nom;
    private JTextField text_Tele;
    private JTextField text_Corre;
    private JTextField text_Direc;

    Conexion conexion = new Conexion();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfazClientes window = new InterfazClientes();
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
    public InterfazClientes() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 463, 414);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lbl_Clien = new JLabel("Clientes");
        lbl_Clien.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbl_Clien.setBounds(177, 22, 83, 26);
        frame.getContentPane().add(lbl_Clien);

        JLabel lbl_ID_clien = new JLabel("Id");
        lbl_ID_clien.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_ID_clien.setBounds(20, 75, 46, 14);
        frame.getContentPane().add(lbl_ID_clien);

        JLabel lblNewLabel_2 = new JLabel("Nombre Cliente");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(20, 119, 100, 14);
        frame.getContentPane().add(lblNewLabel_2);

        JLabel lbl_Clie = new JLabel("Telefono Cliente");
        lbl_Clie.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Clie.setBounds(20, 159, 117, 14);
        frame.getContentPane().add(lbl_Clie);

        JLabel lbl_Corr = new JLabel("Correo Cliente");
        lbl_Corr.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Corr.setBounds(20, 204, 100, 14);
        frame.getContentPane().add(lbl_Corr);

        JLabel lbl_Direc = new JLabel("Direccion");
        lbl_Direc.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbl_Direc.setBounds(20, 253, 83, 14);
        frame.getContentPane().add(lbl_Direc);

        text_id = new JTextField();
        text_id.setBounds(158, 74, 86, 20);
        frame.getContentPane().add(text_id);
        text_id.setColumns(10);

        text_Nom = new JTextField();
        text_Nom.setBounds(158, 118, 86, 20);
        frame.getContentPane().add(text_Nom);
        text_Nom.setColumns(10);

        text_Tele = new JTextField();
        text_Tele.setBounds(158, 158, 86, 20);
        frame.getContentPane().add(text_Tele);
        text_Tele.setColumns(10);

        text_Corre = new JTextField();
        text_Corre.setBounds(158, 203, 86, 20);
        frame.getContentPane().add(text_Corre);
        text_Corre.setColumns(10);

        text_Direc = new JTextField();
        text_Direc.setBounds(158, 252, 86, 20);
        frame.getContentPane().add(text_Direc);
        text_Direc.setColumns(10);

        JButton btnNewButton = new JButton("Insertar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int opcion = JOptionPane.showConfirmDialog(null, "Seguro que deseas agregar datos ");
                if (opcion == JOptionPane.YES_OPTION) {
                    conexion.ID_Cliente = text_id.getText();
                    conexion.Nombre_Cliente = text_Nom.getText();
                    conexion.Telefono_Cliente = text_Tele.getText();
                    conexion.Correo_Cliente = text_Corre.getText();
                    conexion.Direccion_Cliente = text_Direc.getText();
                    conexion.insertarCliente();
                    limpiarCajas();
                }
            }
        });
        btnNewButton.setBounds(316, 73, 89, 23);
        frame.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Actualizar");
          btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Cliente = text_id.getText();
                conexion.Nombre_Cliente = text_Nom.getText();
                conexion.Telefono_Cliente = text_Tele.getText();
                conexion.Correo_Cliente = text_Corre.getText();
                conexion.Direccion_Cliente = text_Direc.getText();
                conexion.actualizarCliente();
                limpiarCajas();
            }
        });
        btnNewButton_1.setBounds(316, 117, 89, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Seleccionar");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Cliente = text_id.getText();
                conexion.seleccionarCliente();
                text_Nom.setText(conexion.Nombre_Cliente);
                text_Tele.setText(conexion.Telefono_Cliente);
                text_Corre.setText(conexion.Correo_Cliente);
                text_Direc.setText(conexion.Direccion_Cliente);
            }
        });
        btnNewButton_2.setBounds(316, 170, 89, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("Eliminar");
         btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conexion.ID_Cliente = text_id.getText();
                conexion.eliminarCliente();
                limpiarCajas();
            }
        });
        btnNewButton_3.setBounds(316, 223, 89, 23);
        frame.getContentPane().add(btnNewButton_3);

        JButton btnNewButton_4 = new JButton("Salir");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnNewButton_4.setBounds(316, 317, 89, 23);
        frame.getContentPane().add(btnNewButton_4);
    }
    private void limpiarCajas() {
        text_id.setText("");
        text_Nom.setText("");
        text_Tele.setText("");
        text_Corre.setText("");
        text_Direc.setText("");
    }
     public void mostrarVentanaClientes() {
    frame.setVisible(true);
}

}

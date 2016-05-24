/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Nico
 */
public class VistaRegistro extends JFrame {
    
    protected static JPanel pnlPrincipal;
    protected static JTextField txtUsuario;
    protected static JPasswordField txtPassword;
    protected static JLabel lblUsuario;
    protected static JLabel lblPassword;
    protected static JButton btnRegistro;
    
    public VistaRegistro() {
        this.setSize(350, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new GridLayout(3,2));
        
        lblUsuario = new JLabel("Usuario: ");
        lblPassword = new JLabel("Contraseña: ");
        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();
        btnRegistro = new JButton("Registrarse");

        pnlPrincipal.add(lblUsuario);
        pnlPrincipal.add(txtUsuario);
        pnlPrincipal.add(lblPassword);
        pnlPrincipal.add(txtPassword);
        pnlPrincipal.add(btnRegistro);
        this.add(pnlPrincipal);

    }

    public String getUsuario() {
        return txtUsuario.getText();
    }

    public String getPassword() {
        return txtPassword.getText();
    }

    public void addVistaRegistroListener(ActionListener listenBoton) {
        btnRegistro.addActionListener(listenBoton);
    }

    public void mostrarErrores(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError);
    }
    
}

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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Nico
 */
public class VistaPrincipal extends JFrame {
    
    private static JPanel pnlPrincipal;
    private static JTextField txtUsuario;
    private static JTextField txtPassword;
    private static JLabel lblUsuario;
    private static JLabel lblPassword;
    private static JButton btnRegistro;
    private static JButton btnLogin;
    
    public VistaPrincipal() {
        this.setSize(350, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        pnlPrincipal = new JPanel();
        pnlPrincipal.setLayout(new GridLayout(3,2));
        
        lblUsuario = new JLabel("Usuario: ");
        lblPassword = new JLabel("Contraseña: ");
        txtUsuario = new JTextField();
        txtPassword = new JTextField();
        btnRegistro = new JButton("¿No tienes cuenta?");
        btnLogin = new JButton("Iniciar sesión");

        pnlPrincipal.add(lblUsuario);
        pnlPrincipal.add(txtUsuario);
        pnlPrincipal.add(lblPassword);
        pnlPrincipal.add(txtPassword);
        //pnlPrincipal.add(btnRegistro);
        pnlPrincipal.add(btnLogin);
        this.add(pnlPrincipal);
        
        this.setVisible(true);
    }
    
    public String getUsuario() {
        return txtUsuario.getText();
    }
    
    public String getPassword() {
        return txtPassword.getText();
    }
    
    public void addVistaBDListener(ActionListener listenBoton) {
        btnRegistro.addActionListener(listenBoton);
        btnLogin.addActionListener(listenBoton);
    }

    public void mostrarErrores(String mensajeError) {
        JOptionPane.showMessageDialog(this, mensajeError);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import static Vista.VistaRegistro.btnRegistro;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Nico
 */
public class VistaAdminLiga extends JFrame {
    
    private JPanel pnl = new JPanel();
    private JLabel lblNombre = new JLabel("Nombre:");
    private JLabel lblPais = new JLabel("Pais:");
    private JTextField txtNombre = new JTextField();
    private JTextField txtPais = new JTextField();
    JButton btnCrearLiga = new JButton("Crear");
    JButton btnModificarLiga = new JButton("Modificar");
    JButton btnBorrarLiga = new JButton("Borrar");

    public VistaAdminLiga() {
        this.setSize(250, 150);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void crearLiga() {

        pnl.setLayout(new GridLayout(3, 2));
        pnl.add(lblNombre);
        pnl.add(txtNombre);
        pnl.add(lblPais);
        pnl.add(txtPais);
        pnl.add(btnCrearLiga);
        this.add(pnl);
        this.setVisible(true);

    }
    
    public void modificarLiga() {

        pnl.setLayout(new GridLayout(2, 2));
        pnl.add(lblNombre);
        pnl.add(txtNombre);
        pnl.add(lblPais);
        pnl.add(txtPais);
        this.add(pnl);
        this.setVisible(true);

    }
    
    public void borrarLiga() {
        
    }
    
    public void addVistaLigaListener(ActionListener listenBoton) {
        btnCrearLiga.addActionListener(listenBoton);
    }
    
    /**
     * @return the txtNombre
     */
    public String getTxtNombre() {
        return txtNombre.getText();
    }
    
    /**
     * @param txtNombre the txtNombre to set
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * @return the txtPais
     */
    public String getTxtPais() {
        return txtPais.getText();
    }

    /**
     * @param txtPais the txtPais to set
     */
    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }
    
    

}
    


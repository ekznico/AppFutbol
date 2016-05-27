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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Nico
 */
public class VistaAdminLiga {
    
    private JFrame frCrear = new JFrame();
    private JFrame frModificar = new JFrame();
    private JFrame frMostrar = new JFrame();
    private JFrame frBorrar = new JFrame();
    private JPanel pnlCrear = new JPanel();
    private JPanel pnlMostrar = new JPanel();
    private JPanel pnlModificar = new JPanel();
    private JPanel pnlBorrar = new JPanel();
    private JLabel lblLiga = new JLabel("ELIGE UNA LIGA");
    private JComboBox comboBoxLigaMostrar = new JComboBox();
    private JComboBox comboBoxLigaBorrar = new JComboBox();
    private JLabel lblNombre = new JLabel("Nombre:");
    private JLabel lblPais = new JLabel("Pais:");
    private JTextField txtNombreCrear = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtPaisCrear = new JTextField();
    private JTextField txtPais = new JTextField();
    JButton btnCrearLiga = new JButton("Crear");
    JButton btnModificarLiga = new JButton("Modificar");
    JButton btnMostrarLiga = new JButton("Mostrar");
    JButton btnBorrarLiga = new JButton("Borrar");

    public void crearLiga() {
        
        frCrear.setSize(250, 150);
        frCrear.setResizable(false);
        frCrear.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlCrear.setLayout(new GridLayout(3, 2));
        pnlCrear.add(lblNombre);
        pnlCrear.add(txtNombreCrear);
        pnlCrear.add(lblPais);
        pnlCrear.add(txtPaisCrear);
        pnlCrear.add(btnCrearLiga);
        frCrear.add(pnlCrear);
        frCrear.setVisible(true);

    }
    
    public void mostrarLiga() {
        
        frMostrar.setSize(250, 150);
        frMostrar.setResizable(false);
        frMostrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlMostrar.setLayout(new GridLayout(2, 2));
        pnlMostrar.add(lblLiga);
        pnlMostrar.add(getComboBoxLigaMostrar());
        pnlMostrar.add(btnMostrarLiga);
        frMostrar.add(pnlMostrar);
        frMostrar.setVisible(true);
    }
    
    public void modificarLiga() {

        frModificar.setSize(250, 150);
        frModificar.setResizable(false);
        frModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlModificar.setLayout(new GridLayout(2, 2));
        pnlModificar.add(lblPais);
        pnlModificar.add(txtPais);
        pnlModificar.add(btnModificarLiga);
        frModificar.add(pnlModificar);
        frModificar.setVisible(true);
    }
    
    public void borrarLiga() {
        
        frBorrar.setSize(250, 150);
        frBorrar.setResizable(false);
        frBorrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlBorrar.setLayout(new GridLayout(2, 2));
        pnlBorrar.add(lblLiga);
        pnlBorrar.add(getComboBoxLigaBorrar());
        pnlBorrar.add(btnBorrarLiga);
        frBorrar.add(pnlBorrar);
        frBorrar.setVisible(true);
        
    }
    
    public void addVistaLigaListener(ActionListener listenBoton) {
        btnCrearLiga.addActionListener(listenBoton);
        btnModificarLiga.addActionListener(listenBoton);
        btnMostrarLiga.addActionListener(listenBoton);
        btnBorrarLiga.addActionListener(listenBoton);
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
    public void setTxtNombre(String txtNombre) {
        this.txtNombre.setText(txtNombre);
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
    public void setTxtPais(String txtPais) {
        this.txtPais.setText(txtPais);
    }

    /**
     * @return the txtNombre
     */
    public String getTxtNombreCrear() {
        return txtNombreCrear.getText();
    }
    
    /**
     * @return the txtPais
     */
    public String getTxtPaisCrear() {
        return txtPaisCrear.getText();
    }
    
    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxLigaMostrar(String c) {
        this.getComboBoxLigaMostrar().addItem(c);
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxLigaMostrar() {
        return comboBoxLigaMostrar;
    }
    
    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxLigaBorrar(String c) {
        this.getComboBoxLigaBorrar().addItem(c);
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxLigaBorrar() {
        return comboBoxLigaBorrar;
    }

    /**
     * @param comboBoxLigaMostrar the comboBoxLigaMostrar to set
     */
    public void setComboBoxLigaMostrar(JComboBox comboBoxLigaMostrar) {
        this.comboBoxLigaMostrar = comboBoxLigaMostrar;
    }
    
    /**
     * @param comboBoxLigaMostrar the comboBoxLigaMostrar to set
     */
    public void setComboBoxLigaBorrar(JComboBox comboBoxLigaBorrar) {
        this.comboBoxLigaBorrar = comboBoxLigaBorrar;
    }
    
}
    


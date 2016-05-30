/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Nico
 */
public class VistaAdminJugador {
    
    private JFrame frCrear = new JFrame();
    private JFrame frModificar = new JFrame();
    private JFrame frMostrar = new JFrame();
    private JFrame frBorrar = new JFrame();
    private JPanel pnlCrear = new JPanel();
    private JPanel pnlMostrar = new JPanel();
    private JPanel pnlModificar = new JPanel();
    private JPanel pnlBorrar = new JPanel();
    private JLabel lblJugador = new JLabel("ELIGE UN EQUIPO");
    private JComboBox comboBoxJugadorMostrar = new JComboBox();
    private JComboBox comboBoxJugadorBorrar = new JComboBox();
    private JComboBox comboBoxJugadorVender = new JComboBox();
    private JLabel lblDni = new JLabel("Dni:");
    private JLabel lblNombre = new JLabel("Nombre:");
    private JLabel lblDorsal = new JLabel("Dorsal:");
    private JLabel lblValor = new JLabel("Valor:");
    private JLabel lblEquipo = new JLabel("Equipo:");
    private JTextField txtDniCrear = new JTextField();
    private JTextField txtNombreCrear = new JTextField();
    private JTextField txtDorsalCrear = new JTextField();
    private JTextField txtValorCrear = new JTextField();
    private JTextField txtDni = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtDorsal = new JTextField();
    private JTextField txtValor = new JTextField();
    private JComboBox comboBoxEquipo = new JComboBox();
    JButton btnCrearJugador = new JButton("Crear");
    JButton btnModificarJugador = new JButton("Modificar");
    JButton btnMostrarJugador = new JButton("Mostrar");
    JButton btnBorrarJugador = new JButton("Borrar");
    JButton btnVenderJugador = new JButton("Vender");

    public void crearJugador() {
        
        frCrear.setSize(350, 250);
        frCrear.setResizable(false);
        frCrear.setLocationRelativeTo(null);
        frCrear.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlCrear.setLayout(new GridLayout(6, 2));
        pnlCrear.add(lblDni);
        pnlCrear.add(txtDniCrear);
        pnlCrear.add(lblNombre);
        pnlCrear.add(txtNombreCrear);
        pnlCrear.add(lblDorsal);
        pnlCrear.add(txtDorsalCrear);
        pnlCrear.add(lblValor);
        pnlCrear.add(txtValorCrear);
        pnlCrear.add(lblJugador);
        pnlCrear.add(getComboBoxEquipo());
        pnlCrear.add(btnCrearJugador);
        frCrear.add(pnlCrear);
        frCrear.setVisible(true);

    }
    
    public void mostrarJugador() {
        
        frMostrar.setSize(250, 150);
        frMostrar.setResizable(false);
        frMostrar.setLocationRelativeTo(null);
        frMostrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlMostrar.setLayout(new GridLayout(2, 2));
        pnlMostrar.add(lblJugador);
        pnlMostrar.add(getComboBoxJugadorMostrar());
        pnlMostrar.add(btnMostrarJugador);
        frMostrar.add(pnlMostrar);
        frMostrar.setVisible(true);
    }
    
    public void modificarJugador() {

        frModificar.setSize(350, 250);
        frModificar.setResizable(false);
        frModificar.setLocationRelativeTo(null);
        frModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlModificar.setLayout(new GridLayout(5, 2));
        pnlModificar.add(lblNombre);
        pnlModificar.add(txtNombre);
        pnlModificar.add(lblDorsal);
        pnlModificar.add(txtDorsal);
        pnlModificar.add(lblValor);
        pnlModificar.add(txtValor);
        pnlModificar.add(lblEquipo);
        pnlModificar.add(getComboBoxEquipo());
        pnlModificar.add(btnModificarJugador);
        frModificar.add(pnlModificar);
        frModificar.setVisible(true);
    }
    
    public void borrarJugador() {
        
        frBorrar.setSize(250, 150);
        frBorrar.setResizable(false);
        frBorrar.setLocationRelativeTo(null);
        frBorrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlBorrar.setLayout(new GridLayout(2, 2));
        pnlBorrar.add(lblJugador);
        pnlBorrar.add(getComboBoxJugadorBorrar());
        pnlBorrar.add(btnBorrarJugador);
        frBorrar.add(pnlBorrar);
        frBorrar.setVisible(true);
        
    }
    
    public void venderJugador() {
        
        frBorrar.setSize(250, 150);
        frBorrar.setResizable(false);
        frBorrar.setLocationRelativeTo(null);
        frBorrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlBorrar.setLayout(new GridLayout(2, 2));
        pnlBorrar.add(lblJugador);
        pnlBorrar.add(getComboBoxJugadorVender());
        pnlBorrar.add(btnVenderJugador);
        frBorrar.add(pnlBorrar);
        frBorrar.setVisible(true);
        
    }
    
    public File importarJugador() throws FileNotFoundException, IOException {
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(file);
        File abre = file.getSelectedFile();
        return abre;
    }
    
    public void addVistaJugadorListener(ActionListener listenBoton) {
        btnCrearJugador.addActionListener(listenBoton);
        btnModificarJugador.addActionListener(listenBoton);
        btnMostrarJugador.addActionListener(listenBoton);
        btnBorrarJugador.addActionListener(listenBoton);
        btnVenderJugador.addActionListener(listenBoton);
    }

    /**
     * @return the lblNombre
     */
    public JLabel getLblDni() {
        return lblDni;
    }

    /**
     * @param lblNombre the lblNombre to set
     */
    public void setLblDni(JLabel lblDni) {
        this.lblDni = lblDni;
    }

    /**
     * @return the lblLocalidad
     */
    public JLabel getLblNombre() {
        return lblNombre;
    }

    /**
     * @param lblNombre the lblNombre to set
     */
    public void setLblNombre(JLabel lblNombre) {
        this.lblNombre = lblNombre;
    }

    /**
     * @return the lblPresupuesto
     */
    public JLabel getLblDorsal() {
        return lblDorsal;
    }

    /**
     * @param lblPresupuesto the lblPresupuesto to set
     */
    public void setLblDorsal(JLabel lblDorsal) {
        this.lblDorsal = lblDorsal;
    }

    /**
     * @return the lblGolesFavor
     */
    public JLabel getLblValor() {
        return lblValor;
    }

    /**
     * @param lblGolesFavor the lblGolesFavor to set
     */
    public void setLblValor(JLabel lblValor) {
        this.lblValor = lblValor;
    }

    /**
     * @return the lblLiga
     */
    public JLabel getLblEquipo() {
        return lblEquipo;
    }

    /**
     * @param lblLiga the lblLiga to set
     */
    public void setLblEquipo(JLabel lblEquipo) {
        this.lblEquipo = lblEquipo;
    }

    /**
     * @return the txtNombre
     */
    public String getTxtNombre() {
        return txtNombre.getText();
    }
    
    /**
     * @return the txtNombre
     */
    public String getTxtNombreCrear() {
        return txtNombreCrear.getText();
    }

    /**
     * @param txtNombre the txtNombre to set
     */
    public void setTxtNombre(String txtNombre) {
        this.txtNombre.setText(txtNombre);
    }
    
    /**
     * @param txtNombreCrear the txtNombre to set
     */
    public void setTxtNombreCrear(String txtNombre) {
        this.txtNombreCrear.setText(txtNombre);
    }

    /**
     * @return the txtLocalidad
     */
    public String getTxtDni() {
        return txtDni.getText();
    }
    
    /**
     * @return the txtLocalidad
     */
    public String getTxtDniCrear() {
        return txtDniCrear.getText();
    }

    /**
     * @param txtLocalidad the txtLocalidad to set
     */
    public void setTxtDni(String txtDni) {
        this.txtDni.setText(txtDni);
    }
    
    /**
     * @param txtLocalidadCrear the txtLocalidad to set
     */
    public void setTxtDniCrear(String txtDni) {
        this.txtDniCrear.setText(txtDni);
    }

    /**
     * @return the txtPresupuesto
     */
    public String getTxtDorsal() {
        return txtDorsal.getText();
    }
    
    /**
     * @return the txtPresupuesto
     */
    public String getTxtDorsalCrear() {
        return txtDorsalCrear.getText();
    }

    /**
     * @param txtPresupuesto the txtPresupuesto to set
     */
    public void setTxtDorsal(String txtDorsal) {
        this.txtDorsal.setText(txtDorsal);
    }
    
    /**
     * @param txtPresupuestoCrear the txtPresupuesto to set
     */
    public void setTxtDorsalCrear(String txtDorsal) {
        this.txtDorsalCrear.setText(txtDorsal);
    }

    /**
     * @return the txtGolesFavor
     */
    public String getTxtValor() {
        return txtValor.getText();
    }
    
    /**
     * @return the txtGolesFavor
     */
    public String getTxtValorCrear() {
        return txtValorCrear.getText();
    }

    /**
     * @param txtGolesFavor the txtGolesFavor to set
     */
    public void setTxtValor(String txtValor) {
        this.txtValor.setText(txtValor);
    }
    
    /**
     * @param txtGolesFavorCrear the txtGolesFavor to set
     */
    public void setTxtValorCrear(String txtValor) {
        this.txtValorCrear.setText(txtValor);
    }

    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxJugadorMostrar(String c) {
        this.getComboBoxJugadorMostrar().addItem(c);
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxJugadorMostrar() {
        return comboBoxJugadorMostrar;
    }

    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxJugadorBorrar(String c) {
        this.getComboBoxJugadorBorrar().addItem(c);
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxJugadorBorrar() {
        return comboBoxJugadorBorrar;
    }
    
    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxJugadorVender(String c) {
        this.getComboBoxJugadorVender().addItem(c);
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxJugadorVender() {
        return comboBoxJugadorVender;
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxEquipo() {
        return comboBoxEquipo;
    }

    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxEquipo(String c) {
        this.getComboBoxEquipo().addItem(c);
    }
    
}

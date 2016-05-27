/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

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
public class VistaAdminEquipo {
    
    private JFrame frCrear = new JFrame();
    private JFrame frModificar = new JFrame();
    private JFrame frMostrar = new JFrame();
    private JFrame frBorrar = new JFrame();
    private JPanel pnlCrear = new JPanel();
    private JPanel pnlMostrar = new JPanel();
    private JPanel pnlModificar = new JPanel();
    private JPanel pnlBorrar = new JPanel();
    private JLabel lblEquipo = new JLabel("ELIGE UN EQUIPO");
    private JComboBox comboBoxEquipoMostrar = new JComboBox();
    private JComboBox comboBoxEquipoBorrar = new JComboBox();
    private JLabel lblNombre = new JLabel("Nombre:");
    private JLabel lblLocalidad = new JLabel("Localidad:");
    private JLabel lblPresupuesto = new JLabel("Presupuesto:");
    private JLabel lblGolesFavor = new JLabel("Goles a favor:");
    private JLabel lblGolesContra = new JLabel("Goles en contra:");
    private JLabel lblLiga = new JLabel("Liga:");
    private JTextField txtNombreCrear = new JTextField();
    private JTextField txtLocalidadCrear = new JTextField();
    private JTextField txtPresupuestoCrear = new JTextField();
    private JTextField txtGolesFavorCrear = new JTextField();
    private JTextField txtGolesContraCrear = new JTextField();
    private JTextField txtLigaCrear = new JTextField();
    private JTextField txtNombre = new JTextField();
    private JTextField txtLocalidad = new JTextField();
    private JTextField txtPresupuesto = new JTextField();
    private JTextField txtGolesFavor = new JTextField();
    private JTextField txtGolesContra = new JTextField();
    private JTextField txtLiga = new JTextField();
    JButton btnCrearEquipo = new JButton("Crear");
    JButton btnModificarEquipo = new JButton("Modificar");
    JButton btnMostrarEquipo = new JButton("Mostrar");
    JButton btnBorrarEquipo = new JButton("Borrar");

    public void crearEquipo() {
        
        frCrear.setSize(250, 150);
        frCrear.setResizable(false);
        frCrear.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlCrear.setLayout(new GridLayout(7, 2));
        pnlCrear.add(lblNombre);
        pnlCrear.add(txtNombreCrear);
        pnlCrear.add(lblLocalidad);
        pnlCrear.add(txtLocalidadCrear);
        pnlCrear.add(lblPresupuesto);
        pnlCrear.add(txtPresupuestoCrear);
        pnlCrear.add(lblGolesFavor);
        pnlCrear.add(txtGolesFavorCrear);
        pnlCrear.add(lblGolesContra);
        pnlCrear.add(txtGolesContraCrear);
        pnlCrear.add(lblLiga);
        pnlCrear.add(txtLigaCrear);
        pnlCrear.add(btnCrearEquipo);
        frCrear.add(pnlCrear);
        frCrear.setVisible(true);

    }
    
    public void mostrarEquipo() {
        
        frMostrar.setSize(250, 150);
        frMostrar.setResizable(false);
        frMostrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlMostrar.setLayout(new GridLayout(2, 2));
        pnlMostrar.add(lblLiga);
        pnlMostrar.add(getComboBoxEquipoMostrar());
        pnlMostrar.add(btnMostrarEquipo);
        frMostrar.add(pnlMostrar);
        frMostrar.setVisible(true);
    }
    
    public void modificarEquipo() {

        frModificar.setSize(350, 250);
        frModificar.setResizable(false);
        frModificar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlModificar.setLayout(new GridLayout(6, 2));
        pnlModificar.add(lblLocalidad);
        pnlModificar.add(txtLocalidad);
        pnlModificar.add(lblPresupuesto);
        pnlModificar.add(txtPresupuesto);
        pnlModificar.add(lblGolesFavor);
        pnlModificar.add(txtGolesFavor);
        pnlModificar.add(lblGolesContra);
        pnlModificar.add(txtGolesContra);
        pnlModificar.add(lblLiga);
        pnlModificar.add(txtLiga);
        pnlModificar.add(btnModificarEquipo);
        frModificar.add(pnlModificar);
        frModificar.setVisible(true);
    }
    
    public void borrarEquipo() {
        
        frBorrar.setSize(250, 150);
        frBorrar.setResizable(false);
        frBorrar.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pnlBorrar.setLayout(new GridLayout(2, 2));
        pnlBorrar.add(lblLiga);
        pnlBorrar.add(getComboBoxEquipoBorrar());
        pnlBorrar.add(btnBorrarEquipo);
        frBorrar.add(pnlBorrar);
        frBorrar.setVisible(true);
        
    }
    
    public void addVistaEquipoListener(ActionListener listenBoton) {
        btnCrearEquipo.addActionListener(listenBoton);
        btnModificarEquipo.addActionListener(listenBoton);
        btnMostrarEquipo.addActionListener(listenBoton);
        btnBorrarEquipo.addActionListener(listenBoton);
    }

    /**
     * @return the lblNombre
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
     * @return the lblLocalidad
     */
    public JLabel getLblLocalidad() {
        return lblLocalidad;
    }

    /**
     * @param lblLocalidad the lblLocalidad to set
     */
    public void setLblLocalidad(JLabel lblLocalidad) {
        this.lblLocalidad = lblLocalidad;
    }

    /**
     * @return the lblPresupuesto
     */
    public JLabel getLblPresupuesto() {
        return lblPresupuesto;
    }

    /**
     * @param lblPresupuesto the lblPresupuesto to set
     */
    public void setLblPresupuesto(JLabel lblPresupuesto) {
        this.lblPresupuesto = lblPresupuesto;
    }

    /**
     * @return the lblGolesFavor
     */
    public JLabel getLblGolesFavor() {
        return lblGolesFavor;
    }

    /**
     * @param lblGolesFavor the lblGolesFavor to set
     */
    public void setLblGolesFavor(JLabel lblGolesFavor) {
        this.lblGolesFavor = lblGolesFavor;
    }

    /**
     * @return the lblGolesContra
     */
    public JLabel getLblGolesContra() {
        return lblGolesContra;
    }

    /**
     * @param lblGolesContra the lblGolesContra to set
     */
    public void setLblGolesContra(JLabel lblGolesContra) {
        this.lblGolesContra = lblGolesContra;
    }

    /**
     * @return the lblLiga
     */
    public JLabel getLblLiga() {
        return lblLiga;
    }

    /**
     * @param lblLiga the lblLiga to set
     */
    public void setLblLiga(JLabel lblLiga) {
        this.lblLiga = lblLiga;
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
     * @return the txtLocalidad
     */
    public String getTxtLocalidad() {
        return txtLocalidad.getText();
    }
    
    /**
     * @return the txtLocalidad
     */
    public String getTxtLocalidadCrear() {
        return txtLocalidadCrear.getText();
    }

    /**
     * @param txtLocalidad the txtLocalidad to set
     */
    public void setTxtLocalidad(String txtLocalidad) {
        this.txtLocalidad.setText(txtLocalidad);
    }

    /**
     * @return the txtPresupuesto
     */
    public String getTxtPresupuesto() {
        return txtPresupuesto.getText();
    }
    
    /**
     * @return the txtPresupuesto
     */
    public String getTxtPresupuestoCrear() {
        return txtPresupuestoCrear.getText();
    }

    /**
     * @param txtPresupuesto the txtPresupuesto to set
     */
    public void setTxtPresupuesto(String txtPresupuesto) {
        this.txtPresupuesto.setText(txtPresupuesto);
    }

    /**
     * @return the txtGolesFavor
     */
    public String getTxtGolesFavor() {
        return txtGolesFavor.getText();
    }
    
    /**
     * @return the txtGolesFavor
     */
    public String getTxtGolesFavorCrear() {
        return txtGolesFavorCrear.getText();
    }

    /**
     * @param txtGolesFavor the txtGolesFavor to set
     */
    public void setTxtGolesFavor(String txtGolesFavor) {
        this.txtGolesFavor.setText(txtGolesFavor);
    }

    /**
     * @return the txtGolesContra
     */
    public String getTxtGolesContra() {
        return txtGolesContra.getText();
    }

    /**
     * @return the txtGolesContra
     */
    public String getTxtGolesContraCrear() {
        return txtGolesContraCrear.getText();
    }
    
    /**
     * @param txtGolesContra the txtGolesContra to set
     */
    public void setTxtGolesContra(String txtGolesContra) {
        this.txtGolesContra.setText(txtGolesContra);
    }

    /**
     * @return the txtLiga
     */
    public String getTxtLiga() {
        return txtLiga.getText();
    }
    
    /**
     * @return the txtLiga
     */
    public String getTxtLigaCrear() {
        return txtLigaCrear.getText();
    }

    /**
     * @param txtLiga the txtLiga to set
     */
    public void setTxtLiga(String txtLiga) {
        this.txtLiga.setText(txtLiga);
    }
    
    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxEquipoMostrar(String c) {
        this.getComboBoxEquipoMostrar().addItem(c);
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxEquipoMostrar() {
        return comboBoxEquipoMostrar;
    }

    /**
     * @param comboBoxLiga the comboBoxLiga to set
     */
    public void setComboBoxEquipoBorrar(String c) {
        this.getComboBoxEquipoMostrar().addItem(c);
    }

    /**
     * @return the comboBoxLiga
     */
    public JComboBox getComboBoxEquipoBorrar() {
        return comboBoxEquipoMostrar;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Nico
 */
public class VistaAdminEquipo extends JFrame {

    private JPanel pnl = new JPanel();
    private JLabel lblNombre = new JLabel("Nombre:");
    private JLabel lblLocalidad = new JLabel("Localidad:");
    private JLabel lblPresupuesto = new JLabel("Presupuesto:");
    private JLabel lblGolesFavor = new JLabel("Goles a favor:");
    private JLabel lblGolesContra = new JLabel("Goles en contra:");
    private JLabel lblLiga = new JLabel("Liga:");
    private JTextField txtNombre = new JTextField();
    private JTextField txtLocalidad = new JTextField();
    private JTextField txtPresupuesto = new JTextField();
    private JTextField txtGolesFavor = new JTextField();
    private JTextField txtGolesContra = new JTextField();
    private JTextField txtLiga = new JTextField();

    public VistaAdminEquipo() {
        this.setSize(250, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    public void crearEquipo() {

        pnl.setLayout(new GridLayout(6, 2));
        pnl.add(getLblNombre());
        pnl.add(getTxtNombre());
        pnl.add(getLblLocalidad());
        pnl.add(getTxtLocalidad());
        pnl.add(getLblPresupuesto());
        pnl.add(getTxtPresupuesto());
        pnl.add(getLblGolesFavor());
        pnl.add(getTxtGolesFavor());
        pnl.add(getLblGolesContra());
        pnl.add(getTxtGolesContra());
        pnl.add(getLblLiga());
        pnl.add(getTxtLiga());
        this.add(pnl);
        this.setVisible(true);

    }
    
    public void modificarEquipo() {

        pnl.setLayout(new GridLayout(6, 2));
        pnl.add(getLblNombre());
        pnl.add(getTxtNombre());
        pnl.add(getLblLocalidad());
        pnl.add(getTxtLocalidad());
        pnl.add(getLblPresupuesto());
        pnl.add(getTxtPresupuesto());
        pnl.add(getLblGolesFavor());
        pnl.add(getTxtGolesFavor());
        pnl.add(getLblGolesContra());
        pnl.add(getTxtGolesContra());
        pnl.add(getLblLiga());
        pnl.add(getTxtLiga());
        this.add(pnl);
        this.setVisible(true);

    }
    
    public void borrarEquipo() {

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
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    /**
     * @param txtNombre the txtNombre to set
     */
    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    /**
     * @return the txtLocalidad
     */
    public JTextField getTxtLocalidad() {
        return txtLocalidad;
    }

    /**
     * @param txtLocalidad the txtLocalidad to set
     */
    public void setTxtLocalidad(JTextField txtLocalidad) {
        this.txtLocalidad = txtLocalidad;
    }

    /**
     * @return the txtPresupuesto
     */
    public JTextField getTxtPresupuesto() {
        return txtPresupuesto;
    }

    /**
     * @param txtPresupuesto the txtPresupuesto to set
     */
    public void setTxtPresupuesto(JTextField txtPresupuesto) {
        this.txtPresupuesto = txtPresupuesto;
    }

    /**
     * @return the txtGolesFavor
     */
    public JTextField getTxtGolesFavor() {
        return txtGolesFavor;
    }

    /**
     * @param txtGolesFavor the txtGolesFavor to set
     */
    public void setTxtGolesFavor(JTextField txtGolesFavor) {
        this.txtGolesFavor = txtGolesFavor;
    }

    /**
     * @return the txtGolesContra
     */
    public JTextField getTxtGolesContra() {
        return txtGolesContra;
    }

    /**
     * @param txtGolesContra the txtGolesContra to set
     */
    public void setTxtGolesContra(JTextField txtGolesContra) {
        this.txtGolesContra = txtGolesContra;
    }

    /**
     * @return the txtLiga
     */
    public JTextField getTxtLiga() {
        return txtLiga;
    }

    /**
     * @param txtLiga the txtLiga to set
     */
    public void setTxtLiga(JTextField txtLiga) {
        this.txtLiga = txtLiga;
    }
    
    

}

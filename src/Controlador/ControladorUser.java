/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloConexionBD;
import Vista.VistaAdmin;
import Vista.VistaUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Nico
 */
public class ControladorUser {
    
    private VistaUser vistaUs;
    private ModeloConexionBD modeloBD;

    public ControladorUser(VistaUser vistaUs, ModeloConexionBD modeloBD) throws SQLException, ClassNotFoundException {
        this.modeloBD = modeloBD;
        this.modeloBD.abrirConexion();
        this.vistaUs = vistaUs;
        
        this.vistaUs.addVistaUserListener((ActionListener) new VistaUserListener());
    }
    
    public class VistaUserListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            comportamientoBotones(ae);
        }

    }
    
    public void comportamientoBotones(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case "Crear Equipo":
                System.out.println("ESE PELAO");
                break;
        }
    }
    
}

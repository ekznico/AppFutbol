/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloConexionBD;
import Vista.VistaAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author Nico
 */
public class ControladorAdmin {
    
    private VistaAdmin vistaAd;
    private ModeloConexionBD modeloBD;

    public ControladorAdmin(VistaAdmin vistaAd, ModeloConexionBD modeloBD) throws SQLException, ClassNotFoundException {
        this.modeloBD = modeloBD;
        this.modeloBD.abrirConexion();
        this.vistaAd = vistaAd;
        
        this.vistaAd.addVistaAdminListener((ActionListener) new VistaAdminListener());
    }
    
    public class VistaAdminListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Crear Equipo")) {
                System.out.println("ESEEE PELAAAO");
            }
        }

    }
    
}

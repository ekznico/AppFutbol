/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloConexionBD;
import Tabla.tablaLiga;
import Vista.VistaAdmin;
import Vista.VistaUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {
                comportamientoBotones(ae);
            } catch (IOException ex) {
                Logger.getLogger(ControladorUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void comportamientoBotones(ActionEvent ae) throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {
        switch (ae.getActionCommand()) {
            case "Listar Liga":
                tablaLiga st = new tablaLiga();
                st.pack();
                st.setVisible(true);
                break;
        }
    }
    
}

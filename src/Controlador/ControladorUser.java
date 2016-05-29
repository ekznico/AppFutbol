/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloConexionBD;
import Tabla.tablaEquipo;
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
                tablaLiga tableL = new tablaLiga();
                tableL.pack();
                tableL.setVisible(true);
                break;
            case "Listar Equipo":
                tablaEquipo tableE = new tablaEquipo();
                tableE.pack();
                tableE.setVisible(true);
                break;
            case "Listar Jugador":
                tablaJugador tableJ = new tablaJugador();
                tableJ.pack();
                st.setVisible(true);
                break;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Liga;
import Modelo.ModeloAdminEquipo;
import Modelo.ModeloAdminLiga;
import Modelo.ModeloConexionBD;
import Vista.VistaAdmin;
import Vista.VistaAdminEquipo;
import Vista.VistaAdminLiga;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */
public class ControladorAdmin {

    private VistaAdmin vistaAd;
    private VistaAdminLiga vistaAL;
    private VistaAdminEquipo vistaAE;
    private ModeloConexionBD modeloBD;
    private ModeloAdminLiga modeloAL;
    private ModeloAdminEquipo modeloAE;

    public ControladorAdmin(VistaAdmin vistaAd, VistaAdminLiga vistaAL, VistaAdminEquipo vistaAE, 
            ModeloAdminLiga modeloAL, ModeloAdminEquipo modeloAE, ModeloConexionBD modeloBD) throws SQLException, ClassNotFoundException {
        this.modeloBD = modeloBD;
        this.modeloBD.abrirConexion();
        this.modeloAL = modeloAL;
        this.modeloAE = modeloAE;
        this.vistaAd = vistaAd;
        this.vistaAL = vistaAL;
        this.vistaAE = vistaAE;

        this.vistaAd.addVistaAdminListener((ActionListener) new VistaAdminListener());
    }

    public class VistaAdminListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            try {
                comportamientoBotones(ae);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void comportamientoBotones(ActionEvent ae) throws SQLException, ClassNotFoundException {
        vistaAL.addVistaLigaListener((ActionListener) new VistaLigaListener());
        switch (ae.getActionCommand()) {
            case "Crear Liga":
                vistaAL.crearLiga();
                break;
            case "Modificar Liga":
                vistaAL.modificarLiga();
                break;
            case "Borrar Liga":
                vistaAL.borrarLiga();
                break;
            case "Crear Equipo":
                vistaAE.crearEquipo();
                break;
            case "Modificar Equipo":
                break;
            case "Borrar Equipo":
                break;
            case "Alta Jugador":
                break;
            case "Modificar Jugador":
                break;
            case "Borrar Jugador":
                break;
        }
    }
    
    public class VistaLigaListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Crear")) {
                Liga l = new Liga(vistaAL.getTxtNombre(), vistaAL.getTxtPais());
                try {
                    modeloAL.crearLiga(l);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}

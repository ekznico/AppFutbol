/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Equipo;
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
import javax.swing.JComboBox;

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
        vistaAE.addVistaEquipoListener((ActionListener) new VistaEquipoListener());
        switch (ae.getActionCommand()) {
            case "Crear Liga":
                vistaAL.crearLiga();
                break;
            case "Modificar Liga": 
                vistaAL.getComboBoxLigaMostrar().removeAllItems();
                for (int i = 0; i < modeloAL.listarLigas().size(); i++) {
                    vistaAL.setComboBoxLigaMostrar(modeloAL.listarLigas().get(i));
                }
                vistaAL.mostrarLiga();
                break;
            case "Borrar Liga":
                vistaAL.getComboBoxLigaBorrar().removeAllItems();
                for (int i = 0; i < modeloAL.listarLigas().size(); i++) {
                    vistaAL.setComboBoxLigaBorrar(modeloAL.listarLigas().get(i));
                }
                vistaAL.borrarLiga();
                break;
            case "Crear Equipo":
                vistaAE.crearEquipo();
                break;
            case "Modificar Equipo": 
                vistaAE.getComboBoxEquipoMostrar().removeAllItems();
                for (int i = 0; i < modeloAE.listarEquipos().size(); i++) {
                    vistaAE.setComboBoxEquipoMostrar(modeloAE.listarEquipos().get(i));
                }
                vistaAE.mostrarEquipo();
                break;
            case "Borrar Equipo":
                vistaAE.getComboBoxEquipoBorrar().removeAllItems();
                for (int i = 0; i < modeloAE.listarEquipos().size(); i++) {
                    vistaAE.setComboBoxEquipoBorrar(modeloAE.listarEquipos().get(i));
                }
                vistaAE.borrarEquipo();
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
                Liga l = new Liga(vistaAL.getTxtNombreCrear(), vistaAL.getTxtPaisCrear());
                try {
                    modeloAL.crearLiga(l);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Mostrar")) {
                try {
                    Liga l = modeloAL.mostrarLiga((String) vistaAL.getComboBoxLigaMostrar().getSelectedItem());
                    vistaAL.setTxtNombre(l.getNombre());
                    vistaAL.setTxtPais(l.getPais());
                    vistaAL.modificarLiga();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Borrar")) {
                try {
                    Liga l = modeloAL.mostrarLiga((String) vistaAL.getComboBoxLigaBorrar().getSelectedItem());
                    modeloAL.borrarLiga(l);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Modificar")) {
                try {
                    Liga l = new Liga((String) vistaAL.getComboBoxLigaMostrar().getSelectedItem(), vistaAL.getTxtPais());
                    modeloAL.actualizarLiga(l);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public class VistaEquipoListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Crear")) {
                Equipo e = new Equipo(vistaAE.getTxtNombreCrear(), vistaAE.getTxtLocalidadCrear(), Float.parseFloat(vistaAE.getTxtPresupuestoCrear()), 
                Integer.parseInt(vistaAE.getTxtGolesFavorCrear()), Integer.parseInt(vistaAE.getTxtGolesContraCrear()), 
                vistaAE.getTxtLigaCrear());
                try {
                    modeloAE.crearEquipo(e);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Mostrar")) {
                try {
                    Equipo e = modeloAE.mostrarEquipo((String) vistaAE.getComboBoxEquipoMostrar().getSelectedItem());
                    vistaAE.setTxtNombre(e.getNombre());
                    vistaAE.setTxtLocalidad(e.getLocalidad());
                    vistaAE.setTxtPresupuesto(String.valueOf(e.getPresupuesto()));
                    vistaAE.setTxtGolesFavor(String.valueOf(e.getGolesFavor()));
                    vistaAE.setTxtGolesContra(String.valueOf(e.getGolesContra()));
                    vistaAE.setTxtLiga(e.getLiga());
                    vistaAE.modificarEquipo();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Borrar")) {
                try {
                    Equipo e = modeloAE.mostrarEquipo((String) vistaAE.getComboBoxEquipoBorrar().getSelectedItem());
                    modeloAE.borrarEquipo(e);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Modificar")) {
                try {
                    Equipo e = new Equipo((String) vistaAE.getComboBoxEquipoMostrar().getSelectedItem(), 
                            vistaAE.getTxtLocalidad(), Float.parseFloat(vistaAE.getTxtPresupuesto()), 
                            Integer.parseInt(vistaAE.getTxtGolesFavor()), Integer.parseInt(vistaAE.getTxtGolesContra()), 
                            vistaAE.getTxtLiga());
                    modeloAE.actualizarEquipo(e);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}

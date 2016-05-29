/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Liga;
import Modelo.ModeloAdminEquipo;
import Modelo.ModeloAdminJugador;
import Modelo.ModeloAdminLiga;
import Modelo.ModeloConexionBD;
import Vista.VistaAdmin;
import Vista.VistaAdminEquipo;
import Vista.VistaAdminJugador;
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
    private VistaAdminJugador vistaAJ;
    private ModeloConexionBD modeloBD;
    private ModeloAdminLiga modeloAL;
    private ModeloAdminEquipo modeloAE;
    private ModeloAdminJugador modeloAJ;

    public ControladorAdmin(VistaAdmin vistaAd, VistaAdminLiga vistaAL, VistaAdminEquipo vistaAE, VistaAdminJugador vistaAJ,
            ModeloAdminLiga modeloAL, ModeloAdminEquipo modeloAE, ModeloAdminJugador modeloAJ, ModeloConexionBD modeloBD) throws SQLException, ClassNotFoundException {
        this.modeloBD = modeloBD;
        this.modeloBD.abrirConexion();
        this.modeloAL = modeloAL;
        this.modeloAE = modeloAE;
        this.modeloAJ = modeloAJ;
        this.vistaAd = vistaAd;
        this.vistaAL = vistaAL;
        this.vistaAE = vistaAE;
        this.vistaAJ = vistaAJ;

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
        vistaAJ.addVistaJugadorListener((ActionListener) new VistaJugadorListener());
        switch (ae.getActionCommand()) {
            case "Crear Liga":
                vistaAL.setTxtNombreCrear("");
                vistaAL.setTxtPaisCrear("");
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
            case "Importar Liga":
                System.out.println("IMPORTAR LIGA");
                break;
            case "Exportar Liga":
                System.out.println("EXPORTAR LIGA");
                break;
            case "Crear Equipo":
                vistaAE.setTxtNombreCrear("");
                vistaAE.setTxtLocalidadCrear("");
                vistaAE.setTxtPresupuestoCrear("");
                vistaAE.setTxtGolesFavorCrear("");
                vistaAE.setTxtGolesContraCrear("");
                vistaAE.getComboBoxLiga().removeAllItems();
                for (int i = 0; i < modeloAL.listarLigas().size(); i++) {
                    vistaAE.setComboBoxLiga(modeloAL.listarLigas().get(i));
                }
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
            case "Importar Equipo":
                System.out.println("IMPORTAR EQUIPO");
                break;
            case "Exportar Equipo":
                System.out.println("EXPORTAR EQUIPO");
                break;
            case "Crear Jugador":
                vistaAJ.setTxtDniCrear("");
                vistaAJ.setTxtNombreCrear("");
                vistaAJ.setTxtDorsalCrear("");
                vistaAJ.setTxtValorCrear("");
                vistaAJ.getComboBoxEquipo().removeAllItems();
                for (int i = 0; i < modeloAE.listarEquipos().size(); i++) {
                    vistaAJ.setComboBoxEquipo(modeloAE.listarEquipos().get(i));
                }
                vistaAJ.crearJugador();
                break;
            case "Modificar Jugador":
                vistaAJ.getComboBoxJugadorMostrar().removeAllItems();
                for (int i = 0; i < modeloAJ.listarJugadores().size(); i++) {
                    vistaAJ.setComboBoxJugadorMostrar(modeloAJ.listarJugadores().get(i));
                }
                vistaAJ.mostrarJugador();
                break;
            case "Borrar Jugador":
                vistaAJ.getComboBoxJugadorBorrar().removeAllItems();
                for (int i = 0; i < modeloAJ.listarJugadores().size(); i++) {
                    vistaAJ.setComboBoxJugadorBorrar(modeloAJ.listarJugadores().get(i));
                }
                vistaAJ.borrarJugador();
                break;
            case "Venta Jugador":
                System.out.println("VENTA JUGADOR");
                vistaAJ.getComboBoxJugadorVender().removeAllItems();
                for (int i = 0; i < modeloAJ.listarJugadores().size(); i++) {
                    vistaAJ.setComboBoxJugadorVender(modeloAJ.listarJugadores().get(i));
                }
                vistaAJ.venderJugador();
                break;
            case "Importar Jugador":
                System.out.println("IMPORTAR JUGADOR");
                break;
            case "Exportar Jugador":
                System.out.println("EXPORTAR JUGADOR");
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
            } else if (ae.getActionCommand().equals("Modificar")) {
                try {
                    Liga l = new Liga((String) vistaAL.getComboBoxLigaMostrar().getSelectedItem(), vistaAL.getTxtPais());
                    modeloAL.actualizarLiga(l);
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
            }
        }
    }

    public class VistaEquipoListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Crear")) {
                Equipo e = new Equipo(vistaAE.getTxtNombreCrear(), vistaAE.getTxtLocalidadCrear(), Float.parseFloat(vistaAE.getTxtPresupuestoCrear()),
                        Integer.parseInt(vistaAE.getTxtGolesFavorCrear()), Integer.parseInt(vistaAE.getTxtGolesContraCrear()), (String) vistaAE.getComboBoxLiga().getSelectedItem());
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
                    vistaAE.getComboBoxLiga().removeAllItems();
                    for (int i = 0; i < modeloAL.listarLigas().size(); i++) {
                        vistaAE.setComboBoxLiga(modeloAL.listarLigas().get(i));
                    }
                    vistaAE.getComboBoxLiga().setSelectedItem(e.getLiga());
                    vistaAE.modificarEquipo();
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
                            (String) vistaAE.getComboBoxLiga().getSelectedItem());
                    modeloAE.actualizarEquipo(e);
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
            }
        }

    }

    public class VistaJugadorListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Crear")) {
                Jugador j = new Jugador(vistaAJ.getTxtDniCrear(), vistaAJ.getTxtNombreCrear(),
                        vistaAJ.getTxtDorsalCrear(), Integer.parseInt(vistaAJ.getTxtValorCrear()),
                        (String) vistaAJ.getComboBoxEquipo().getSelectedItem());
                try {
                    modeloAJ.crearJugador(j);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Mostrar")) {
                try {
                    Jugador j = modeloAJ.mostrarJugador((String) vistaAJ.getComboBoxJugadorMostrar().getSelectedItem());
                    vistaAJ.setTxtNombre(j.getNombre());
                    vistaAJ.setTxtDorsal(j.getDorsal());
                    vistaAJ.setTxtValor(String.valueOf(j.getValor()));
                    vistaAJ.getComboBoxEquipo().removeAllItems();
                    for (int i = 0; i < modeloAE.listarEquipos().size(); i++) {
                        vistaAJ.setComboBoxEquipo(modeloAE.listarEquipos().get(i));
                    }
                    vistaAJ.getComboBoxEquipo().setSelectedItem(j.getEquipo());
                    vistaAJ.modificarJugador();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Modificar")) {
                try {
                    Jugador j = new Jugador((String) vistaAJ.getComboBoxJugadorMostrar().getSelectedItem(),
                            vistaAJ.getTxtNombre(), vistaAJ.getTxtDorsal(),
                            Integer.parseInt(vistaAJ.getTxtValor()),
                            (String) vistaAE.getComboBoxLiga().getSelectedItem());
                    modeloAJ.actualizarJugador(j);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Borrar")) {
                try {
                    Jugador j = modeloAJ.mostrarJugador((String) vistaAJ.getComboBoxJugadorBorrar().getSelectedItem());
                    modeloAJ.borrarJugador(j);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (ae.getActionCommand().equals("Vender")) {
                try {
                    Jugador j = modeloAJ.mostrarJugador((String) vistaAJ.getComboBoxJugadorVender().getSelectedItem());
                    modeloAJ.venderJugador(j);
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

}

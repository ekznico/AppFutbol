/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloAdminEquipo;
import Modelo.ModeloAdminJugador;
import Modelo.ModeloAdminLiga;
import Modelo.ModeloConexionBD;
import Modelo.ModeloLogin;
import Modelo.ModeloRegistro;
import Vista.VistaAdmin;
import Vista.VistaAdminEquipo;
import Vista.VistaAdminJugador;
import Vista.VistaAdminLiga;
import Vista.VistaBase;
import Vista.VistaPrincipal;
import Vista.VistaRegistro;
import Vista.VistaUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nico
 */
public class ControladorPrincipal {

    private VistaPrincipal vistaPr;
    private VistaRegistro vistaReg;
    private ModeloConexionBD modeloBD;
    private ModeloLogin modeloLogin;
    private ModeloRegistro modeloReg;

    public ControladorPrincipal(VistaPrincipal vistaPr, VistaRegistro vistaReg,
            ModeloConexionBD modeloBD, ModeloLogin modeloLogin, ModeloRegistro modeloReg) throws SQLException, ClassNotFoundException {
        this.modeloBD = modeloBD;
        this.modeloBD.abrirConexion();
        this.modeloLogin = modeloLogin;
        this.modeloReg = modeloReg;
        this.vistaPr = vistaPr;
        this.vistaPr.addVistaBDListener((ActionListener) new VistaPrincipalListener());
        this.vistaReg = vistaReg;
        this.vistaReg.addVistaRegistroListener((ActionListener) new VistaReglListener());
    }

    public class VistaPrincipalListener implements ActionListener {

        String usuario;
        String password;

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Iniciar sesión")) {
                usuario = vistaPr.getUsuario();
                password = vistaPr.getPassword();
                try {
                    modeloLogin.verificarLogin(usuario, password);
                    if (modeloLogin.getContactoCorrecto()) {
                        vistaPr.setVisible(false);
                        System.out.println("Bienvenido " + usuario);
                        if (modeloLogin.getUsuario().isAdministrador()) {
                            VistaAdmin vistaAd = new VistaAdmin();
                            VistaAdminLiga vistaAL = new VistaAdminLiga();
                            VistaAdminEquipo vistaAE = new VistaAdminEquipo();
                            VistaAdminJugador vistaAJ = new VistaAdminJugador();
                            ModeloAdminLiga modeloAL = new ModeloAdminLiga();
                            ModeloAdminEquipo modeloAE = new ModeloAdminEquipo();
                            ModeloAdminJugador modeloAJ = new ModeloAdminJugador();
                            ControladorAdmin controladorAd = new ControladorAdmin(vistaAd, vistaAL, 
                                    vistaAE, vistaAJ, modeloAL, modeloAE, modeloAJ, modeloBD);
                        } else {
                            VistaUser vistaUs = new VistaUser();
                            ControladorUser controladorUs = new ControladorUser(vistaUs, modeloBD);
                        }
                    } else {
                        vistaPr.mostrarErrores("¡ERROR!, no existe el contacto");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                vistaReg.setVisible(true);
            }
        }

    }

    public class VistaReglListener implements ActionListener {

        String usuario;
        String password;

        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Registrarse")) {
                usuario = vistaReg.getUsuario();
                password = vistaReg.getPassword();
                try {
                    modeloReg.verificarRegistro(usuario, password);
                    System.out.println(modeloReg.getRegistroCorrecto());
                    if (modeloReg.getRegistroCorrecto()) {
                        modeloReg.registrar(usuario, password);
                        vistaReg.setVisible(false);
                    } else {
                        modeloReg.setRegistroCorrecto(true);
                        vistaPr.mostrarErrores("¡ERROR!, ya existe un contacto este nombre");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

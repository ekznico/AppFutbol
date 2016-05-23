/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModeloConexionBD;
import Modelo.ModeloLogin;
import Vista.VistaPrincipal;
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
    private ModeloConexionBD modeloBD;
    private ModeloLogin modeloLogin;
    
    public ControladorPrincipal(VistaPrincipal vistaPr, ModeloConexionBD modeloBD, ModeloLogin modeloLogin) throws SQLException, ClassNotFoundException {
        this.modeloBD = modeloBD;
        this.modeloBD.abrirConexion();
        this.modeloLogin = modeloLogin;
        this.vistaPr = vistaPr;
        this.vistaPr.addVistaBDListener((ActionListener) new VistaPrincipalListener());
    }
    
    public class VistaPrincipalListener implements ActionListener {

        String usuario;
        String password;
        
        public void actionPerformed(ActionEvent ae) {
            usuario = vistaPr.getUsuario();
            System.out.println(usuario);
            password = vistaPr.getPassword();
            System.out.println(password);
            try {
                modeloLogin.verificarLogin(usuario, password);
                if(modeloLogin.getContactoCorrecto()) {
                    vistaPr.setVisible(false);
                    System.out.println("CORRECTO");
                } else {
                    vistaPr.mostrarErrores("¡ERROR!, no existe el contacto");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
}

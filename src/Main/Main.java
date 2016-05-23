/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.ControladorPrincipal;
import Modelo.ModeloConexionBD;
import Modelo.ModeloLogin;
import Vista.VistaPrincipal;
import java.sql.SQLException;

/**
 *
 * @author Nico
 */
public class Main {
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        VistaPrincipal vistaPr = new VistaPrincipal();
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ModeloLogin modeloLogin = new ModeloLogin();
        ControladorPrincipal cp = new ControladorPrincipal(vistaPr, modeloBD, modeloLogin);
        
    }
    
}

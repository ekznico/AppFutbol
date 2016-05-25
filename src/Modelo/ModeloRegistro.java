/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nico
 */
public class ModeloRegistro {
    
    protected boolean registroCorrecto = true;
    private Usuario user;
    
    public void verificarRegistro(String usuario, String password) throws SQLException, ClassNotFoundException {
        System.out.println("REGISTRO");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM users;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
            while (rs.next()) {
                if ((rs.getString(1)).equals(usuario)||!(password.matches("([A-Z]*)([a-z]{2})[._-](\\d{2,})[$]"))) {
                    setRegistroCorrecto(false);
                }
            }
        }
    }
    
    public void registrar(String usuario, String password) throws SQLException, ClassNotFoundException {
        System.out.println("REGISTRO");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "INSERT INTO users VALUES ('" + usuario + "', '" + password + "', false)";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }
    
    public boolean getRegistroCorrecto() {
        return registroCorrecto;
    }

    public Usuario getUsuario() {
        return user;
    }

    public void setRegistroCorrecto(boolean registroCorrecto) {
        this.registroCorrecto = registroCorrecto;
    }
    
}

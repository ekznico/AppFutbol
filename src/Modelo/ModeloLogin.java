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
public class ModeloLogin {

    private boolean usuarioCorrecto = false;
    private Usuario user;
    
    public void verificarLogin(String usuario, String password) throws SQLException, ClassNotFoundException {
        System.out.println("LOGIN");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM users;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
            while (rs.next()) {
                if (((rs.getString(1)).equals(usuario) & ((rs.getString(2)).equals(password)))) {
                    user = new Usuario(rs.getString(1), rs.getString(2), rs.getBoolean(3));
                    usuarioCorrecto = true;
                }
            }
        }
    }
    
    public boolean getContactoCorrecto() {
        return usuarioCorrecto;
    }

    public Usuario getUsuario() {
        return user;
    }

}

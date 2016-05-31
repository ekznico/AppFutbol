/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VistaPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nico
 */
public class ModeloRegistro {
    
    private boolean registroCorrecto = true;
    private Usuario user;
    
    public void verificarRegistro(String usuario, String password) throws SQLException, ClassNotFoundException {
        VistaPrincipal vistaPr = new VistaPrincipal();
        System.out.println("REGISTRO");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM users;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
            while (rs.next()) {
                if ((rs.getString(1)).equals(usuario)) {
                    rs.last();
                    vistaPr.mostrarErrores("¡ERROR!, YA EXISTE UN USUARIO CON ESTE NOMBRE");
                    setRegistroCorrecto(false);
                } else if (!(password.matches("^([A-Z]+)([a-z]{2})([._-]*)([0-9]{2,})[$]$"))) {
                    rs.last();
                    vistaPr.mostrarErrores("¡CONTRASEÑA INCORRECTA!, TIENE QUE CUMPLIR ESTOS REQUISITOS: +"
                            + "\n\t - Empezar por una o varias mayúsculas"
                            + "\n\t - Seguido de dos minúsculas"
                            + "\n\t - 0 ó más carácteres alfanuméricos"
                            + "\n\t - 2 ó más dígitos"
                            + "\n\t - Terminar con el símbolo del dolar");
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

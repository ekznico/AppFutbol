/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author Nico
 */
public class ModeloAdminLiga {

    private Liga l;

    public void crearLiga(Liga l) throws SQLException, ClassNotFoundException {
        System.out.println("LIGA");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(l.getNombre() + " " + l.getPais());
            String sentenciaSQL = "INSERT INTO ligas VALUES ('" + l.getNombre() + "', '" + l.getPais() + "');";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }

    public ArrayList<String> listarLigas() throws SQLException, ClassNotFoundException {
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        ArrayList<String> ligas = new ArrayList<String>();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM ligas;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
            boolean existe = false;
            while (rs.next()) {
                ligas.add(rs.getString(1));
            }
        }
        return ligas;
    }

    public Liga mostrarLiga(String nombre) throws SQLException, ClassNotFoundException {
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado Mostrar");
            String sentenciaSQL = "SELECT * FROM ligas WHERE nombre = '" + nombre + "';";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
        }
        if (rs.next()) {
            l = new Liga(rs.getString(1), rs.getString(2));
        }
        return l;
    }

    public void borrarLiga(Liga l) throws SQLException, ClassNotFoundException {
        System.out.println("LIGA");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(l.getNombre() + " " + l.getPais());
            String sentenciaSQL = "DELETE FROM ligas WHERE nombre = '" + l.getNombre() + "';";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }
    
    public void actualizarLiga(Liga l) throws SQLException, ClassNotFoundException {
        System.out.println("LIGA");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(l.getNombre() + " " + l.getPais());
            String sentenciaSQL = "UPDATE ligas SET  pais = '" + l.getPais() + "'"
                    + "WHERE nombre = '" + l.getNombre() + "';";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public static ArrayList<Liga> cargarLigas() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
        ArrayList<Liga> ligas = new ArrayList<>();
        ResultSet rs = null;
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM ligas;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
        }
        while (rs.next()) {
            Liga liga = new Liga(rs.getString(1), rs.getString(2));
            ligas.add(liga);
        }
        return ligas;
    }
    
    
    public static Object toArrayLiga() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {
        
        ArrayList<Liga> lLigas = cargarLigas();
        String[] columnNames = {"Nombre", "País"};
        Object[][] alumnos = new Object[lLigas.size()][columnNames.length];
        
        for (int i = 0; i < lLigas.size(); i++) {
            alumnos[i][0] = lLigas.get(i).getNombre();
            alumnos[i][1] = lLigas.get(i).getPais();
        }
        return alumnos;
    }
    
}


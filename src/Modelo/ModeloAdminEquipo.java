/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Nico
 */
public class ModeloAdminEquipo {
    
    private Equipo e;
    
    public void crearEquipo(Equipo e) throws SQLException, ClassNotFoundException {
        System.out.println("EQUIPO");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "INSERT INTO equipos VALUES ('" + e.getNombre() + "', '" + e.getLocalidad() +
                    "', '" + e.getPresupuesto() + "', '" + e.getGolesFavor() + "', '" +
                    e.getGolesContra() + "', '" + e.getLiga() + "');";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }

    public ArrayList<String> listarEquipos() throws SQLException, ClassNotFoundException {
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        ArrayList<String> equipos = new ArrayList<String>();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM equipos;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
            boolean existe = false;
            while (rs.next()) {
                equipos.add(rs.getString(1));
            }
        }
        return equipos;
    }

    public Equipo mostrarEquipo(String nombre) throws SQLException, ClassNotFoundException {
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado Mostrar");
            String sentenciaSQL = "SELECT * FROM equipos WHERE nombre = '" + nombre + "';";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
        }
        if (rs.next()) {
            e = new Equipo(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
        }
        return e;
    }

    public void borrarEquipo(Equipo e) throws SQLException, ClassNotFoundException {
        System.out.println("EQUIPO");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(e.getNombre());
            String sentenciaSQL = "DELETE FROM equipos WHERE nombre = '" + e.getNombre() + "';";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }
    
    public void actualizarEquipo(Equipo e) throws SQLException, ClassNotFoundException {
        System.out.println("LIGA");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(e.getNombre());
            String sentenciaSQL = "UPDATE equipos SET  localidad = '" + e.getLocalidad() + "', presupuesto = '" + e.getPresupuesto() + 
                    "', golesFavor = '" + e.getGolesFavor() + "', golesContra = '" + e.getGolesContra() + "', liga = '" + e.getLiga() + "' "
                    + "WHERE nombre = '" + e.getNombre() + "';";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }
    
}

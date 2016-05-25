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
public class ModeloAdminEquipo {
    
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
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.SQLException;

/**
 *
 * @author Nico
 */
public class ModeloAdminLiga {
     
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
    
}

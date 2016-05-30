/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
    
    public static ArrayList<Equipo> cargarEquipos() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
        ArrayList<Equipo> equipos = new ArrayList<>();
        ResultSet rs = null;
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM equipos;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
        }
        while (rs.next()) {
            Equipo equipo = new Equipo(rs.getString(1), rs.getString(2), rs.getFloat(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
            equipos.add(equipo);
        }
        return equipos;
    }
    
    
    public static Object toArrayEquipos() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {
        
        ArrayList<Equipo> lEquipos = cargarEquipos();
        String[] columnNames = {"Nombre", "Localidad", "Presupuesto", "Goles a Favor", "Goles en contra", "Liga"};
        Object[][] equipos = new Object[lEquipos.size()][columnNames.length];
        
        for (int i = 0; i < lEquipos.size(); i++) {
            equipos[i][0] = lEquipos.get(i).getNombre();
            equipos[i][1] = lEquipos.get(i).getLocalidad();
            equipos[i][2] = lEquipos.get(i).getPresupuesto();
            equipos[i][3] = lEquipos.get(i).getGolesFavor();
            equipos[i][4] = lEquipos.get(i).getGolesContra();
            equipos[i][5] = lEquipos.get(i).getLiga();
        }
        return equipos;
    }
    
    public ArrayList<Equipo> importarEquipo(File fichero) throws FileNotFoundException, IOException {
        ArrayList<Equipo> equipos = new ArrayList<>();
        try {
            String cadena = "";

            if (fichero != null) {
                FileReader archivos = new FileReader(fichero);
                BufferedReader lee = new BufferedReader(archivos);
                while ((cadena = lee.readLine()) != null) {
                    String[] inforEquipo = cadena.split(":");
                    Equipo e = new Equipo(inforEquipo[0], inforEquipo[1], Float.parseFloat(inforEquipo[2]), 
                            Integer.parseInt(inforEquipo[3]), Integer.parseInt(inforEquipo[4]), inforEquipo[5]);
                    equipos.add(e);
                }
                lee.close();
            }
        } catch (IOException ex) {

        }
        return equipos;
    }

    public void insertarEquipos(ArrayList<Equipo> equipos) throws SQLException, ClassNotFoundException {
        System.out.println("EQUIPOS");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            for (int i = 0; i < equipos.size(); i++) {
                String sentenciaSQL = "INSERT INTO equipos VALUES  ('" + equipos.get(i).getNombre() + "', '" + 
                        equipos.get(i).getLocalidad() + "', '" + equipos.get(i).getPresupuesto() +
                        "', '" + equipos.get(i).getGolesFavor() +"', '" + equipos.get(i).getGolesContra() +
                        "', '" + equipos.get(i).getLiga() +"');";
                modeloBD.executeQuery(sentenciaSQL);
            }

        }
    }
    
}

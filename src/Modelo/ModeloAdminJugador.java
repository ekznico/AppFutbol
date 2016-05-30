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
public class ModeloAdminJugador {
    
    private Jugador j;
    
    public void crearJugador(Jugador j) throws SQLException, ClassNotFoundException {
        System.out.println("JUGADOR");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "INSERT INTO jugadores VALUES ('" + j.getDni() + "', '" + j.getNombre() +
                    "', '" + j.getDorsal() + "', '" + j.getValor() + "', '" +
                    j.getEquipo() + "');";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }

    public ArrayList<String> listarJugadores() throws SQLException, ClassNotFoundException {
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        ArrayList<String> jugadores = new ArrayList<String>();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            String sentenciaSQL = "SELECT * FROM jugadores;";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
            while (rs.next()) {
                jugadores.add(rs.getString(1));
            }
        }
        return jugadores;
    }

    public Jugador mostrarJugador(String dni) throws SQLException, ClassNotFoundException {
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        ResultSet rs = null;
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado Mostrar");
            String sentenciaSQL = "SELECT * FROM jugadores WHERE dni = '" + dni + "';";
            rs = modeloBD.ejecutaQuery(sentenciaSQL);
        }
        if (rs.next()) {
            j = new Jugador(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
        }
        return j;
    }

    public void borrarJugador(Jugador j) throws SQLException, ClassNotFoundException {
        System.out.println("JUGADOR");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(j.getDni());
            String sentenciaSQL = "DELETE FROM jugadores WHERE dni = '" + j.getDni() + "';";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }
    
    public void venderJugador(Jugador j) throws SQLException, ClassNotFoundException {
        System.out.println("JUGADOR");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(j.getDni());
            String sentenciaSQL = "UPDATE equipos SET  presupuesto = presupuesto + '" + j.getValor() + 
                                    "' WHERE nombre = '" + j.getEquipo() + "';";
            String sentenciaSQL2 = "DELETE FROM jugadores WHERE dni = '" + j.getDni() + "';";
            modeloBD.executeQuery(sentenciaSQL);
            modeloBD.executeQuery(sentenciaSQL2);
        }
    }
    
    public void actualizarJugador(Jugador j) throws SQLException, ClassNotFoundException {
        System.out.println("LIGA");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            System.out.println(j.getNombre());
            String sentenciaSQL = "UPDATE jugadores SET  nombre = '" + j.getNombre() + "', dorsal = '" + j.getDorsal() + 
                    "', valor = '" + j.getValor() + "' WHERE dni = '" + j.getDni() + "';";
            modeloBD.executeQuery(sentenciaSQL);
        }
    }
    
    public ArrayList<Jugador> importarJugador(File fichero) throws FileNotFoundException, IOException {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        try {
            String cadena = "";

            if (fichero != null) {
                FileReader archivos = new FileReader(fichero);
                BufferedReader lee = new BufferedReader(archivos);
                while ((cadena = lee.readLine()) != null) {
                    String[] inforJugador = cadena.split(":");
                    Jugador j = new Jugador(inforJugador[0], inforJugador[1], inforJugador[2], 
                            Integer.parseInt(inforJugador[3]), inforJugador[4]);
                    jugadores.add(j);
                }
                lee.close();
            }
        } catch (IOException ex) {

        }
        return jugadores;
    }

    public void insertarJugadores(ArrayList<Jugador> jugadores) throws SQLException, ClassNotFoundException {
        System.out.println("JUGADORES");
        ModeloConexionBD modeloBD = new ModeloConexionBD();
        if (modeloBD.abrirConexion()) {
            System.out.println("Conectado");
            for (int i = 0; i < jugadores.size(); i++) {
                String sentenciaSQL = "INSERT INTO jugadores VALUES  ('" + jugadores.get(i).getDni() + "', '" + 
                        jugadores.get(i).getNombre() + "', '" + jugadores.get(i).getDorsal() +
                        "', '" + jugadores.get(i).getValor() +"', '" + jugadores.get(i).getEquipo() +
                        "');";
                modeloBD.executeQuery(sentenciaSQL);
            }

        }
    }
    
}

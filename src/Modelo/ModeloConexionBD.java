/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Nico
 */
public class ModeloConexionBD {
    private static String servidor;
    private static String bd;
    private static String usuario;
    private static String contraseña;
    private static ResultSet rs;
    private static Connection conexion;
    
    public ModeloConexionBD() {
        servidor = "jdbc:mysql://localhost/";
        bd = "AppFutbol";
        usuario = "user";
        contraseña = "1234";
        rs = null;
    }
    
    public boolean abrirConexion() throws SQLException, ClassNotFoundException{
        boolean estado = false;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(servidor + bd, usuario, contraseña);
            estado=true;
        }
        catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        catch(SQLException ex){
            System.out.println(ex);
            System.out.println("Error de conexion");
        }
        return estado;
    } 
    
    public ResultSet ejecutaQuery(String sentenciaSQL) {
        ResultSet rs = null;
        
        try {
            Statement st = conexion.createStatement();
            rs = st.executeQuery(sentenciaSQL);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return rs;
    }
    
    public void executeQuery(String sentenciaSQL) {
        try {
            Statement st = conexion.createStatement();
            st.execute(sentenciaSQL);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public String[] devolverStringResultSet(String sentenciaSQL) throws SQLException {
        String cadena = "";
        ResultSet rs = ejecutaQuery(sentenciaSQL);
        ResultSetMetaData metaDatos = rs.getMetaData();
        int numColumnas = metaDatos.getColumnCount();
        String[] columnas = new String[numColumnas];
        for (int i = 0; i < numColumnas; i++) {
            columnas[i] = metaDatos.getColumnLabel(i+1);
        }
        return columnas;
    }
    
}

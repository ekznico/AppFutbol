/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Nico
 */
public class Equipo {
    
    protected String nombre;
    protected String localidad;
    protected float presupuesto;
    protected int golesFavor;
    protected int golesContra;
    protected String liga;

    public Equipo(String nombre, String localidad, float presupuesto, int golesFavor, int golesContra, String liga) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.presupuesto = presupuesto;
        this.golesFavor = golesFavor;
        this.golesContra = golesContra;
        this.liga = liga;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the presupuesto
     */
    public float getPresupuesto() {
        return presupuesto;
    }

    /**
     * @param presupuesto the presupuesto to set
     */
    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    /**
     * @return the golesFavor
     */
    public int getGolesFavor() {
        return golesFavor;
    }

    /**
     * @param golesFavor the golesFavor to set
     */
    public void setGolesFavor(int golesFavor) {
        this.golesFavor = golesFavor;
    }

    /**
     * @return the golesContra
     */
    public int getGolesContra() {
        return golesContra;
    }

    /**
     * @param golesContra the golesContra to set
     */
    public void setGolesContra(int golesContra) {
        this.golesContra = golesContra;
    }

    /**
     * @return the liga
     */
    public String getLiga() {
        return liga;
    }

    /**
     * @param liga the liga to set
     */
    public void setLiga(String liga) {
        this.liga = liga;
    }
    
    
    
}

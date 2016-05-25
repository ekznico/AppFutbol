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
public class Liga {
    
    protected String nombre;
    protected String pais;

    public Liga(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
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
     * @return the liga
     */
    public String getPais() {
        return pais;
    }

    /**
     * @param liga the liga to set
     */
    public void setPais(String pais) {
        this.pais = pais;
    }
    
}

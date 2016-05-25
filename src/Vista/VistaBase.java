/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Nico
 */
public class VistaBase extends JFrame {
    
    JTabbedPane tab = new JTabbedPane();
    JPanel ligas = new JPanel();
    JPanel equipos = new JPanel();
    JPanel jugadores = new JPanel();
    
    public VistaBase() {
        
        this.setSize(250, 250);
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        tab.add("Ligas", ligas);    
        tab.add("Equipos", equipos);
        tab.add("Jugadores", jugadores);
        
        this.add(tab);
        this.setVisible(true);
    }
    
}

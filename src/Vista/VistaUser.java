/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Nico
 */
public class VistaUser extends VistaBase {
    
    private JButton listarLiga;
    private JButton listarEquipo;
    private JButton listarJugador;
    
    public VistaUser() {

        super();
        listarLiga = new JButton("Listar Liga");
        super.ligas.setLayout(new GridLayout(1, 1));
        super.ligas.add(listarLiga);
        
        listarEquipo = new JButton("Listar Equipo");
        super.equipos.setLayout(new GridLayout(1, 1));
        super.equipos.add(listarEquipo);
        
        listarJugador = new JButton("Listar Jugador");
        super.jugadores.setLayout(new GridLayout(1, 1));
        super.jugadores.add(listarJugador);

    }
    
    public void addVistaUserListener(ActionListener listenBoton) {
        listarLiga.addActionListener(listenBoton);
        listarEquipo.addActionListener(listenBoton);
        listarJugador.addActionListener(listenBoton);
    }
    
}

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
public class VistaAdmin extends VistaBase {

    private JButton crearLiga;
    private JButton modificarLiga;
    private JButton borrarLiga;
    private JButton crearEquipo;
    private JButton modificarEquipo;
    private JButton borrarEquipo;
    private JButton altaJugador;
    private JButton modificarJugador;
    private JButton bajaJugador;
    
    public VistaAdmin() {

        super();
        
        crearLiga = new JButton("Crear Liga");
        modificarLiga = new JButton("Modificar Liga");
        borrarLiga = new JButton("Borrar Liga");
        super.ligas.setLayout(new GridLayout(3, 1));
        super.ligas.add(crearLiga);
        super.ligas.add(modificarLiga);
        super.ligas.add(borrarLiga);
        
        crearEquipo = new JButton("Crear Equipo");
        modificarEquipo = new JButton("Modificar Equipo");
        borrarEquipo = new JButton("Borrar Equipo");
        super.equipos.setLayout(new GridLayout(3, 1));
        super.equipos.add(crearEquipo);
        super.equipos.add(modificarEquipo);
        super.equipos.add(borrarEquipo);
        
        altaJugador = new JButton("Alta Jugador");
        modificarJugador = new JButton("Modificar Jugador");
        bajaJugador = new JButton("Baja Jugador");
        super.jugadores.setLayout(new GridLayout(3, 1));
        super.jugadores.add(altaJugador);
        super.jugadores.add(modificarJugador);
        super.jugadores.add(bajaJugador);

    }
    
    public void addVistaAdminListener(ActionListener listenBoton) {
        crearLiga.addActionListener(listenBoton);
        modificarLiga.addActionListener(listenBoton);
        borrarLiga.addActionListener(listenBoton);
        crearEquipo.addActionListener(listenBoton);
        modificarEquipo.addActionListener(listenBoton);
        borrarEquipo.addActionListener(listenBoton);
        altaJugador.addActionListener(listenBoton);
        modificarJugador.addActionListener(listenBoton);
        bajaJugador.addActionListener(listenBoton);
    }

}

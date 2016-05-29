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
    private JButton importarLiga;
    private JButton exportarLiga;
    private JButton crearEquipo;
    private JButton modificarEquipo;
    private JButton borrarEquipo;
    private JButton importarEquipo;
    private JButton exportarEquipo;
    private JButton altaJugador;
    private JButton modificarJugador;
    private JButton bajaJugador;
    private JButton ventaJugador;
    private JButton importarJugador;
    private JButton exportarJugador;
    
    public VistaAdmin() {

        super();
        
        crearLiga = new JButton("Crear Liga");
        modificarLiga = new JButton("Modificar Liga");
        borrarLiga = new JButton("Borrar Liga");
        importarLiga = new JButton("Importar Liga");
        exportarLiga = new JButton("Exportar Liga");
        super.ligas.setLayout(new GridLayout(5, 1));
        super.ligas.add(crearLiga);
        super.ligas.add(modificarLiga);
        super.ligas.add(borrarLiga);
        super.ligas.add(importarLiga);
        super.ligas.add(exportarLiga);
        
        crearEquipo = new JButton("Crear Equipo");
        modificarEquipo = new JButton("Modificar Equipo");
        borrarEquipo = new JButton("Borrar Equipo");
        importarEquipo = new JButton("Importar Equipo");
        exportarEquipo = new JButton("Exportar Equipo");
        super.equipos.setLayout(new GridLayout(5, 1));
        super.equipos.add(crearEquipo);
        super.equipos.add(modificarEquipo);
        super.equipos.add(borrarEquipo);
        super.equipos.add(importarEquipo);
        super.equipos.add(exportarEquipo);
        
        altaJugador = new JButton("Crear Jugador");
        modificarJugador = new JButton("Modificar Jugador");
        bajaJugador = new JButton("Baja Jugador");
        ventaJugador = new JButton("Venta Jugador");
        importarJugador = new JButton("Importar Jugador");
        exportarJugador = new JButton("Exportar Jugador");
        super.jugadores.setLayout(new GridLayout(6, 1));
        super.jugadores.add(altaJugador);
        super.jugadores.add(modificarJugador);
        super.jugadores.add(bajaJugador);
        super.jugadores.add(ventaJugador);
        super.jugadores.add(importarJugador);
        super.jugadores.add(exportarJugador);

    }
    
    public void addVistaAdminListener(ActionListener listenBoton) {
        crearLiga.addActionListener(listenBoton);
        modificarLiga.addActionListener(listenBoton);
        borrarLiga.addActionListener(listenBoton);
        importarLiga.addActionListener(listenBoton);
        exportarLiga.addActionListener(listenBoton);
        crearEquipo.addActionListener(listenBoton);
        modificarEquipo.addActionListener(listenBoton);
        borrarEquipo.addActionListener(listenBoton);
        importarEquipo.addActionListener(listenBoton);
        exportarEquipo.addActionListener(listenBoton);
        altaJugador.addActionListener(listenBoton);
        modificarJugador.addActionListener(listenBoton);
        bajaJugador.addActionListener(listenBoton);
        ventaJugador.addActionListener(listenBoton);
        importarJugador.addActionListener(listenBoton);
        exportarJugador.addActionListener(listenBoton);
    }

}

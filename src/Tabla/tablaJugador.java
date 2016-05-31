/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tabla;

import Modelo.ModeloAdminEquipo;
import Modelo.ModeloAdminJugador;
import Modelo.ModeloConexionBD;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Nico
 */
public class tablaJugador extends JFrame {
    
    public tablaJugador() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {

        MyTableModel myModel = new MyTableModel();
        //TableRowSorter sorter = new TableRowSorter();
        JTable table = new JTable((TableModel) myModel);
        //ajusta el tamaño de la tabla
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        //table.setRowSorter(sorter);
        //creamos un contenedor para la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        //agregamos nuestra tabla al contenedor
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    class MyTableModel extends AbstractTableModel {

        final String[] columnNames;
        final Object[][] data;
        
        MyTableModel() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException {
            ModeloConexionBD modeloBD = new ModeloConexionBD();
            this.columnNames = modeloBD.devolverStringColumna("jugadores");
            this.data = (Object[][]) ModeloAdminJugador.toArrayJugadores(modeloBD.devolverStringColumna("jugadores"));
        }

        //retornamos el numero de elementos del array de datos

        public int getRowCount() {
            return data.length;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
        //public boolean isCellEditable(int row, int col) {
        //   return true;
        //}

    }
    
}

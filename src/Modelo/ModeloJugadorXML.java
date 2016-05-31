/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Nico
 */
public class ModeloJugadorXML {

    private ArrayList<Jugador> jugadores;

    public void crearXML() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
        try {
            jugadores = ModeloAdminJugador.cargarJugadores();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element elementoRaiz = doc.createElement("jugadores");
            doc.appendChild(elementoRaiz);

            for (int i = 0; i < jugadores.size(); i++) {

                Element jugador = doc.createElement("jugador");
                elementoRaiz.appendChild(jugador);

                Attr attr = doc.createAttribute("dni");
                attr.setValue(jugadores.get(i).getDni());
                jugador.setAttributeNode(attr);

                Element nombre = doc.createElement("nombre");
                nombre.appendChild(doc.createTextNode(jugadores.get(i).getNombre()));
                jugador.appendChild(nombre);

                Element dorsal = doc.createElement("dorsal");
                dorsal.appendChild(doc.createTextNode(jugadores.get(i).getDorsal()));
                jugador.appendChild(dorsal);

                Element valor = doc.createElement("valor");
                valor.appendChild(doc.createTextNode(String.valueOf(jugadores.get(i).getValor())));
                jugador.appendChild(valor);

                Element equipo = doc.createElement("equipo");
                equipo.appendChild(doc.createTextNode(jugadores.get(i).getEquipo()));
                jugador.appendChild(equipo);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("jugadores.xml"));

            transformer.transform(source, result);

            System.out.println("Archivo XML guardado");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();

        } catch (TransformerException tfe) {
            tfe.printStackTrace();

        }

    }

}

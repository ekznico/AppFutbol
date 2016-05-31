/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
public class ModeloEquipoXML {

    private ArrayList<Equipo> equipos;

    public void crearXML() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
        try {
            equipos = ModeloAdminEquipo.cargarEquipos();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element elementoRaiz = doc.createElement("equipos");
            doc.appendChild(elementoRaiz);

            for (int i = 0; i < equipos.size(); i++) {

                Element equipo = doc.createElement("equipo");
                elementoRaiz.appendChild(equipo);

                Attr attr = doc.createAttribute("nombre");
                attr.setValue(equipos.get(i).getNombre());
                equipo.setAttributeNode(attr);

                Element nombre = doc.createElement("localidad");
                nombre.appendChild(doc.createTextNode(equipos.get(i).getLocalidad()));
                equipo.appendChild(nombre);

                Element presupuesto = doc.createElement("presupuesto");
                presupuesto.appendChild(doc.createTextNode(String.valueOf(equipos.get(i).getPresupuesto())));
                equipo.appendChild(presupuesto);

                Element golesF = doc.createElement("GolesFavor");
                golesF.appendChild(doc.createTextNode(String.valueOf(equipos.get(i).getGolesFavor())));
                equipo.appendChild(golesF);

                Element golesC = doc.createElement("GolesContra");
                golesC.appendChild(doc.createTextNode(String.valueOf(equipos.get(i).getGolesContra())));
                equipo.appendChild(golesC);

                Element liga = doc.createElement("liga");
                liga.appendChild(doc.createTextNode(equipos.get(i).getLiga()));
                equipo.appendChild(liga);

            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("equipos.xml"));

            transformer.transform(source, result);

            System.out.println("Archivo XML guardado");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();

        } catch (TransformerException tfe) {
            tfe.printStackTrace();

        }

    }

}

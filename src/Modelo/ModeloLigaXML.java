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
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 *
 * @author Nico
 */
public class ModeloLigaXML {

    private ArrayList<Liga> ligas;

    public void crearXML() throws IOException, FileNotFoundException, SQLException, ClassNotFoundException, ParserConfigurationException, TransformerConfigurationException, TransformerException {
        try {
        ligas = ModeloAdminLiga.cargarLigas();

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element elementoRaiz = doc.createElement("ligas");
        doc.appendChild(elementoRaiz);

        for (int i = 0; i < ligas.size(); i++) {

            Element liga = doc.createElement("liga");
            elementoRaiz.appendChild(liga);

            Attr attr = doc.createAttribute("nombre");
            attr.setValue(ligas.get(i).getNombre());
            liga.setAttributeNode(attr);

            Element nombre = doc.createElement("pais");
            nombre.appendChild(doc.createTextNode(ligas.get(i).getPais()));
            liga.appendChild(nombre);

        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);

        StreamResult result = new StreamResult(new File("ligas.xml"));

        transformer.transform(source, result);

        System.out.println("Archivo XML guardado");

    } catch (ParserConfigurationException pce) {
			pce.printStackTrace();

    } catch (TransformerException tfe) {
			tfe.printStackTrace();

    }

}

}

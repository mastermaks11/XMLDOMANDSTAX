package edu.javacourse.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by user on 21.06.2018.
 */
public class SecretaryXML {


    public SecretaryXML() throws IOException, SAXException, ParserConfigurationException {
    }

    public void addPatientXML(Document document, Patient patient) {
        Node root = document.getDocumentElement();
        Element patientTeg = document.createElement("Patient");
        Element firstName = document.createElement("name");
        firstName.setTextContent(patient.getName());
        Element lastName = document.createElement("lastName");
        lastName.setTextContent(patient.getSurname());
        Element date = document.createElement("date");
        date.setTextContent(patient.getBirth().toString());
        Element healds = document.createElement("healds");
        healds.setTextContent(String.valueOf(patient.isHealth()));
        patientTeg.appendChild(firstName);
        patientTeg.appendChild(lastName);
        patientTeg.appendChild(date);
        patientTeg.appendChild(healds);
        root.appendChild(patientTeg);
        writeDocument(document);
    }

    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(document);
            FileOutputStream fos = new FileOutputStream("PatientCatalog.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            System.out.println("Произведена запись в файл");
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }


}



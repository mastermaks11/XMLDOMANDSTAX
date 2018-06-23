package edu.javacourse.xml;

import edu.javacourse.xml.Hospital;
import edu.javacourse.xml.Patient;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 19.06.2018.
 */
public class Secretary {
    private Hospital hospital;
    private String fileName;
    private Set<Patient> patients = new HashSet<>();

    public Secretary(String fileName) {
        hospital = new Hospital();
        this.fileName = fileName;
        patients = hospital.getPatients();
    }

    public void write() throws ParserConfigurationException, SAXException, IOException {
        SecretaryXML secretaryXML = new SecretaryXML();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        org.w3c.dom.Document document = documentBuilder.parse("PatientCatalog.xml");
        for (Patient patient : patients)
            secretaryXML.addPatientXML(document, patient);


    }

}

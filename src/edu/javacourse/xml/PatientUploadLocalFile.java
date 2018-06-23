package edu.javacourse.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;


public class PatientUploadLocalFile {
    private Hospital hospital;
    String nameFile = "PatientCatalog.xml";

    public PatientUploadLocalFile(Hospital hospital) {
        this.hospital = hospital;
    }

    public void uploadLocal() throws IOException, ParseException, ParserConfigurationException, SAXException {
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("PatientCatalog.xml");
            Node root = document.getDocumentElement();
            NodeList books = root.getChildNodes();
            int index = 0;
            String[] st = new String[4];
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                if (book.getNodeType() != Node.TEXT_NODE) {
                    NodeList bookProps = book.getChildNodes();
                    for (int j = 0; j < bookProps.getLength(); j++) {
                        Node bookProp = bookProps.item(j);
                        if (bookProp.getNodeType() != Node.TEXT_NODE) {
                            st[index] = bookProp.getChildNodes().item(0).getTextContent();
                            index++;
                        }
                    }
                }
                if (index == 4) {
                    System.out.println(st[0] + " " + st[1] + " " + st[2] + " " + st[3]);
                    Patient patient = new Patient(st[0], st[1], st[2], st[3]);
                    hospital.addPatient(patient);
                    index = 0;
                }
            }

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }

    }
}


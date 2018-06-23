package edu.javacourse.xml;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import javax.xml.stream.XMLStreamException;


/**
 * Created by user on 19.06.2018.
 */
public class PatientsUpload {
    private URL source;
    private Hospital hospital;

    public PatientsUpload(URL source, Hospital hospital) {
        this.source = source;
        this.hospital = hospital;
    }

    public void upload(Hospital hospital) throws IOException, ParseException {
        URLConnection connection = source.openConnection();
        InputStream inputStream = connection.getInputStream();
        try {
            XMLStreamReader xmlr = XMLInputFactory.newInstance().createXMLStreamReader(inputStream);
            String[] st = new String[4];
            int index = 0;
            while (xmlr.hasNext()) {
                xmlr.next();
                if (xmlr.isStartElement()) {
                } else if (xmlr.isEndElement()) {
                } else if (xmlr.hasText() && xmlr.getText().trim().length() > 0) {
                    st[index] = xmlr.getText();
                    index++;
                }
                if (index == 4) {
                    Patient patient = new Patient(st[0], st[1], st[2], st[3]);
                    hospital.addPatient(patient);
                    index = 0;
                }
            }
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        }


    }
}
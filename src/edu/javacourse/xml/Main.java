package edu.javacourse.xml;

import java.util.logging.LogManager;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;

/**
 * Created by user on 19.06.2018.
 */
public class Main {
    public static void main(String[] args) throws ParseException, IOException, SAXException, ParserConfigurationException {
        RegistrePatient registrePatient = new RegistrePatient();
        try {
            System.setProperty("java.until.logging.config.file", "logger.properties");
            LogManager.getLogManager().readConfiguration();

        } catch (IOException e) {
            System.err.println(e.toString());
        }

        registrePatient.registre();

    }
}

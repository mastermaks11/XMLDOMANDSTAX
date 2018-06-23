package edu.javacourse.xml;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by user on 23.06.2018.
 */
public class RegistrePatient {
    private Scanner scan = new Scanner(System.in);
    private Hospital hospital;
    URL source = new URL("https://raw.githubusercontent.com/mastermaks11/file/master/PatientCatalog.xml");

    public RegistrePatient() throws MalformedURLException {
        this.hospital = new Hospital();
    }

    public void registre() throws ParseException, IOException, ParserConfigurationException, SAXException {
        PatientUploadLocalFile patientUploadLocalFile = new PatientUploadLocalFile(hospital);
        patientUploadLocalFile.uploadLocal();
        System.out.println("Введите кол-во пацентов");
        int count = scan.nextInt();
        while (count != 0) {
            hospital.addPatient(new Patient(scan.next(), scan.next(), new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(scan.next()), scan.nextBoolean()));
            count = count - 1;
        }
        PatientsUpload patientsUpload = new PatientsUpload(source, hospital);
        patientsUpload.upload(hospital);
        Secretary secretary = new Secretary("patient.dat");
        try {
            secretary.write();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


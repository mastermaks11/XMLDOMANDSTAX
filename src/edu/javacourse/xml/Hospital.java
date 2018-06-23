package edu.javacourse.xml;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 19.06.2018.
 */
public class Hospital {
    static private Set<Patient> patients = new HashSet<>();

    public void addPatient(Patient patient) {
        patients.remove(patient);
        patients.add(patient);
    }

    public Set<Patient> getPatients() {
        return patients;
    }


    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "edu.javacourse.xml.Hospital{" + "patients=" + patients + '}';
    }


    public void add(String[] patient) {

    }
}

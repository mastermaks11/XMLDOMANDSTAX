package edu.javacourse.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.lang.String;

/**
 * Created by user on 19.06.2018.
 */
public class Patient {
    private String name;
    private String surname;
    private Date birth;
    private boolean health;

    private Date convertStringTodate(String date) throws ParseException {
        return new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).parse(date);
    }

    public Patient(String name, String surname, Date birth, boolean health) {
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.health = health;
    }

    public Patient(String[] properties) throws ParseException {
        this(properties[0], properties[1], properties[2], properties[3]);
    }

    public Patient(String name, String surname, String birth, String health) throws ParseException {
        this(name, surname, new SimpleDateFormat("YYYY-MM-DD").parse(birth), Boolean.getBoolean(health));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (!name.equals(patient.name)) return false;
        if (!surname.equals(patient.surname)) return false;
        return birth.equals(patient.birth);
    }


    public Patient(String patient) throws ParseException {
        String[] properties = patient.split(";");
        Date patient2 = convertStringTodate(properties[2]);
        boolean patient3 = Boolean.getBoolean(properties[3]);
        new Patient(properties[0], properties[1], patient2, true);
    }


    public String getName() {

        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirth() {
        return birth;
    }

    public boolean isHealth() {
        return health;
    }

    @Override

    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + birth.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "edu.javacourse.xml.Patient{" + "name='" + name + '\'' + ", surname='" + surname + '\'' + ", birth=" + birth + ", health=" + health + '}';
    }
}

package bank;

import java.io.Serializable;

public class Person implements Serializable {
    private int personId;
    private long CNP;
    private String nume;
    private String prenume;
    private String adresa;
    private String email;
    private int telefon;


    public Person(int personId, long CNP, String nume, String prenume, String adresa, String email, int telefon) {
        this.personId = personId;
        this.CNP = CNP;
        this.nume = nume;
        this.prenume = prenume;
        this.adresa = adresa;
        this.email = email;
        this.telefon = telefon;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public long getCNP() {
        return CNP;
    }

    public void setCNP(long CNP) {
        this.CNP = CNP;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefon() {
        return telefon;
    }

    public void setTelefon(int telefon) {
        this.telefon = telefon;
    }

    public void updatePerson(Person person) {
        this.personId = person.getPersonId();
        this.CNP = person.getCNP();
        this.nume = person.getNume();
        this.prenume = person.getPrenume();
        this.adresa = person.getAdresa();
        this.email = person.getEmail();
        this.telefon = person.getTelefon();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getPersonId() != person.getPersonId()) return false;
        return getCNP() == person.getCNP();
    }

    @Override
    public int hashCode() {
        return (int) (getCNP() ^ (getCNP() >>> 32));
    }

    @Override
    public String toString() {
        return "Bank.Person{" +
                "personId=" + personId +
                ", CNP=" + CNP +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", adresa='" + adresa + '\'' +
                ", email='" + email + '\'' +
                ", telefon=" + telefon +
                '}';
    }


}

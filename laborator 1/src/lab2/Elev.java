package lab2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Elev {

    private String nume;
    private Gen gen;
    private Set<String> activitati = new HashSet<>();

    public Elev(String nume, Gen gen) {
        this.nume = nume;
        this.gen = gen;
    }

    public String getNume() {
        return nume;
    }

    public Gen getGen() {
        return gen;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setGen(Gen gen) {
        this.gen = gen;
    }

    public Set<String> getActivitati() {
        return activitati;
    }

    public void adaugaActivitate(String numeActivitate) {
        activitati.add(numeActivitate);
    }

    public void eliminaActivitate(String numeActivitate) {
        activitati.remove(numeActivitate);
    }

    @Override
    public String toString() {
        return "Elev{" +
                "nume='" + nume + '\'' +
                ", gen=" + gen +
                ", activitati=" + activitati +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Elev)) return false;
        Elev elev = (Elev) o;
        return Objects.equals(nume, elev.nume) && gen == elev.gen;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume, gen);
    }
}

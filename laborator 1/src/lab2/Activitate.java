package lab2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Activitate {
    private String nume;
    private Profesor coordonator;
    private Set<Elev> participanti = new HashSet<>();

    public Activitate(String nume, Profesor coordonator) {
        this.nume = nume;
        this.coordonator = coordonator;
    }

    public String getNume() {
        return nume;
    }

    public Profesor getCoordonator() {
        return coordonator;
    }

    public Set<Elev> getParticipanti() {
        return participanti;
    }

    public boolean adaugaElev(Elev e) {
        return participanti.add(e);
    }

    public boolean eliminaElev(Elev e) {
        return participanti.remove(e);
    }

    public int getNumarParticipanti() {
        return participanti.size();
    }

    @Override
    public String toString() {
        return "Activitate{" +
                "nume='" + nume + '\'' +
                ", coordonator=" + coordonator +
                ", participanti=" + participanti.size() +
                '}';
    }

    // important pentru HashSet, comparăm după nume și gen
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activitate)) return false;
        Activitate that = (Activitate) o;
        return Objects.equals(nume, that.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nume);
    }
}

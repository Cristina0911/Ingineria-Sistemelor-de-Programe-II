package lab2;
import java.util.ArrayList;
import java.util.List;

public class Clasa {
    private int capacitate;
    private NumarClasa numar;
    private char litera;
    private List<Elev> elevi;

    public Clasa(int capacitate, NumarClasa numar, char litera) {
        this.capacitate = capacitate;
        this.numar = numar;
        this.litera = litera;
        this.elevi = new ArrayList<>();
    }

    public int getCapacitate() {
        return capacitate;
    }

    public NumarClasa getNumar() {
        return numar;
    }

    public char getLitera() {
        return litera;
    }

    public List<Elev> getElevi() {
        return elevi;
    }

    public void adaugaElev(Elev e) {
        if (elevi.size() < capacitate) {
            elevi.add(e);
        } else {
            System.out.println("Clasa " + numar + litera + " este plina. Nu se poate adauga elevul " + e.getNume());
        }
    }

    public void eliminaElev(Elev e) {
        elevi.remove(e);
    }

    public int getTotalElevi() {
        return elevi.size();
    }

    @Override
    public String toString() {
        return "Clasa{" +
                "capacitate=" + capacitate +
                ", numar=" + numar +
                ", litera=" + litera +
                ", elevi=" + elevi +
                '}';
    }
}

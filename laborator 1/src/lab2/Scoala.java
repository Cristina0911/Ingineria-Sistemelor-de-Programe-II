package lab2;

import java.util.*;
import java.util.stream.Collectors;

public class Scoala {
    private Map<String, Clasa> clase = new HashMap<>();
    private Map<String, Activitate> activitati = new HashMap<>();

    public void adaugaClasa(String id, Clasa c) {
        clase.put(id, c);
    }

    public void eliminaClasa(String id) {
        clase.remove(id);
    }

    public void adaugaElevInClasa(String idClasa, Elev e) {
        Clasa c = clase.get(idClasa);
        if (c != null) {
            c.adaugaElev(e);
        } else {
            System.out.println("Nu exista clasa cu id " + idClasa);
        }
    }

    public void eliminaElevDupaNume(String nume) {
        for (Clasa c : clase.values()) {
            c.getElevi().removeIf(e -> e.getNume().equalsIgnoreCase(nume));
        }

        for (Activitate a : activitati.values()) {
            a.getParticipanti().removeIf(e -> e.getNume().equalsIgnoreCase(nume));
        }
    }

    public int getNumarClase() {
        return clase.size();
    }

    public int getTotalElevi() {
        int total = 0;
        for (Clasa c : clase.values()) {
            total += c.getTotalElevi();
        }
        return total;
    }

    public void afiseazaStructura() {
        System.out.println("Scoala are " + getNumarClase() + " clase.");
        for (String id : clase.keySet()) {
            System.out.println("Clasa " + id + ": " + clase.get(id).getTotalElevi() + " elevi");
        }
        System.out.println("Total elevi in scoala: " + getTotalElevi());
    }

    // --- Activități ---

    public void adaugaActivitate(String nume, Activitate activitate) {
        activitati.put(nume, activitate);
    }

    public void eliminaActivitate(String nume) {
        activitati.remove(nume);
    }

    public void inscrieElevLaActivitate(String numeActivitate, Elev elev) {
        Activitate a = activitati.get(numeActivitate);
        if (a != null) {
            if (a.adaugaElev(elev)) {
                elev.adaugaActivitate(numeActivitate);
            }
        } else {
            System.out.println("Activitatea " + numeActivitate + " nu exista.");
        }
    }

    public void eliminaElevDinActivitate(String numeActivitate, Elev elev) {
        Activitate a = activitati.get(numeActivitate);
        if (a != null) {
            if (a.eliminaElev(elev)) {
                elev.eliminaActivitate(numeActivitate);
            }
        }
    }

    public void afiseazaTopActivitati() {
        System.out.println("Top activitati dupa numarul de participanti:");
        activitati.values().stream()
                .sorted(Comparator.comparingInt(Activitate::getNumarParticipanti).reversed())
                .forEach(a -> System.out.println(a.getNume() + " - " + a.getNumarParticipanti() + " elevi"));
    }

    public void afiseazaNumarEleviCuActivitati() {
        Set<Elev> eleviCuActivitati = new HashSet<>();
        for (Activitate a : activitati.values()) {
            eleviCuActivitati.addAll(a.getParticipanti());
        }
        System.out.println("Numar elevi care participa la cel putin o activitate: " + eleviCuActivitati.size());
    }
}

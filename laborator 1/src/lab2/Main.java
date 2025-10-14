package lab2;

public class Main {
    public static void main(String[] args) {
        Scoala scoala = new Scoala();

        // cream clase
        Clasa c1A = new Clasa(30, NumarClasa.I, 'A');
        Clasa c1B = new Clasa(25, NumarClasa.I, 'B');
        Clasa c2A = new Clasa(28, NumarClasa.II, 'A');

        // adaugam clase in scoala
        scoala.adaugaClasa("1A", c1A);
        scoala.adaugaClasa("1B", c1B);
        scoala.adaugaClasa("2A", c2A);

        // adaugam elevi
        Elev cristina1 = new Elev("Cristina", Gen.Feminin);
        Elev david = new Elev("David", Gen.Masculin);
        Elev stefi = new Elev("Stefi", Gen.Feminin);
        Elev andreea = new Elev("Andreea", Gen.Masculin);
        Elev cristina2 = new Elev("Cristina", Gen.Feminin); // alta Ana

        scoala.adaugaElevInClasa("1A", cristina1);
        scoala.adaugaElevInClasa("1A", david);
        scoala.adaugaElevInClasa("1B", stefi);
        scoala.adaugaElevInClasa("2A", andreea);
        scoala.adaugaElevInClasa("2A", cristina2);

        // afisam structura initiala
        scoala.afiseazaStructura();


        System.out.println("\nStergem elevul 'Cristina' (toate aparitiile):");
        scoala.eliminaElevDupaNume("Cristina");
        scoala.afiseazaStructura();

        // stergem o clasa
        System.out.println("\nStergem clasa 1B:");
        scoala.eliminaClasa("1B");
        scoala.afiseazaStructura();


        // adaugam activitati
        scoala.adaugaActivitate("Fotbal", new Activitate("Fotbal", new Profesor("Popescu")));
        scoala.adaugaActivitate("Cor", new Activitate("Cor", new Profesor("Ionescu")));
        scoala.adaugaActivitate("Pictura", new Activitate("Pictura", new Profesor("Vasilescu")));

        // inscriem elevi la activitati (chiar daca nu sunt in clase)
        Elev Ana = new Elev("Ana", Gen.Feminin);
        Elev Ion = new Elev("Ion", Gen.Masculin);

        scoala.inscrieElevLaActivitate("Fotbal", Ana);
        scoala.inscrieElevLaActivitate("Cor", Ana);
        scoala.inscrieElevLaActivitate("Pictura", Ion);

        // afisam top activitati
        System.out.println("\nTop activitati extracurriculare:");
        scoala.afiseazaTopActivitati();

        // afisam numarul elevilor inscrisi la cel putin o activitate
        scoala.afiseazaNumarEleviCuActivitati();
    }
}

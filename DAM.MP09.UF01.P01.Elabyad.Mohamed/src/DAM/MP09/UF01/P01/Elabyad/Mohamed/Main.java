package DAM.MP09.UF01.P01.Elabyad.Mohamed;

public class Main {
    public static void main(String[] args) {
        // Creació de les instàncies
        CompetEnrere c1 = new CompetEnrere("C1", 7);
        CompetEnrere c2 = new CompetEnrere("C2", 9);
        CompetEnrere c3 = new CompetEnrere("C3", 3);
        CompetEnrere c4 = new CompetEnrere("C4", 12);
        CompetEnrere c5 = new CompetEnrere("C5", 3);
        CompetEnrere c6 = new CompetEnrere("C6", 8);

        // Execució dels fils en l'ordre d'instanciació
        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
    }
}
package Mohamed.Elabyad.planificacio.fils;

public class Cronometre extends Thread {
    private static final Object LOCK = new Object(); // Objecte compartit per sincronització
    private String nom;
    private int duradaTotal;
    private int duradaExclusiva;

    public Cronometre(String nom, int duradaTotal, int duradaExclusiva) {
        this.nom = nom;
        this.duradaTotal = duradaTotal;
        this.duradaExclusiva = duradaExclusiva;
    }

    @Override
    public void run() {
        try {
            
            if (duradaExclusiva > 0) {
                synchronized (LOCK) {
                    System.out.println(nom + " [EXCLUSIU] Inici (" + duradaExclusiva + "s)");
                    Thread.sleep(duradaExclusiva * 1000);
                }
                System.out.println(nom + " [EXCLUSIU] Finalitzat");
                
                int tempsRestant = duradaTotal - duradaExclusiva;
                if (tempsRestant > 0) {
                    Thread.sleep(tempsRestant * 1000);
                }
            } 
            else {
                Thread.sleep(duradaTotal * 1000);
            }
            System.out.println(nom + " HA ACABAT (" + duradaTotal + "s)");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
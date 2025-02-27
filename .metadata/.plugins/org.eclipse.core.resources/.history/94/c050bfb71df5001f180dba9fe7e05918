package DAM.MP09.UF01.P01.Elabyad.Mohamed;

public class CompetEnrere extends Thread {
    private String identificador;
    private int inici;

    // Constructor
    public CompetEnrere(String identificador, int inici) {
        this.identificador = identificador;
        this.inici = inici;
    }

    // Getters i setters
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getInici() {
        return inici;
    }

    public void setInici(int inici) {
        this.inici = inici;
    }

    // Sobreescriptura de toString()
    @Override
    public String toString() {
        return identificador + " - " + inici;
    }

    // Sobreescriptura del mètode run() de Thread
    @Override
    public void run() {
        iniciarCompteEnrere();
    }

    // Mètode privat per al compte enrere
    private void iniciarCompteEnrere() {
        int comptador = inici;
        while (comptador > 0) {
            System.out.println(this + " | Segon actual: " + comptador);
            comptador--;
            try {
                Thread.sleep(1000); // Aturada d'1 segon
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
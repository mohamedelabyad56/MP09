package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain;

public class VisitaMedicaLog {
    private String algoritme;
    private String accio;
    private VisitaMedica visita;

    public VisitaMedicaLog(String algoritme, String accio, VisitaMedica visita) {
        this.algoritme = algoritme;
        this.accio = accio;
        this.visita = visita;
    }

    public String getAlgoritme() {
        return algoritme;
    }

    public String getAccio() {
        return accio;
    }

    public VisitaMedica getVisita() {
        return visita;
    }

    @Override
    public String toString() {
        return "Algoritme: " + algoritme +
               ", Acció: " + accio +
               ", Visita: " + visita.toString();
    }
}

package model.domain;

public class UsuariLog {
    private String algoritme;
    private String accio;
    private Usuari usuari;

    public UsuariLog(String algoritme, String accio, Usuari usuari) {
        this.algoritme = algoritme;
        this.accio = accio;
        this.usuari = usuari;
    }

    public String getAlgoritme() {
        return algoritme;
    }

    public void setAlgoritme(String algoritme) {
        this.algoritme = algoritme;
    }

    public String getAccio() {
        return accio;
    }

    public void setAccio(String accio) {
        this.accio = accio;
    }

    public Usuari getUsuari() {
        return usuari;
    }

    public void setUsuari(Usuari usuari) {
        this.usuari = usuari;
    }

    @Override
    public String toString() {
        return "UsuariLog{" +
                "algoritme='" + algoritme + '\'' +
                ", accio='" + accio + '\'' +
                ", usuari=" + usuari +
                '}';
    }
}

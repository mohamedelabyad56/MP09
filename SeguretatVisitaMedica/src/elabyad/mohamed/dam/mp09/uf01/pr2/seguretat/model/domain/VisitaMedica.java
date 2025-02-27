package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain;

import java.time.LocalDate;

public class VisitaMedica {
    private int idVisita;
    private String nomPacient;
    private String nomMetge;
    private LocalDate data;
    private String diagnostic;

    public VisitaMedica(int idVisita, String nomPacient, String nomMetge, LocalDate data, String diagnostic) {
        this.idVisita = idVisita;
        this.nomPacient = nomPacient;
        this.nomMetge = nomMetge;
        this.data = data;
        this.diagnostic = diagnostic;
    }

    public int getIdVisita() {
        return idVisita;
    }

    public String getNomPacient() {
        return nomPacient;
    }

    public String getNomMetge() {
        return nomMetge;
    }

    public LocalDate getData() {
        return data;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    @Override
    public String toString() {
        return "ID: " + idVisita +
               ", Pacient: " + nomPacient +
               ", Metge: " + nomMetge +
               ", Data: " + data +
               ", Diagnòstic: " + diagnostic;
    }
}

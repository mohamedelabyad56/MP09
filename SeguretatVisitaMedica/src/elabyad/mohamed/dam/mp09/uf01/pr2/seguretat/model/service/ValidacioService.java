package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.service;


import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;

public class ValidacioService {

    public void validaVisitaMedica(VisitaMedica visita) throws Exception {
        if (visita.getNomPacient() == null || visita.getNomPacient().isEmpty()) {
            throw new Exception("El nom del pacient és obligatori.");
        }
        if (visita.getNomMetge() == null || visita.getNomMetge().isEmpty()) {
            throw new Exception("El nom del metge és obligatori.");
        }
        if (visita.getData() == null) {
            throw new Exception("La data és obligatòria.");
        }
        if (visita.getDiagnostic() == null || visita.getDiagnostic().isEmpty()) {
            throw new Exception("El diagnòstic és obligatori.");
        }
    }
}

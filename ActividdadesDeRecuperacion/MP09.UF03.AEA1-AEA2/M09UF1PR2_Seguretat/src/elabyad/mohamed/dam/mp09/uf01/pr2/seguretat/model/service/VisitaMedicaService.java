
package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.service;

import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;

public class VisitaMedicaService {
    private final HashService hashService;
    private final AesService aesService;

    public VisitaMedicaService() {
        this.hashService = new HashService();
        this.aesService = new AesService();
    }

    public boolean validateVisitaMedica(VisitaMedica visita) {
        return visita.getIdVisita() > 0 &&
               visita.getNomPacient() != null && !visita.getNomPacient().isEmpty() &&
               visita.getNomMetge() != null && !visita.getNomMetge().isEmpty() &&
               visita.getData() != null &&
               visita.getDiagnostic() != null && !visita.getDiagnostic().isEmpty();
    }

    public VisitaMedicaLog encryptNomPacientMD5(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String encryptedNom = hashService.encryptMD5(visita.getNomPacient());
        VisitaMedica encryptedVisita = new VisitaMedica(
                visita.getIdVisita(), encryptedNom, visita.getNomMetge(),
                visita.getData(), visita.getDiagnostic());
        return new VisitaMedicaLog(encryptedVisita, "MD5 Encryption (nomPacient)");
    }

    public VisitaMedicaLog encryptNomPacientSHA256(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String encryptedNom = hashService.encryptSHA256(visita.getNomPacient());
        VisitaMedica encryptedVisita = new VisitaMedica(
                visita.getIdVisita(), encryptedNom, visita.getNomMetge(),
                visita.getData(), visita.getDiagnostic());
        return new VisitaMedicaLog(encryptedVisita, "SHA256 Encryption (nomPacient)");
    }

    public VisitaMedicaLog encryptNomPacientAES(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String encryptedNom = aesService.encryptAES(visita.getNomPacient());
        VisitaMedica encryptedVisita = new VisitaMedica(
                visita.getIdVisita(), encryptedNom, visita.getNomMetge(),
                visita.getData(), visita.getDiagnostic());
        return new VisitaMedicaLog(encryptedVisita, "AES Encryption (nomPacient)");
    }

    public VisitaMedicaLog decryptNomPacientAES(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String decryptedNom = aesService.decryptAES(visita.getNomPacient());
        VisitaMedica decryptedVisita = new VisitaMedica(
                visita.getIdVisita(), decryptedNom, visita.getNomMetge(),
                visita.getData(), visita.getDiagnostic());
        return new VisitaMedicaLog(decryptedVisita, "AES Decryption (nomPacient)");
    }

    public VisitaMedicaLog encryptDiagnosticMD5(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String encryptedDiag = hashService.encryptMD5(visita.getDiagnostic());
        VisitaMedica encryptedVisita = new VisitaMedica(
                visita.getIdVisita(), visita.getNomPacient(), visita.getNomMetge(),
                visita.getData(), encryptedDiag);
        return new VisitaMedicaLog(encryptedVisita, "MD5 Encryption (diagnostic)");
    }

    public VisitaMedicaLog encryptDiagnosticSHA256(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String encryptedDiag = hashService.encryptSHA256(visita.getDiagnostic());
        VisitaMedica encryptedVisita = new VisitaMedica(
                visita.getIdVisita(), visita.getNomPacient(), visita.getNomMetge(),
                visita.getData(), encryptedDiag);
        return new VisitaMedicaLog(encryptedVisita, "SHA256 Encryption (diagnostic)");
    }

    public VisitaMedicaLog encryptDiagnosticAES(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String encryptedDiag = aesService.encryptAES(visita.getDiagnostic());
        VisitaMedica encryptedVisita = new VisitaMedica(
                visita.getIdVisita(), visita.getNomPacient(), visita.getNomMetge(),
                visita.getData(), encryptedDiag);
        return new VisitaMedicaLog(encryptedVisita, "AES Encryption (diagnostic)");
    }

    public VisitaMedicaLog decryptDiagnosticAES(VisitaMedica visita) throws Exception {
        if (!validateVisitaMedica(visita)) {
            throw new IllegalArgumentException("VisitaMedica data is invalid");
        }
        String decryptedDiag = aesService.decryptAES(visita.getDiagnostic());
        VisitaMedica decryptedVisita = new VisitaMedica(
                visita.getIdVisita(), visita.getNomPacient(), visita.getNomMetge(),
                visita.getData(), decryptedDiag);
        return new VisitaMedicaLog(decryptedVisita, "AES Decryption (diagnostic)");
    }
}


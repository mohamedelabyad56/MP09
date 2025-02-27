package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.service;

import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.repository.VisitaMedicaLogRepository;

public class VisitaMedicaService {
    private AESSecurityService aesService = new AESSecurityService();
    private MD5SecurityService md5Service = new MD5SecurityService();
    private SHA256SecurityService sha256Service = new SHA256SecurityService();
    private VisitaMedicaLogRepository logRepository = new VisitaMedicaLogRepository();

    public String encriptaMD5(String valor) throws Exception {
        return md5Service.encripta(valor);
    }

    public String encriptaSHA256(String valor) throws Exception {
        return sha256Service.encripta(valor);
    }

    public String encriptaAES(String valor) throws Exception {
        return aesService.encripta(valor);
    }

    public String desencriptaAES(String valor) throws Exception {
        return aesService.desencripta(valor);
    }

    public void validaVisitaMedica(VisitaMedica visita) throws Exception {
        if (visita.getNomPacient() == null || visita.getNomPacient().isEmpty()) {
            throw new Exception("El nombre del paciente es obligatorio.");
        }
        if (visita.getDiagnostic() == null || visita.getDiagnostic().isEmpty()) {
            throw new Exception("El diagnòstico es obligatorio.");
        }
    }

    public VisitaMedicaLogRepository getLogs() {
        return logRepository;
    }
}

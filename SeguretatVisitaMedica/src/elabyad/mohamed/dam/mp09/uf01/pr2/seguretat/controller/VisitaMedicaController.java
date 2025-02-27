package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.controller;

import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.service.*;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.view.console.VisitaMedicaView;

public class VisitaMedicaController {
    private VisitaMedicaView view = new VisitaMedicaView();
    private VisitaMedicaService service = new VisitaMedicaService();

    public void inici() {
        boolean continuar = true;

        while (continuar) {
            try {
                VisitaMedica visita = view.getVisitaMedica();

                service.validaVisitaMedica(visita);

                aplicaEncriptacioMD5(visita);
                aplicaEncriptacioSHA256(visita);
                aplicaEncriptacioAES(visita);

                view.mostraLogs(service.getLogs().getLogs());

            } catch (Exception e) {
                // Mostrar mensaje de error en la vista
                view.mostraMissatge("Error: " + e.getMessage(), true);
            }

            // Preguntar al usuario si desea continuar
            continuar = view.demanarMesDades();
        }

        view.mostraMissatge("Finalizando el proceso", false);
    }

    private void aplicaEncriptacioMD5(VisitaMedica visita) {
        try {
            String nomPacientEncriptat = service.encriptaMD5(visita.getNomPacient());
            String diagnosticEncriptat = service.encriptaMD5(visita.getDiagnostic());

            view.mostraMissatge("Nombre de el paciente encriptadocon MD5: " + nomPacientEncriptat, false);
            view.mostraMissatge("Diagnostico encriptado con MD5: " + diagnosticEncriptat, false);
        } catch (Exception e) {
            view.mostraMissatge("Error en la encriptacion MD5: " + e.getMessage(), true);
        }
    }

    private void aplicaEncriptacioSHA256(VisitaMedica visita) {
        try {
            String nomPacientEncriptat = service.encriptaSHA256(visita.getNomPacient());
            String diagnosticEncriptat = service.encriptaSHA256(visita.getDiagnostic());

            view.mostraMissatge("nombre del paciente encriptado con SHA-256: " + nomPacientEncriptat, false);
            view.mostraMissatge("Diagnostico encriptado con SHA-256: " + diagnosticEncriptat, false);
        } catch (Exception e) {
            view.mostraMissatge("Error en la encriptacion SHA-256: " + e.getMessage(), true);
        }
    }

    private void aplicaEncriptacioAES(VisitaMedica visita) {
        try {
            String nomPacientEncriptat = service.encriptaAES(visita.getNomPacient());
            String diagnosticEncriptat = service.encriptaAES(visita.getDiagnostic());

            view.mostraMissatge("Nombre del paciente encriptado con AES: " + nomPacientEncriptat, false);
            view.mostraMissatge("Diagnostic encriptat amb AES: " + diagnosticEncriptat, false);

            String nomPacientDesencriptat = service.desencriptaAES(nomPacientEncriptat);
            String diagnosticDesencriptat = service.desencriptaAES(diagnosticEncriptat);

            view.mostraMissatge("Nombre del paciente desencriptado con AES: " + nomPacientDesencriptat, false);
            view.mostraMissatge("Diagnostic desencriptat amb AES: " + diagnosticDesencriptat, false);

        } catch (Exception e) {
            view.mostraMissatge("Error en la encriptacion/desencriptación AES: " + e.getMessage(), true);
        }
    }
}

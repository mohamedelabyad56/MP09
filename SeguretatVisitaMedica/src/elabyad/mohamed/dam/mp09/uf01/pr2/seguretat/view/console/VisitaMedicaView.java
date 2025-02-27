package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.view.console;

import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class VisitaMedicaView {
    private Scanner scanner = new Scanner(System.in);

    public VisitaMedica getVisitaMedica() {
        System.out.println("Introduce el idintificador de la visita (int): ");
        int idVisita = Integer.parseInt(scanner.nextLine());

        System.out.println("Introduce el nombre de paciente: ");
        String nomPacient = scanner.nextLine();

        System.out.println("Introduce el nombre del medico: ");
        String nomMetge = scanner.nextLine();

        System.out.println("Introduce la fecha de la visita (YYYY-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.nextLine());

        System.out.println("Introduce el diagnostico ");
        String diagnostic = scanner.nextLine();

        return new VisitaMedica(idVisita, nomPacient, nomMetge, data, diagnostic);
    }

    public void mostraLogs(List<?> logs) {
        System.out.println("Logs de operaciones:");
        for (Object log : logs) {
            System.out.println(log);
        }
    }

    public void mostraMissatge(String missatge, boolean esError) {
        if (esError) {
            System.err.println(missatge);
        } else {
            System.out.println(missatge);
        }
    }

    public boolean demanarMesDades() {
        System.out.println("desea contenuar (true/false): ");
        return Boolean.parseBoolean(scanner.nextLine());
    }
}


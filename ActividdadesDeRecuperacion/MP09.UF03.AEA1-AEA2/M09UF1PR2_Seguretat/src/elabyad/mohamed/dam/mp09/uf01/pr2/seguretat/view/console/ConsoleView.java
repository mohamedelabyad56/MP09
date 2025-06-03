
package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.view.console;

import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedica;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.service.VisitaMedicaService;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.repository.VisitaMedicaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private final VisitaMedicaService service;
    private final VisitaMedicaRepository repository;
    private final Scanner scanner;

    public ConsoleView(VisitaMedicaService service, VisitaMedicaRepository repository) {
        this.service = service;
        this.repository = repository;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n--- Medical Visit Encryption System ---");
            System.out.println("1. Create and encrypt visit");
            System.out.println("2. View logs");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (option == 3) {
                System.out.println("Exiting...");
                break;
            }

            switch (option) {
                case 1:
                    createAndEncryptVisit();
                    break;
                case 2:
                    viewLogs();
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void createAndEncryptVisit() {
        try {
            System.out.print("Enter visit ID: ");
            int idVisita = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter patient name: ");
            String nomPacient = scanner.nextLine();
            System.out.print("Enter doctor name: ");
            String nomMetge = scanner.nextLine();
            System.out.print("Enter date (YYYY-MM-DD): ");
            String dateStr = scanner.nextLine();
            LocalDate data = LocalDate.parse(dateStr);
            System.out.print("Enter diagnosis: ");
            String diagnostic = scanner.nextLine();

            VisitaMedica visita = new VisitaMedica(idVisita, nomPacient, nomMetge, data, diagnostic);

            System.out.println("\nChoose encryption for patient name:");
            System.out.println("1. MD5");
            System.out.println("2. SHA256");
            System.out.println("3. AES");
            int encryptOption = scanner.nextInt();
            scanner.nextLine();

            VisitaMedicaLog log = null;
            switch (encryptOption) {
                case 1:
                    log = service.encryptNomPacientMD5(visita);
                    break;
                case 2:
                    log = service.encryptNomPacientSHA256(visita);
                    break;
                case 3:
                    log = service.encryptNomPacientAES(visita);
                    System.out.println("Decrypt patient name? (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        log = service.decryptNomPacientAES(log.getVisitaMedica());
                    }
                    break;
                default:
                    System.out.println("Invalid encryption option");
                    return;
            }

            repository.addLog(log);
            System.out.println("Operation logged: " + log);

            System.out.println("\nChoose encryption for diagnosis:");
            System.out.println("1. MD5");
            System.out.println("2. SHA256");
            System.out.println("3. AES");
            encryptOption = scanner.nextInt();
            scanner.nextLine();

            switch (encryptOption) {
                case 1:
                    log = service.encryptDiagnosticMD5(visita);
                    break;
                case 2:
                    log = service.encryptDiagnosticSHA256(visita);
                    break;
                case 3:
                    log = service.encryptDiagnosticAES(visita);
                    System.out.println("Decrypt diagnosis? (y/n): ");
                    if (scanner.nextLine().equalsIgnoreCase("y")) {
                        log = service.decryptDiagnosticAES(log.getVisitaMedica());
                    }
                    break;
                default:
                    System.out.println("Invalid encryption option");
                    return;
            }

            repository.addLog(log);
            System.out.println("Operation logged: " + log);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void viewLogs() {
        List<VisitaMedicaLog> logs = repository.getAllLogs();
        if (logs.isEmpty()) {
            System.out.println("No logs available.");
        } else {
            System.out.println("\nLogs:");
            for (VisitaMedicaLog log : logs) {
                System.out.println(log);
            }
        }
    }
}

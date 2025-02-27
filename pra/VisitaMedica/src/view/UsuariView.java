package view;

import model.domain.Usuari;
import java.util.Scanner;
import java.util.ArrayList;

public class UsuariView {

    private Scanner scanner = new Scanner(System.in);

    public Usuari getUsuari() {
        System.out.print("Introduce el email: ");
        String mail = scanner.nextLine();
        System.out.print("Introduce la contraseña: ");
        String password = scanner.nextLine();
        return new Usuari(mail, password);
    }

    public void showUsuari(Usuari usuari) {
        System.out.println("Usuari: " + usuari);
    }

    public void showMissatge(String missatge, boolean esError) {
        if (esError) {
            System.err.println(missatge);
        } else {
            System.out.println(missatge);
        }
    }

    public void mostraLogs(ArrayList<model.domain.UsuariLog> logs) {
        for (var log : logs) {
            System.out.println(log);
        }
    }

    public boolean demanarMesDades() {
        System.out.print("Quieres seguir? (true/false): ");
        return scanner.nextBoolean();
    }
}

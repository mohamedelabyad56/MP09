package mp09.uf01.seguretat.exemple.usuaris.view.console;

import java.util.ArrayList;
import java.util.Scanner;

import mp09.uf01.seguretat.exemple.usuaris.model.domain.Usuari;
import mp09.uf01.seguretat.exemple.usuaris.model.domain.UsuariLog;

public class UsuariView {

	public Usuari getUsuari() {
		Usuari usuari = new Usuari();
		Scanner scanner = new Scanner(System.in);
		showMissatge("Introdueixi el mail: ", false);
		usuari.setMail(scanner.next());
		showMissatge("Introdueixi el password: ", false);
		usuari.setPassword(scanner.next());

		return usuari;
	}

	public void showUsuari(Usuari usuari) {
		System.out.println(usuari.toString());
	}

	public void showMissatge(String missatge, boolean esError) {
		if (esError) {
			System.err.println(missatge);
		} else {
			System.out.println(missatge);
		}
	}

	public boolean demanarMesDades() {
		boolean result = false;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Desitja demanar més dades?true/false");
		result = scanner.nextBoolean();
		return result;
	}

	public void mostraLogs(ArrayList<UsuariLog> logs) {
		System.out.println(" ==== Llistat d'usuaris (LOG)");
		if (logs != null && logs.size() > 0) {
			for (UsuariLog u : logs) {
				System.out.println(u.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}

}

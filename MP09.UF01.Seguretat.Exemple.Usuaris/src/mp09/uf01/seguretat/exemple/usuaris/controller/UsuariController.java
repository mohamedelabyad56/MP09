package mp09.uf01.seguretat.exemple.usuaris.controller;

import mp09.uf01.seguretat.exemple.usuaris.model.domain.Usuari;
import mp09.uf01.seguretat.exemple.usuaris.model.service.UsuariService;
import mp09.uf01.seguretat.exemple.usuaris.view.console.UsuariView;

public class UsuariController {

	UsuariView usuariView = new UsuariView();
	UsuariService usuariService = new UsuariService();

	public void inici() {
		do {
			aplicaSeguretatMD5();
			aplicaSeguretatSHA256();
			aplicaSeguretatAES();
			usuariView.mostraLogs(usuariService.getLogs());
			
		} while (usuariView.demanarMesDades());
	}

	private void aplicaSeguretatMD5() {

		try {
			usuariView.showMissatge("MD5 ------------", false);
			Usuari usuari = usuariView.getUsuari();
			Usuari usuariEnc = usuariService.getUsuariEncriptatMD5(usuari);
			usuariView.showUsuari(usuariEnc);
		} catch (Exception ex) {
			usuariView.showMissatge("MD5 - " + ex.getMessage(), true);
		}

	}

	private void aplicaSeguretatSHA256() {
		try {
			usuariView.showMissatge("SHA256 ------------", false);
			Usuari usuari = usuariView.getUsuari();
			Usuari usuariEnc = usuariService.getUsuariEncriptatSHA256(usuari);
			usuariView.showUsuari(usuariEnc);
		} catch (Exception ex) {
			usuariView.showMissatge("SHA256 - " + ex.getMessage(), true);
		}
	}

	private void aplicaSeguretatAES() {
		try {
			usuariView.showMissatge("AES ------------ Encripta", false);
			Usuari usuari = usuariView.getUsuari();
			Usuari usuariEnc = usuariService.getUsuariEncriptatAES(usuari);
			usuariView.showUsuari(usuariEnc);

			usuariView.showMissatge("AES ------------ Desencripta", false);
			Usuari usuariDesenc = usuariService.getUsuariDesencriptatAES(usuariEnc);
			usuariView.showUsuari(usuariDesenc);
		} catch (Exception ex) {
			usuariView.showMissatge("AES - " + ex.getMessage(), true);
		}

	}
	

}

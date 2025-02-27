package controller;

import model.domain.Usuari;
import model.service.UsuariService;
import view.UsuariView;

public class UsuariController {
    private UsuariView usuariView;
    private UsuariService usuariService;

    public UsuariController() {
        this.usuariView = new UsuariView();
        this.usuariService = new UsuariService();
    }

    public void inici() {
        boolean continuar = true;

        while (continuar) {
            try {
                Usuari usuari = usuariView.getUsuari();

                usuariService.validaUsuari(usuari);

                aplicaSeguretatMD5(usuari);
                aplicaSeguretatSHA256(usuari);
                aplicaSeguretatAES(usuari);

                usuariView.showMissatge("logs de operaciones:", false);
                usuariService.getLogs();

            } catch (Exception e) {
                usuariView.showMissatge("Error: " + e.getMessage(), true);
            }

            continuar = usuariView.demanarMesDades();
        }

        usuariView.showMissatge("Has finalizado el proceso", false);
    }

    private void aplicaSeguretatMD5(Usuari usuari) {
        try {
            String encrypted = usuariService.getUsuariEncriptatMD5(usuari);
            usuariView.showMissatge("contraseña encriptada con MD5: " + encrypted, false);
        } catch (Exception e) {
            usuariView.showMissatge("error en la encriptacion MD5: " + e.getMessage(), true);
        }
    }

    private void aplicaSeguretatSHA256(Usuari usuari) {
        try {
            String encrypted = usuariService.getUsuariEncriptatSHA256(usuari);
            usuariView.showMissatge("Contraseña encriptada con SHA-256: " + encrypted, false);
        } catch (Exception e) {
            usuariView.showMissatge("error en la encriptacion SHA-256: " + e.getMessage(), true);
        }
    }

    private void aplicaSeguretatAES(Usuari usuari) {
        try {
            String encrypted = usuariService.getUsuariEncriptatAES(usuari);
            usuariView.showMissatge("contraseña encriptada con AES: " + encrypted, false);

            String decrypted = usuariService.getUsuariDesencriptatAES(new Usuari(usuari.getMail(), encrypted));
            usuariView.showMissatge("contraseña encriptada con AES: " + decrypted, false);
        } catch (Exception e) {
            usuariView.showMissatge("error en la encriptacion AES: " + e.getMessage(), true);
        }
    }
}

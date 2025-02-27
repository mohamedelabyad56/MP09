package model.service;

import model.domain.Usuari;
import model.repository.UsuariLogRepository;

public class UsuariService {

    private UsuariLogRepository usuariLogRepository = new UsuariLogRepository();

    public String getUsuariEncriptatMD5(Usuari usuari) throws Exception {
        MD5SecurityService md5Service = new MD5SecurityService();
        String encrypted = md5Service.encripta(usuari.getPassword());
        usuariLogRepository.addUsuari("MD5", "Encriptació", usuari);
        return encrypted;
    }

    public String getUsuariEncriptatSHA256(Usuari usuari) throws Exception {
        SHA256SecurityService sha256Service = new SHA256SecurityService();
        String encrypted = sha256Service.encripta(usuari.getPassword());
        usuariLogRepository.addUsuari("SHA-256", "Encriptació", usuari);
        return encrypted;
    }

    public String getUsuariEncriptatAES(Usuari usuari) throws Exception {
        AESSecurityService aesService = new AESSecurityService();
        String encrypted = aesService.encripta(usuari.getPassword());
        usuariLogRepository.addUsuari("AES", "Encriptació", usuari);
        return encrypted;
    }

    public String getUsuariDesencriptatAES(Usuari usuari) throws Exception {
        AESSecurityService aesService = new AESSecurityService();
        String decrypted = aesService.desencripta(usuari.getPassword());
        usuariLogRepository.addUsuari("AES", "Desencriptació", usuari);
        return decrypted;
    }

    public void validaUsuari(Usuari usuari) throws Exception {
        if (usuari.getMail().isEmpty() || usuari.getPassword().length() < 6) {
            throw new Exception("Email o contrasenya no vàlids");
        }
    }

    public void getLogs() {
        for (var log : usuariLogRepository.getUsuarisLog()) {
            System.out.println(log);
        }
    }
}

package model.service;

import java.security.MessageDigest;
import java.util.Base64;

public class SHA256SecurityService {

    public String encripta(String valorOriginal) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] digest = md.digest(valorOriginal.getBytes());
        return Base64.getEncoder().encodeToString(digest);
    }
}

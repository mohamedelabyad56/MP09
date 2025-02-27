package model.service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESSecurityService {

    private static final String ENCRYPT_ALGORITHM = "AES";
    private static final String ENCRYPT_KEY = "12345678901234567890123456789012";

    public String encripta(String valorOriginal) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        SecretKey key = new javax.crypto.spec.SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedValue = cipher.doFinal(valorOriginal.getBytes());
        return Base64.getEncoder().encodeToString(encryptedValue);
    }

    public String desencripta(String encrypted) throws Exception {
        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGORITHM);
        SecretKey key = new javax.crypto.spec.SecretKeySpec(ENCRYPT_KEY.getBytes(), ENCRYPT_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedValue = Base64.getDecoder().decode(encrypted);
        byte[] decryptedValue = cipher.doFinal(decodedValue);
        return new String(decryptedValue);
    }
}

package mp09.uf01.seguretat.exemple.usuaris.model.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;



class MD5SecurityService {

	public String encripta(String valorOriginal) {
		String resultat = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(valorOriginal.getBytes());
			byte[] digestBytes = md.digest();

			resultat = Base64.getEncoder().encodeToString(digestBytes);

		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

		return resultat;
	}
	
	

}

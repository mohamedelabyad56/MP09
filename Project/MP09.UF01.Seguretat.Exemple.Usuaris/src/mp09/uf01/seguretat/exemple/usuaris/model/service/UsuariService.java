package mp09.uf01.seguretat.exemple.usuaris.model.service;

import java.util.ArrayList;

import mp09.uf01.seguretat.exemple.usuaris.model.domain.Usuari;
import mp09.uf01.seguretat.exemple.usuaris.model.domain.UsuariLog;
import mp09.uf01.seguretat.exemple.usuaris.model.repository.UsuariLogRepository;

public class UsuariService {

	
	UsuariLogRepository usuariLogRepository = null;
	public UsuariService()
	{
		usuariLogRepository = new UsuariLogRepository();
	}
	
	
	public Usuari getUsuariEncriptatMD5(Usuari usuari)
	{
		this.validaUsuari(usuari);
		usuariLogRepository.addUsuari("MD5", "Original", usuari);

		MD5SecurityService Security = new MD5SecurityService();
		String mailEnc = Security.encripta(usuari.getMail());
		String passwordEnc = Security.encripta(usuari.getPassword());
		Usuari usuariEnc = new Usuari();
		usuariEnc.setMail(mailEnc);
		usuariEnc.setPassword(passwordEnc);
		usuariLogRepository.addUsuari("MD5", "Encriptat", usuariEnc);
		return usuariEnc;
	}
	
	public Usuari getUsuariEncriptatSHA256(Usuari usuari)
	{
		this.validaUsuari(usuari);
		usuariLogRepository.addUsuari("SHA256", "Original", usuari);
		SHA256SecurityService Security = new SHA256SecurityService();
		String mailEnc = Security.encripta(usuari.getMail());
		String passwordEnc = Security.encripta(usuari.getPassword());
		Usuari usuariEnc = new Usuari();
		usuariEnc.setMail(mailEnc);
		usuariEnc.setPassword(passwordEnc);
		usuariLogRepository.addUsuari("SHA256", "Encriptat", usuariEnc);
		return usuariEnc;
	}
	
	public Usuari getUsuariEncriptatAES(Usuari usuari)
	{
		this.validaUsuari(usuari);
		usuariLogRepository.addUsuari("AES", "Original", usuari);
		AESSecurityService Security = new AESSecurityService();
		String mailEnc = Security.encripta(usuari.getMail());
		String passwordEnc = Security.encripta(usuari.getPassword());

		Usuari usuariEnc = new Usuari();
		usuariEnc.setMail(mailEnc);
		usuariEnc.setPassword(passwordEnc);
		usuariLogRepository.addUsuari("AES", "Encriptat", usuariEnc);
		return usuariEnc;
	}
	
	public Usuari getUsuariDesencriptatAES(Usuari usuariEnc)
	{
		AESSecurityService Security = new AESSecurityService();
		String mailDesenc = Security.desencripta(usuariEnc.getMail());
		String passwordDesenc = Security.desencripta(usuariEnc.getPassword());

		Usuari usuariDesenc = new Usuari();
		usuariDesenc.setMail(mailDesenc);
		usuariDesenc.setPassword(passwordDesenc);
		usuariLogRepository.addUsuari("AES", "Desencriptat", usuariDesenc);
		return usuariDesenc;
	}
	
	public ArrayList<UsuariLog> getLogs()
	{
		return usuariLogRepository.getUsuarisLog();
	}
	
	private void validaUsuari(Usuari usuari) {
		if (usuari == null)
			throw new RuntimeException("L'usuari ha d'estar informat");

		if (usuari.getMail() == "" || !usuari.getMail().contains("@"))
			throw new RuntimeException("El nom d'usuari ha d'estar informat i tenir un format vàlid");

		if (usuari.getPassword().length() < 6)
			throw new RuntimeException("El password ha de tenir almenys 6 caràcters");
	}

}

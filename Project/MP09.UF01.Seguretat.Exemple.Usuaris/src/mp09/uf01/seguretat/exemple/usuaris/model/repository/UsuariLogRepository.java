package mp09.uf01.seguretat.exemple.usuaris.model.repository;

import java.util.ArrayList;

import mp09.uf01.seguretat.exemple.usuaris.model.domain.Usuari;
import mp09.uf01.seguretat.exemple.usuaris.model.domain.UsuariLog;

public class UsuariLogRepository {

	private static ArrayList<UsuariLog> usuaris = new ArrayList<UsuariLog>();

	public void addUsuari(String algoritme, String accio, Usuari usuari) {
		
		UsuariLog usuariLog = new UsuariLog();
		usuariLog.setAlgoritme(algoritme);
		usuariLog.setAccio(accio);
		usuariLog.setUsuari(usuari);
		usuaris.add(usuariLog);
	}
	
	public ArrayList<UsuariLog> getUsuarisLog()
	{
		return usuaris;
	}
}

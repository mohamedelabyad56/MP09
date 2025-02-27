package mp09.uf01.seguretat.exemple.usuaris.model.domain;

public class UsuariLog {
	String Algoritme;
	String accio;
	Usuari usuari;

	public String getAlgoritme() {
		return Algoritme;
	}

	public void setAlgoritme(String algoritme) {
		Algoritme = algoritme;
	}

	public String getAccio() {
		return accio;
	}

	public void setAccio(String accio) {
		this.accio = accio;
	}

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

	@Override
	public String toString() {
		return "UsuariLog [Algoritme=" + Algoritme + ", accio=" + accio + ", usuari=" + usuari + "]";
	}

}

package mp09.uf01.seguretat.exemple.usuaris.model.domain;

public class Usuari {

	private String mail;
	private String password;

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuari [mail=" + mail + ", password=" + password + "]";
	}

}

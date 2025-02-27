package model.domain;

public class Usuari {
    // Atributos
    private String mail; 
    private String password;


    public Usuari() {
    }

  
    public Usuari(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    // Métodos getters y setters
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

    // Metodo toString
    @Override
    public String toString() {
        return "Usuari{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

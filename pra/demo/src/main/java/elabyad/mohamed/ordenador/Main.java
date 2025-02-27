package elabyad.mohamed.ordenador;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        // Crear un objeto
        Persona persona = new Persona("Joan", "Garcia", 30);

        // Crear una instancia de Gson
        Gson gson = new Gson();

        // Convertir el objeto a JSON
        String json = gson.toJson(persona);
        System.out.println(json);

        // Convertir el JSON de vuelta a un objeto
        Persona personaFromJson = gson.fromJson(json, Persona.class);
        System.out.println(personaFromJson.getNom());
    }
}

class Persona {
    private String nom;
    private String cognom;
    private int edat;

    public Persona(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }
}

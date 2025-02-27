package elabyad.mohamed.MP06.UF01.JSON;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class OrdinadorLogic {

    // Serialización de un único objeto
    public void serialitzarOrdinador(Ordinador ordinador) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("ordinador.json")) {
            gson.toJson(ordinador, writer);
            System.out.println("Ordinador serialitzat a JSON correctament.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialización de un único objeto
    public Ordinador deserialitzarOrdinador() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("ordinador.json")) {
            return gson.fromJson(reader, Ordinador.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Serialización de una lista de objetos
    public void serialitzarLlistaOrdinadors(List<Ordinador> ordinadors) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter("ordinadors.json")) {
            gson.toJson(ordinadors, writer);
            System.out.println("Llista d'ordinadors serialitzada a JSON correctament.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialización de una lista de objetos
    public List<Ordinador> deserialitzarLlistaOrdinadors() {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader("ordinadors.json")) {
            Type listType = new TypeToken<List<Ordinador>>() {}.getType();
            return gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

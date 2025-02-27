package elabyad.mohamed.MP06.UF01.JSON;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrdinadorLogic logic = new OrdinadorLogic();

        // Crear un objeto Ordinador
        Ordinador ordinador1 = new Ordinador("Dell", "XPS 15", 16, 512, "Intel i7");
        Ordinador ordinador2 = new Ordinador("Apple", "MacBook Pro", 32, 1024, "M1 Max");

        // Serializar un único objeto
        logic.serialitzarOrdinador(ordinador1);

        // Deserializar un único objeto
        Ordinador deserialitzat = logic.deserialitzarOrdinador();
        System.out.println("Ordinador deserialitzat: " + deserialitzat);

        // Crear y serializar una lista de objetos
        List<Ordinador> ordinadors = new ArrayList<>();
        ordinadors.add(ordinador1);
        ordinadors.add(ordinador2);
        logic.serialitzarLlistaOrdinadors(ordinadors);

        // Deserializar una lista de objetos
        List<Ordinador> llistaDeserialitzada = logic.deserialitzarLlistaOrdinadors();
        System.out.println("Llista d'ordinadors deserialitzada:");
        for (Ordinador ord : llistaDeserialitzada) {
            System.out.println(ord);
        }
    }
}

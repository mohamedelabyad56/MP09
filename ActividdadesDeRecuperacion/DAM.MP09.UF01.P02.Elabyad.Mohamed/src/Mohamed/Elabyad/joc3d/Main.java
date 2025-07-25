package Mohamed.Elabyad.joc3d;

public class Main {
    public static void main(String[] args) {
        EntornJoc entorn = new EntornJoc(800, 600, 200);
        EventJoc event = new EventJoc(entorn);

        ElementJoc e1 = event.generarElement();
        ElementJoc e2 = event.generarElement();

        System.out.println("Element 1: " + e1);
        System.out.println("Element 2: " + e2);
        System.out.println("Col·lisió: " + event.verificarColisio(e1, e2));
    }
}

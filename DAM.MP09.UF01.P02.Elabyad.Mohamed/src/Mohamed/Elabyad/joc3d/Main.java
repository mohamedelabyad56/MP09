package Mohamed.Elabyad.joc3d;

public class Main {
    public static void main(String[] args) {
        // Crea un entorno de juego con las dimensiones de la pantalla
        EntornJoc entorn = new EntornJoc(800, 600, 200); // Amplada, Alçada, Profunditat
        EventJoc event = new EventJoc(entorn);
        
        // Genera dos elementos con coordenadas 3D
        ElementJoc e1 = event.generarElement();
        ElementJoc e2 = event.generarElement();
        
        // Imprime los elementos y verifica si hay colisión
        System.out.println("Element 1: " + e1);
        System.out.println("Element 2: " + e2);
        System.out.println("Col·lisió: " + event.verificarColisio(e1, e2));
    }
}

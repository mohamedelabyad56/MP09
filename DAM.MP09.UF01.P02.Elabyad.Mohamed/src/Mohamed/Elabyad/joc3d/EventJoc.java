package Mohamed.Elabyad.joc3d;

import javax.swing.*;
import java.util.Random;

public class EventJoc {
    private EntornJoc entorn;

    public EventJoc(EntornJoc entorn) {
        this.entorn = entorn;
    }

    public ElementJoc generarElement() {
        Random rand = new Random();
        int x = rand.nextInt(entorn.getMidaAmpladaPantalla());
        int y = rand.nextInt(entorn.getMidaAlturaPantalla());
        int z = rand.nextInt(entorn.getMidaProfunditatPantalla());
        int velX = rand.nextInt(5) + 1;
        int velY = rand.nextInt(5) + 1;
        int velZ = rand.nextInt(5) + 1;
        return new ElementJoc(x, y, z, velX, velY, velZ);
    }

    public boolean verificarColisio(ElementJoc e1, ElementJoc e2) {
        int radi = 20;
        double distancia = Math.sqrt(
            Math.pow(e1.getPosicioX() - e2.getPosicioX(), 2) +
            Math.pow(e1.getPosicioY() - e2.getPosicioY(), 2) +
            Math.pow(e1.getPosicioZ() - e2.getPosicioZ(), 2)
        );
        return distancia < radi * 2;
    }

    public static void main(String[] args) {
        JFrame finestra = new JFrame("Joc 3D");
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);

        int amplada = 800;
        int altura = 600;
        int profunditat = 1000;
        EntornJoc entorn = new EntornJoc(amplada, altura, profunditat);
        EventJoc event = new EventJoc(entorn);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            ElementJoc element = event.generarElement();
            entorn.afegirElement(element);
        }

        finestra.add(entorn);
        finestra.pack();
        finestra.setLocationRelativeTo(null);
        finestra.setVisible(true);
    }
}

package Mohamed.Elabyad.joc3d;

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
        return new ElementJoc(x, y, z);
    }

    public boolean verificarColisio(ElementJoc e1, ElementJoc e2) {
        return e1.getPosicioX() == e2.getPosicioX() &&
               e1.getPosicioY() == e2.getPosicioY() &&
               e1.getPosicioZ() == e2.getPosicioZ();
    }
}

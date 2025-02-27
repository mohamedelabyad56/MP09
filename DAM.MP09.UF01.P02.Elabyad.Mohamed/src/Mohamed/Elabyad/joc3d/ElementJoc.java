package Mohamed.Elabyad.joc3d;

public class ElementJoc {
    private int x, y, z;

    // Constructor para inicializar las coordenadas
    public ElementJoc(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Getters para las coordenadas
    public int getPosicioX() {
        return x;
    }

    public int getPosicioY() {
        return y;
    }

    public int getPosicioZ() {
        return z;
    }

    // Sobrescribir el método toString() para imprimir el elemento
    @Override
    public String toString() {
        return "Coordenades (" + x + ", " + y + ", " + z + ")";
    }
}

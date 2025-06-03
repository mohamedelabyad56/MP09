package Mohamed.Elabyad.joc3d;

public class ElementJoc {
    private int posicioX;
    private int posicioY;
    private int posicioZ;
    private int velocitatX;
    private int velocitatY;
    private int velocitatZ;

    public ElementJoc(int posicioX, int posicioY, int posicioZ) {
        this(posicioX, posicioY, posicioZ, 0, 0, 0);
    }

    public ElementJoc(int posicioX, int posicioY, int posicioZ, int velocitatX, int velocitatY, int velocitatZ) {
        this.posicioX = posicioX;
        this.posicioY = posicioY;
        this.posicioZ = posicioZ;
        this.velocitatX = velocitatX;
        this.velocitatY = velocitatY;
        this.velocitatZ = velocitatZ;
    }

    public int getPosicioX() {
        return posicioX;
    }

    public void setPosicioX(int posicioX) {
        this.posicioX = posicioX;
    }

    public int getPosicioY() {
        return posicioY;
    }

    public void setPosicioY(int posicioY) {
        this.posicioY = posicioY;
    }

    public int getPosicioZ() {
        return posicioZ;
    }

    public void setPosicioZ(int posicioZ) {
        this.posicioZ = posicioZ;
    }

    public int getVelocitatX() {
        return velocitatX;
    }

    public void setVelocitatX(int velocitatX) {
        this.velocitatX = velocitatX;
    }

    public int getVelocitatY() {
        return velocitatY;
    }

    public void setVelocitatY(int velocitatY) {
        this.velocitatY = velocitatY;
    }

    public int getVelocitatZ() {
        return velocitatZ;
    }

    public void setVelocitatZ(int velocitatZ) {
        this.velocitatZ = velocitatZ;
    }

    public void moure(int ampladaPantalla, int alturaPantalla, int profunditatPantalla) {
        posicioX += velocitatX;
        posicioY += velocitatY;
        posicioZ += velocitatZ;

        if (posicioX < 0 || posicioX > ampladaPantalla) {
            velocitatX = -velocitatX;
            posicioX = Math.max(0, Math.min(posicioX, ampladaPantalla));
        }
        if (posicioY < 0 || posicioY > alturaPantalla) {
            velocitatY = -velocitatY;
            posicioY = Math.max(0, Math.min(posicioY, alturaPantalla));
        }
        if (posicioZ < 0 || posicioZ > profunditatPantalla) {
            velocitatZ = -velocitatZ;
            posicioZ = Math.max(0, Math.min(posicioZ, profunditatPantalla));
        }
    }

    @Override
    public String toString() {
        return "ElementJoc{posicioX=" + posicioX + ", posicioY=" + posicioY + ", posicioZ=" + posicioZ + "}";
    }
}
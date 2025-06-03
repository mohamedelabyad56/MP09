package Mohamed.Elabyad.joc3d;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EntornJoc extends JPanel implements Runnable {
    private int midaAmpladaPantalla;
    private int midaAlturaPantalla;
    private int midaProfunditatPantalla;
    private List<ElementJoc> elements;
    private Thread filJoc;

    public EntornJoc(int amplada, int altura, int profunditat) {
        this.midaAmpladaPantalla = amplada;
        this.midaAlturaPantalla = altura;
        this.midaProfunditatPantalla = profunditat;
        this.elements = new ArrayList<>();
        setPreferredSize(new Dimension(amplada, altura));
        filJoc = new Thread(this);
        filJoc.start();
    }

    public void afegirElement(ElementJoc element) {
        elements.add(element);
    }

    public int getMidaAmpladaPantalla() {
        return midaAmpladaPantalla;
    }

    public void setMidaAmpladaPantalla(int amplada) {
        this.midaAmpladaPantalla = amplada;
    }

    public int getMidaAlturaPantalla() {
        return midaAlturaPantalla;
    }

    public void setMidaAlturaPantalla(int altura) {
        this.midaAlturaPantalla = altura;
    }

    public int getMidaProfunditatPantalla() {
        return midaProfunditatPantalla;
    }

    public void setMidaProfunditatPantalla(int profunditat) {
        this.midaProfunditatPantalla = profunditat;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (ElementJoc element : elements) {
            int escala = Math.max(1, element.getPosicioZ() / 100);
            int tamany = 20 * escala;
            int x = element.getPosicioX() - tamany / 2;
            int y = element.getPosicioY() - tamany / 2;
            g2d.fillOval(x, y, tamany, tamany);
        }
    }

    @Override
    public void run() {
        while (true) {
            for (ElementJoc element : elements) {
                element.moure(midaAmpladaPantalla, midaAlturaPantalla, midaProfunditatPantalla);
            }
            repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

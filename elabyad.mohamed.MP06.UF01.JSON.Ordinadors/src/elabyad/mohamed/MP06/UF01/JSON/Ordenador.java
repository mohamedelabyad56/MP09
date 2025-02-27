package elabyad.mohamed.MP06.UF01.JSON;
public class Ordinador {
    private transient String numSerie; // No se serializa
    private String marca;
    private String model;
    private int memoria; // Memoria RAM en GB
    private int discDur; // Capacidad del disco duro en GB
    private String processador;

    public Ordinador(String marca, String model, int memoria, int discDur, String processador) {
        this.marca = marca;
        this.model = model;
        this.memoria = memoria;
        this.discDur = discDur;
        this.processador = processador;
    }

    public Ordinador() {} // Constructor vacío para Gson

    @Override
    public String toString() {
        return "Ordinador [marca=" + marca + ", model=" + model + ", memoria=" + memoria +
               ", discDur=" + discDur + ", processador=" + processador + "]";
    }
}

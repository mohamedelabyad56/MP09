package Mohamed.Elabyad.planificacio.fils;


public class ExecucioFils {
    public static void main(String[] args) {

        Cronometre[] cronos = {
            new Cronometre("CronoAlfa", 21, 0),
            new Cronometre("CronoBravo", 15, 4),
            new Cronometre("CronoCharlie", 12, 0),
            new Cronometre("CronoDelta", 6, 6),
            new Cronometre("CronoEcho", 11, 8),
            new Cronometre("CronoFoxtrot", 4, 0),
            new Cronometre("CronoGolf", 7, 0)
        };

        for (Cronometre crono : cronos) {
            crono.start();
        }
    }
}
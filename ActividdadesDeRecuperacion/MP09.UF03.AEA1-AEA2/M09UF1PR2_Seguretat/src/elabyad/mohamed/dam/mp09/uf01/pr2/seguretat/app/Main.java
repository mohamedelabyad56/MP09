
package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.app;

import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.repository.VisitaMedicaRepository;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.service.VisitaMedicaService;
import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.view.console.ConsoleView;

public class Main {
    public static void main(String[] args) {
        VisitaMedicaService service = new VisitaMedicaService();
        VisitaMedicaRepository repository = new VisitaMedicaRepository();
        ConsoleView view = new ConsoleView(service, repository);
        view.start();
    }
}
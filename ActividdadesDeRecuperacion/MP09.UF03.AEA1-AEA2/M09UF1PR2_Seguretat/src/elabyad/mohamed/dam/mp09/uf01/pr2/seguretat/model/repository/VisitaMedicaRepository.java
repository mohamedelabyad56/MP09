
package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.repository;

import elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain.VisitaMedicaLog;

import java.util.ArrayList;
import java.util.List;

public class VisitaMedicaRepository {
    private List<VisitaMedicaLog> logs;

    public VisitaMedicaRepository() {
        this.logs = new ArrayList<>();
    }

    public void addLog(VisitaMedicaLog log) {
        logs.add(log);
    }

    public List<VisitaMedicaLog> getAllLogs() {
        return new ArrayList<>(logs);
    }
}
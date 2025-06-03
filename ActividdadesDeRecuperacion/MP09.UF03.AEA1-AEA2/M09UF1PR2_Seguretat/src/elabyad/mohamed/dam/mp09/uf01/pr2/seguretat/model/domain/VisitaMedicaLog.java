
package elabyad.mohamed.dam.mp09.uf01.pr2.seguretat.model.domain;

import java.time.LocalDateTime;

public class VisitaMedicaLog {
    private VisitaMedica visitaMedica;
    private String operation;
    private LocalDateTime timestamp;

    public VisitaMedicaLog(VisitaMedica visitaMedica, String operation) {
        this.visitaMedica = visitaMedica;
        this.operation = operation;
        this.timestamp = LocalDateTime.now();
    }

    public VisitaMedica getVisitaMedica() {
        return visitaMedica;
    }

    public void setVisitaMedica(VisitaMedica visitaMedica) {
        this.visitaMedica = visitaMedica;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "VisitaMedicaLog{" +
               "visitaMedica=" + visitaMedica +
               ", operation='" + operation + '\'' +
               ", timestamp=" + timestamp +
               '}';
    }
}
package model.repository;

import model.domain.UsuariLog;
import java.util.ArrayList;

public class UsuariLogRepository {
    private ArrayList<UsuariLog> usuaris;

    public UsuariLogRepository() {
        usuaris = new ArrayList<>();
    }

    public void addUsuari(String algoritme, String accio, model.domain.Usuari usuari) {
        UsuariLog log = new UsuariLog(algoritme, accio, usuari);
        usuaris.add(log);
    }

    public ArrayList<UsuariLog> getUsuarisLog() {
        return usuaris;
    }
}

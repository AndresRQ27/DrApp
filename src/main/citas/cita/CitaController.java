package main.citas.cita;

import main.citas.CitasManager;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * main.citas.cita
 */
public class CitaController {


    public void initManager(final CitaManager citaManager) {
        initManager(new CitasManager(citaManager.scene), citaManager);
    }

    private void initManager(CitasManager citasManager, CitaManager citaManager) {}
}

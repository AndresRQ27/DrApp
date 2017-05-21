package main.casosClinicos.medicamentos;

import main.casosClinicos.CasosManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by andres on 20/05/17.
 * DrApp
 * main.casosClinicos.medicamentos
 */
public class MedicamentosController {
    @FXML private Button guardar;
    @FXML private Button cancelar;

    public void initManager(CasosManager casosManager) {
        cancelar.setOnAction(event -> casosManager.showCasosScreen());
    }
}

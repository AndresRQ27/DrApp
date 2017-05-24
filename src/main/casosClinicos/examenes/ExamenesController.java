package main.casosClinicos.examenes;

import javafx.scene.control.TextField;
import main.casosClinicos.CasosManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by andres on 20/05/17.
 * DrApp
 * main.casosClinicos.medicamentos
 */
public class ExamenesController {
    @FXML private Button guardar;
    @FXML private Button cancelar;

    @FXML private TextField n0;
    @FXML private TextField n1;
    @FXML private TextField n2;
    @FXML private TextField n3;
    @FXML private TextField n4;
    @FXML private TextField n5;
    @FXML private TextField n6;
    @FXML private TextField n7;
    @FXML private TextField n8;
    @FXML private TextField n9;
    @FXML private TextField n10;

    @FXML private TextField c0;
    @FXML private TextField c1;
    @FXML private TextField c2;
    @FXML private TextField c3;
    @FXML private TextField c4;
    @FXML private TextField c5;
    @FXML private TextField c6;
    @FXML private TextField c7;
    @FXML private TextField c8;
    @FXML private TextField c9;
    @FXML private TextField c10;

    public void initManager(CasosManager casosManager) {
        cancelar.setOnAction(event -> casosManager.showCasosScreen());
    }
}

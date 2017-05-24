package main.casosClinicos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainManager;

/**
 * Created by andres on 16/05/17.
 * DrApp
 * main.casosClinicos
 */
public class CasosController {
    @FXML
    private TextField nombre;
    @FXML
    private Button eliminar;
    @FXML
    private Button examenes;
    @FXML
    private Button medicamentos;
    @FXML
    private Button cancelar;
    @FXML
    private Button guardar;

    public void initialize() {
    }

    //Siempre devovler json con las modificaciones

    public void initManager(final CasosManager casosManager) {
        initManager(new MainManager(casosManager.scene), casosManager);
    }

    private void initManager(MainManager mainManager, CasosManager casosManager) {

        medicamentos.setOnAction(event -> casosManager.showMedScreen());

        examenes.setOnAction(event -> casosManager.showExScreen());

        guardar.setOnAction(event -> {
        });

        eliminar.setOnAction(event -> {
            //devolver un json vacio y ventana principal
        });

        cancelar.setOnAction(event -> {
            mainManager.showMainScreen();
        });
    }


}

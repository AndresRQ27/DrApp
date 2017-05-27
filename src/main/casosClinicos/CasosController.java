package main.casosClinicos;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainManager;
import org.json.simple.JSONObject;

import java.util.List;

/**
 * Created by andres on 16/05/17.
 * DrApp
 * main.casosClinicos
 */
public class CasosController {
    @FXML
    private TextField nombre;
    @FXML
    private Button examenes;
    @FXML
    private Button medicamentos;
    @FXML
    private Button salir;
    @FXML
    private Button guardar;

    public void initialize() {
    }

    //Siempre devovler json con las modificaciones

    public void initManagerCrear(final CasosManager casosManager) {
        initManagerCrear(new MainManager(casosManager.scene), casosManager);
    }

    private void initManagerCrear(MainManager mainManager, CasosManager casosManager) {

        medicamentos.setOnAction(event -> {
            if (!nombre.getText().isEmpty()) {
                casosManager.showMedScreen(nombre.getText());
            }
        });

        examenes.setOnAction(event -> {
            if (!nombre.getText().isEmpty()) {
                casosManager.showExScreen(nombre.getText());
            }
        });

        guardar.setOnAction(event -> {
            if (!nombre.getText().isEmpty()) {
                casosManager.guardarCaso(nombre.getText());
                guardar.setDisable(true);
                nombre.setDisable(true);
                examenes.setDisable(false);
                medicamentos.setDisable(false);
            }
        });

        salir.setOnAction(event -> mainManager.showMainScreen());
    }


    public void initManagerCargar(CasosManager casosManager, JSONObject jsonObject) {
        initManagerCargar(new MainManager((casosManager.scene)), casosManager, jsonObject);
    }

    private void initManagerCargar(MainManager mainManager, CasosManager casosManager, JSONObject jsonObject){

        nombre.setText((String) jsonObject.get("nombre"));

        medicamentos.setOnAction(event -> {
            if (!nombre.getText().isEmpty()) {
                casosManager.showMedScreenLoad(nombre.getText(), (List<JSONObject>) jsonObject.get("medicamentos"));
            }
        });

        examenes.setOnAction(event -> {
            if (!nombre.getText().isEmpty()) {
                casosManager.showExScreenLoad(nombre.getText(), (List<JSONObject>) jsonObject.get("examenes"));
            }
        });

        guardar.setOnAction(event -> {
            if (!nombre.getText().isEmpty()) {
                casosManager.actualizarCaso((String) jsonObject.get("nombre") ,nombre.getText());
                guardar.setDisable(true);
                nombre.setDisable(true);
                examenes.setDisable(false);
                medicamentos.setDisable(false);
            }
        });

        salir.setOnAction(event -> mainManager.showMainScreen());
    }
}

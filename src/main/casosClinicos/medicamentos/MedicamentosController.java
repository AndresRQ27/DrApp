package main.casosClinicos.medicamentos;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.casosClinicos.CasosManager;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andres on 20/05/17.
 * DrApp
 * main.casosClinicos.medicamentos
 */
public class MedicamentosController {
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

    public void initManager(CasosManager casosManager, String text) {
        cancelar.setOnAction(event -> {
            Stage stage = (Stage) guardar.getScene().getWindow();
            stage.close();
        });

        guardar.setOnAction(event -> {
            guardarMedicamentos(casosManager, text);
            Stage stage = (Stage) guardar.getScene().getWindow();
            stage.close();
        });
    }

    private void guardarMedicamentos(CasosManager casosManager, String text){
        List<String> nombres = new LinkedList<>();
        List<Integer> costos = new LinkedList<>();

        try {
            if (!n0.getText().isEmpty() && !c0.getText().isEmpty()) {
                nombres.add(n0.getText());
                costos.add(Integer.parseInt(c0.getText()));
            } if (!n1.getText().isEmpty() && !c1.getText().isEmpty()) {
                nombres.add(n1.getText());
                costos.add(Integer.parseInt(c1.getText()));
            } if (!n2.getText().isEmpty() && !c2.getText().isEmpty()) {
                nombres.add(n2.getText());
                costos.add(Integer.parseInt(c2.getText()));
            } if (!n3.getText().isEmpty() && !c3.getText().isEmpty()) {
                nombres.add(n3.getText());
                costos.add(Integer.parseInt(c3.getText()));
            } if (!n4.getText().isEmpty() && !c4.getText().isEmpty()) {
                nombres.add(n4.getText());
                costos.add(Integer.parseInt(c4.getText()));
            } if (!n5.getText().isEmpty() && !c5.getText().isEmpty()) {
                nombres.add(n5.getText());
                costos.add(Integer.parseInt(c5.getText()));
            } if (!n6.getText().isEmpty() && !c6.getText().isEmpty()) {
                nombres.add(n6.getText());
                costos.add(Integer.parseInt(c6.getText()));
            } if (!n7.getText().isEmpty() && !c7.getText().isEmpty()) {
                nombres.add(n7.getText());
                costos.add(Integer.parseInt(c7.getText()));
            } if (!n8.getText().isEmpty() && !c8.getText().isEmpty()) {
                nombres.add(n8.getText());
                costos.add(Integer.parseInt(c8.getText()));
            } if (!n9.getText().isEmpty() && !c9.getText().isEmpty()) {
                nombres.add(n9.getText());
                costos.add(Integer.parseInt(c9.getText()));
            } if (!n10.getText().isEmpty() && !c10.getText().isEmpty()) {
                nombres.add(n10.getText());
                costos.add(Integer.parseInt(c10.getText()));
            }

        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

        casosManager.guardarMedicamento(text, nombres, costos);
    }

    public void initManager(CasosManager casosManager, String text, List<JSONObject> medicamentos) {
        List<String> nombres = new LinkedList<>();
        List<Integer> costos = new LinkedList<>();

        List<TextField> reNombre = listNombre();
        List<TextField> reCosto = listCostos();

        for (int i = 0; i < medicamentos.size(); i++){
            reNombre.get(i).setText((String) medicamentos.get(i).get("nombre"));
            reCosto.get(i).setText(String.valueOf(((Long) medicamentos.get(i).get("costo")).intValue()));
        }

        cancelar.setOnAction(event -> {
            Stage stage = (Stage) guardar.getScene().getWindow();
            stage.close();
        });

        guardar.setOnAction(event -> {
            guardarReMedicamentos(casosManager, text);
            Stage stage = (Stage) guardar.getScene().getWindow();
            stage.close();
        });
    }

    private void guardarReMedicamentos(CasosManager casosManager, String text) {
        List<String> nombres = new LinkedList<>();
        List<Integer> costos = new LinkedList<>();

        try {
            if (!n0.getText().isEmpty() && !c0.getText().isEmpty()) {
                nombres.add(n0.getText());
                costos.add(Integer.parseInt(c0.getText()));
            } if (!n1.getText().isEmpty() && !c1.getText().isEmpty()) {
                nombres.add(n1.getText());
                costos.add(Integer.parseInt(c1.getText()));
            } if (!n2.getText().isEmpty() && !c2.getText().isEmpty()) {
                nombres.add(n2.getText());
                costos.add(Integer.parseInt(c2.getText()));
            } if (!n3.getText().isEmpty() && !c3.getText().isEmpty()) {
                nombres.add(n3.getText());
                costos.add(Integer.parseInt(c3.getText()));
            } if (!n4.getText().isEmpty() && !c4.getText().isEmpty()) {
                nombres.add(n4.getText());
                costos.add(Integer.parseInt(c4.getText()));
            } if (!n5.getText().isEmpty() && !c5.getText().isEmpty()) {
                nombres.add(n5.getText());
                costos.add(Integer.parseInt(c5.getText()));
            } if (!n6.getText().isEmpty() && !c6.getText().isEmpty()) {
                nombres.add(n6.getText());
                costos.add(Integer.parseInt(c6.getText()));
            } if (!n7.getText().isEmpty() && !c7.getText().isEmpty()) {
                nombres.add(n7.getText());
                costos.add(Integer.parseInt(c7.getText()));
            } if (!n8.getText().isEmpty() && !c8.getText().isEmpty()) {
                nombres.add(n8.getText());
                costos.add(Integer.parseInt(c8.getText()));
            } if (!n9.getText().isEmpty() && !c9.getText().isEmpty()) {
                nombres.add(n9.getText());
                costos.add(Integer.parseInt(c9.getText()));
            } if (!n10.getText().isEmpty() && !c10.getText().isEmpty()) {
                nombres.add(n10.getText());
                costos.add(Integer.parseInt(c10.getText()));
            }

        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }

        casosManager.guardarReMedicamento(text, nombres, costos);
    }

    private List<TextField> listNombre(){
        List<TextField> textFields = new ArrayList();
        textFields.add(n1);
        textFields.add(n2);
        textFields.add(n3);
        textFields.add(n4);
        textFields.add(n5);
        textFields.add(n6);
        textFields.add(n7);
        textFields.add(n8);
        textFields.add(n9);
        textFields.add(n10);

        return textFields;
    }

    private List<TextField> listCostos(){
        List<TextField> textFields = new ArrayList();
        textFields.add(c1);
        textFields.add(c2);
        textFields.add(c3);
        textFields.add(c4);
        textFields.add(c5);
        textFields.add(c6);
        textFields.add(c7);
        textFields.add(c8);
        textFields.add(c9);
        textFields.add(c10);

        return textFields;
    }
}

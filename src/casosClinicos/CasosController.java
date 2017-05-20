package casosClinicos;

import general.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * Created by andres on 16/05/17.
 * DrApp
 * casosClinicos
 */
public class CasosController {
    @FXML private DatePicker fecha;
    @FXML private TextField nombre;
    @FXML private TextField carnet;
    @FXML private TextField genero;
    @FXML private TextField estatura;
    @FXML private TextField peso;
    @FXML private TextField sangre;
    @FXML private TextField alergias;
    @FXML private TextField sintomas;
    @FXML private Button eliminar;
    @FXML private Button finalizar;
    @FXML private Button examenes;
    @FXML private Button medicamentos;
    @FXML private Button cancelar;
    @FXML private Button guardar;

    public void initialize() {}

    //Siempre devovler json con las modificaciones
    public void initManager(final CasosManager casosManager) {
        guardar.setOnAction(event -> {
            if (verifyData()){
                //Parsear a json
            }
        });

        medicamentos.setOnAction(event -> casosManager.showMedScreen());

        examenes.setOnAction(event -> casosManager.showExScreen());

        finalizar.setOnAction(event -> {
            //devolverse a ventana principal
        });

        eliminar.setOnAction(event -> {
            //devolver un json vacio y ventana principal
        });

        cancelar.setOnAction(event -> {

        });
    }

    //Recibe valores de un json
    public void initViewer(final CasosManager casosManager){

        guardar.setOnAction(event -> {
            if (verifyData()){
                //Parsear a json
            }
        });

        cancelar.setOnAction(event -> {

        });
    }


    private boolean verifyData(){

        boolean result = false;

        if (Data.gender.contains(genero.getText())){
            if (Data.bloodType.contains(sangre.getText())){
                if ((!peso.getText().contains("-") && noLetters(peso.getText()))){
                    if (!estatura.getText().contains("-") && noLetters(estatura.getText())) {
                        result = true;
                    }
                }
            }
        }

        return result;
    }

    private boolean noLetters(String text) {

        boolean result = true;

        if (text.contains("a")){result = false;}
        else if (text.contains("e")){result = false;}
        else if (text.contains("i")){result = false;}
        else if (text.contains("o")){result = false;}
        else if (text.contains("u")){result = false;}

        return result;
    }
}

package main.casosClinicos;

import general.Data;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.MainManager;

/**
 * Created by andres on 16/05/17.
 * DrApp
 * main.casosClinicos
 */
public class CasosController {
    @FXML private TextField prioridad;
    @FXML private TextField nombre;
    @FXML private TextField carnet;
    @FXML private TextField genero;
    @FXML private TextField estatura;
    @FXML private TextField peso;
    @FXML private TextField sangre;
    @FXML private TextField alergias;
    @FXML private TextField sintomas;
    @FXML private Button eliminar;
    @FXML private Button examenes;
    @FXML private Button medicamentos;
    @FXML private Button cancelar;
    @FXML private Button guardar;

    public void initialize() {}

    //Siempre devovler json con las modificaciones

    public void initManager(final CasosManager casosManager) {
        initManager(new MainManager(casosManager.scene), casosManager);
    }

    private void initManager(MainManager mainManager, CasosManager casosManager){

        medicamentos.setOnAction(event -> casosManager.showMedScreen());

        examenes.setOnAction(event -> casosManager.showExScreen());

        guardar.setOnAction(event -> {
            if (verifyData()){
                //Parsear a json
            }
        });

        eliminar.setOnAction(event -> {
            //devolver un json vacio y ventana principal
        });

        cancelar.setOnAction(event -> {
            mainManager.showMainScreen();
        });
    }

    //Recibe valores de un json
    public void initViewer(final CasosManager casosManager, String persona){

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
                        if (!prioridad.getText().contains("-") && noLetters(prioridad.getText()) && between1and10(prioridad.getText())) {
                            result = true;
                        }
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

    private boolean between1and10(String text){
        boolean result = false;

        if (text.contains("1")){result = true;}
        else if (text.contains("2")){result = true;}
        else if (text.contains("3")){result = true;}
        else if (text.contains("4")){result = true;}
        else if (text.contains("5")){result = true;}
        else if (text.contains("6")){result = true;}
        else if (text.contains("7")){result = true;}
        else if (text.contains("8")){result = true;}
        else if (text.contains("9")){result = true;}
        else if (text.contains("10")){result = true;}

        return result;
    }
}

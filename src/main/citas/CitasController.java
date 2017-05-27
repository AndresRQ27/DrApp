package main.citas;

import connection.NetClientGet;
import general.Data;
import general.URLName;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * main.citas
 */
public class CitasController {
    JSONArray jsonArray;

    @FXML private Button b1;
    @FXML private Button b2;
    @FXML private Button b3;
    @FXML private Button b4;
    @FXML private Button b5;
    @FXML private Button b6;
    @FXML private Button b7;
    @FXML private Button b8;
    @FXML private Button b9;
    @FXML private Button b10;
    @FXML private Button b11;
    @FXML private Button b12;
    @FXML private Button b13;
    @FXML private Button b14;
    @FXML private Button b15;

    @FXML private TextField t1;
    @FXML private TextField t2;
    @FXML private TextField t3;
    @FXML private TextField t4;
    @FXML private TextField t5;
    @FXML private TextField t6;
    @FXML private TextField t7;
    @FXML private TextField t8;
    @FXML private TextField t9;
    @FXML private TextField t10;
    @FXML private TextField t11;
    @FXML private TextField t12;
    @FXML private TextField t13;
    @FXML private TextField t14;
    @FXML private TextField t15;

    @FXML private javafx.scene.control.Button cancelar;

    public void initialize() {
    }

    public void initManager(final CitasManager citasManager) {
        initManager(new MainManager(citasManager.scene), citasManager);
    }

    private void initManager(MainManager mainManager, CitasManager citasManager) {

        resultados();

        cancelar.setOnAction(event -> mainManager.showMainScreen());

        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(0)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(1)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(2)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(3)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(4)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(5)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(6)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(7)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(8)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(9)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(10)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(11)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(12)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(13)));
        b1.setOnAction(event -> citasManager.showCitaScreen(jsonArray.get(14)));
    }

    private void resultados() {

        String url = URLName.getInstance() + "/Doctores/citas/" + Data.id;

        try {
            jsonArray = NetClientGet.NetClientGet(url);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<TextField> texts = listText();
        List<Button> buttons = listButton();

        for (int i = 0; i < jsonArray.size(); i++) {
            try{
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);

                texts.get(i).setText((String) jsonObject.get("nombre"));
                buttons.get(i).setDisable(false);

            } catch (NullPointerException e){
                break;
            }
        }
    }

    private List<TextField> listText(){
        List<TextField> textFields = new ArrayList();
        textFields.add(t1);
        textFields.add(t2);
        textFields.add(t3);
        textFields.add(t4);
        textFields.add(t5);
        textFields.add(t6);
        textFields.add(t7);
        textFields.add(t8);
        textFields.add(t9);
        textFields.add(t10);
        textFields.add(t11);
        textFields.add(t12);
        textFields.add(t13);
        textFields.add(t14);
        textFields.add(t15);

        return textFields;
    }

    private List<Button> listButton(){
        List<Button> textFields = new ArrayList();
        textFields.add(b1);
        textFields.add(b2);
        textFields.add(b3);
        textFields.add(b4);
        textFields.add(b5);
        textFields.add(b6);
        textFields.add(b7);
        textFields.add(b8);
        textFields.add(b9);
        textFields.add(b10);
        textFields.add(b11);
        textFields.add(b12);
        textFields.add(b13);
        textFields.add(b14);
        textFields.add(b15);

        return textFields;
    }
}

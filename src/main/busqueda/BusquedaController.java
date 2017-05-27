package main.busqueda;

import connection.NetClientGet;
import general.URLName;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainManager;
import main.casosClinicos.CasosManager;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andres on 24/05/17.
 * DrApp
 * main.busqueda
 */
public class BusquedaController {
    @FXML private Button cancelar;
    @FXML private Button buscar;
    @FXML private TextField busqueda;

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

    private JSONArray jsonArray = new JSONArray();


    public void initManager(final BusquedaManager busquedaManager){
        initManager(new MainManager(busquedaManager.scene), busquedaManager);
    }

    private void initManager(final MainManager mainManager, BusquedaManager busquedaManager){
        cancelar.setOnAction(event -> mainManager.showMainScreen());
        buscar.setOnAction(event -> resultados(busqueda.getText()));

        b1.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(0)));
        b2.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(1)));
        b3.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(2)));
        b4.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(3)));
        b5.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(4)));
        b6.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(5)));
        b7.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(6)));
        b8.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(7)));
        b9.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(8)));
        b10.setOnAction(event -> new CasosManager(busquedaManager.scene).showCargarCaso((JSONObject) jsonArray.get(9)));
    }

    private void resultados(String text) {

        String url = URLName.getInstance() + "/CasosClinicos/" + text;


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

        return textFields;
    }
}

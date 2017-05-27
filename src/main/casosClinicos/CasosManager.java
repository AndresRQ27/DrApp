package main.casosClinicos;

import connection.NetClientPost;
import connection.NetClientPut;
import general.URLName;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.casosClinicos.examenes.ExamenesController;
import main.casosClinicos.medicamentos.MedicamentosController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Manages control flow for logins */
public class CasosManager {
    public final Scene scene;
    private int id = 0;

    public CasosManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main application.
     * Will show the authLinkedIn application screen.
     */

    //Función para abrir ventana
    public void showCrearCasosScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("casos.fxml"));
            scene.setRoot((loader.load()));
            CasosController controller = loader.getController();
            controller.initManagerCrear(this);
        }  catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Ej para cambio de ventana
    void showMedScreen(String text) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicamentos/medicamentos.fxml"));
            Scene scene2 = new Scene(new StackPane());
            scene2.setRoot(loader.load());
            MedicamentosController controller = loader.getController();
            controller.initManager(this, text);
            Stage stage = new Stage();
            stage.setScene(scene2);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void showExScreen(String text) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("examenes/examenes.fxml"));
            Scene scene2 = new Scene(new StackPane());
            scene2.setRoot(loader.load());
            ExamenesController controller = loader.getController();
            controller.initManager(this, text);
            Stage stage = new Stage();
            stage.setScene(scene2);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarCaso(String text) {
        String url = URLName.getInstance() + "/CasosClinicos";
        String output = "{\"nombre\": \"" + text + "\"}";
        NetClientPost.NetClientPost(url, output);
    }

    public void guardarExamen(String text, List<String> nombres, List<Integer> costos) {

        String url = URLName.getInstance() + "/CasosClinicos/examenes/" + text;

        for (int i = 0; i < nombres.size(); i++) {
            String output = "{\"nombre\": \"" + nombres.get(i) + "\", \"costo\": " + costos.get(i) + "}";
            NetClientPost.NetClientPost(url, output);
        }
    }

    public void guardarMedicamento(String text, List<String> nombres, List<Integer> costos) {

        String url = URLName.getInstance() + "/CasosClinicos/medicamentos/" + text;

        for (int i = 0; i < nombres.size(); i++) {
            String output = "{\"nombre\": \"" + nombres.get(i) + "\", \"costo\": " + costos.get(i) + "}";
            NetClientPost.NetClientPost(url, output);
        }
    }

    //CARGAR

    public void showCargarCaso(JSONObject jsonObject) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("casos.fxml"));
            scene.setRoot((loader.load()));
            CasosController controller = loader.getController();
            controller.initManagerCargar(this, jsonObject);
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarCaso(String viejo, String nuevo) {

        String url = URLName.getInstance() + "/CasosClinicos/nombre/" + viejo;
        String output = "{\"nombre\": \"" + nuevo + "\"}";
        NetClientPut.NetClientPut(url, output);
    }


    public void showMedScreenLoad(String text, List<JSONObject> medicamentos) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicamentos/medicamentos.fxml"));
            Scene scene2 = new Scene(new StackPane());
            scene2.setRoot(loader.load());
            MedicamentosController controller = loader.getController();
            controller.initManager(this, text, medicamentos);
            Stage stage = new Stage();
            stage.setScene(scene2);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showExScreenLoad(String text, List<JSONObject> examenes) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("examenes/examenes.fxml"));
            Scene scene2 = new Scene(new StackPane());
            scene2.setRoot(loader.load());
            ExamenesController controller = loader.getController();
            controller.initManager(this, text, examenes);
            Stage stage = new Stage();
            stage.setScene(scene2);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarReMedicamento(String text, List<String> nombres, List<Integer> costos) {
        String url = URLName.getInstance() + "/CasosClinicos/medicamentos/" + text;

        for (int i = 0; i < nombres.size(); i++) {
            String output = "{\"nombre\": \"" + nombres.get(i) + "\", \"costo\": " + costos.get(i) + "}";
            NetClientPut.NetClientPut(url, output);
        }
    }

    public void guardarReExamenes(String text, List<String> nombres, List<Integer> costos) {
        String url = URLName.getInstance() + "/CasosClinicos/examenes/" + text;

        for (int i = 0; i < nombres.size(); i++) {
            String output = "{\"nombre\": \"" + nombres.get(i) + "\", \"costo\": " + costos.get(i) + "}";
            NetClientPut.NetClientPut(url, output);
        }
    }
}

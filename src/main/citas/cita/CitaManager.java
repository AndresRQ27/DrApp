package main.citas.cita;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * main.citas.cita
 */
public class CitaManager {
    public final Scene scene;

    public CitaManager(Scene scene) {
        this.scene = scene;
    }

    public void showCitaScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cita.fxml"));
            scene.setRoot((loader.load()));
            CitaController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(CitaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

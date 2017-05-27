package main.citas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import main.citas.cita.CitaManager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * main.citas
 */
public class CitasManager {
    public final Scene scene;

    public CitasManager(Scene scene) {
        this.scene = scene;
    }

    public void showCitasScreen(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("citas.fxml"));
            scene.setRoot((loader.load()));
            CitasController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(CitasManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCitaScreen(Object o){
            new CitaManager(this.scene).showCitaScreen();
    }
}

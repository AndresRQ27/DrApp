package main.busqueda;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import main.chat.ChatManager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 24/05/17.
 * DrApp
 * main.busqueda
 */
public class BusquedaManager {
    public final Scene scene;

    public BusquedaManager(Scene scene){this.scene = scene;}

    public void showBusquedaScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("busqueda.fxml"));
            scene.setRoot((loader.load()));
            BusquedaController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(ChatManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

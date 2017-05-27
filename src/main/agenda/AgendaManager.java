package main.agenda;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 27/05/17.
 * DrApp
 * main.agenda
 */
public class AgendaManager {
    public final Scene scene;

    public AgendaManager(Scene scene){this.scene = scene;}

    public void showChatScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chat.fxml"));
            scene.setRoot((loader.load()));
            AgendaController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(AgendaManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


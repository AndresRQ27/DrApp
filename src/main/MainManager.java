package main;

import main.busqueda.BusquedaManager;
import main.casosClinicos.CasosController;
import main.casosClinicos.CasosManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import main.chat.ChatManager;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 21/05/17.
 * DrApp
 * main
 */
public class MainManager {
    public final Scene scene;

    public MainManager(Scene scene) {
        this.scene = scene;
    }

    public void cancel() {
        showMainScreen();
    }

    public void showMainScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
            scene.setRoot((loader.load()));
            MainController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showCasosScreen() {
        new CasosManager(this.scene).showCasosScreen();
    }

    public void showChatScreen(){new ChatManager(this.scene).showChatScreen();}

    public void showBusquedaScreen() {new BusquedaManager(this.scene).showBusquedaScreen();}
}

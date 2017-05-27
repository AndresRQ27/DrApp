package aviso;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 26/05/17.
 * DrApp
 * aviso
 */
public class VentanaAvisoManager {
    public Scene scene;

    public VentanaAvisoManager(String text) {
        showCrearCasosScreen(text);
    }

    private void showCrearCasosScreen(String text) {

        this.scene = new Scene(new AnchorPane());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ventanaAviso.fxml"));

        try {
            scene.setRoot((loader.load()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        VentanaAvisoController controller = loader.getController();
        controller.initManager(this, text);

        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }
}

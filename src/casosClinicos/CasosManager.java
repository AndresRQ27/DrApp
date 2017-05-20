package casosClinicos;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 17/05/17.
 * DrApp
 * casosClinicos
 */
public class CasosManager {
    private Scene scene;

    public void showCasosScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("casos.fxml"));
            scene.setRoot((loader.load()));
            CasosController controller = loader.<CasosController>getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(CasosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cerrarViewer() {
    }

    public void cerrarManager() {
    }
}

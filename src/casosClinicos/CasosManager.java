package casosClinicos;

import authLinkedIn.LoginController;
import authLinkedIn.MainViewController;
import casosClinicos.examenes.ExamenesController;
import casosClinicos.medicamentos.MedicamentosController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 17/05/17.
 * DrApp
 * casosClinicos
 */

/** Manages control flow for logins */
public class CasosManager {
    private Scene scene;

    public CasosManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main application.
     * Will show the authLinkedIn application screen.
     */
    public void cancel2CasosScreen() {
        showCasosScreen();
    }

    //Función para abrir ventana
    public void showCasosScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("casos.fxml"));
            scene.setRoot((loader.load()));
            CasosController controller = loader.<CasosController>getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Ej para cambio de ventana
    void showMedScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicamentos/medicamentos.fxml"));
            scene.setRoot((Parent) loader.load());
            MedicamentosController controller = loader.<MedicamentosController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void showExScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("examenes/examenes.fxml"));
            scene.setRoot((Parent) loader.load());
            ExamenesController controller = loader.<ExamenesController>getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

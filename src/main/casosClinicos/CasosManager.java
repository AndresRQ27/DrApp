package main.casosClinicos;

import connection.NetClientPost;
import general.URLName;
import main.casosClinicos.examenes.ExamenesController;
import main.casosClinicos.medicamentos.MedicamentosController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import sun.security.krb5.internal.NetClient;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Manages control flow for logins */
public class CasosManager {
    public final Scene scene;

    public CasosManager(Scene scene) {
        this.scene = scene;
    }

    /**
     * Callback method invoked to notify that a user has logged out of the main application.
     * Will show the main.authLinkedIn application screen.
     */

    //Función para abrir ventana
    public void showCasosScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("casos.fxml"));
            scene.setRoot((loader.load()));
            CasosController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Ej para cambio de ventana
    void showMedScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("medicamentos/medicamentos.fxml"));
            scene.setRoot(loader.load());
            MedicamentosController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void showExScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("examenes/examenes.fxml"));
            scene.setRoot(loader.load());
            ExamenesController controller = loader.getController();
            controller.initManager(this);
        } catch (IOException ex) {
            Logger.getLogger(CasosManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void guardarCaso(String text) {
        String url = URLName.getInstance() + "/CasosClinicos";
        String output = "{\"nombre\": \"" + text + "\"}";
        NetClientPost.NetClientPost(url, output);
    }
}

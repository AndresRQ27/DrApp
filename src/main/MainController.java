package main;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Created by andres on 20/05/17.
 * DrApp
 * main
 */
public class MainController {
    @FXML private Button nuevo;
    @FXML private Button buscar;
    @FXML private Button chat;
    @FXML private Button agenda;
    @FXML private Button citas;
    @FXML private Button calificaciones;

    public void initialize() {}

    public void initManager(final MainManager mainManager) {
        nuevo.setOnAction(event -> mainManager.showCasosScreen());

        buscar.setOnAction(event -> mainManager.showBusquedaScreen());

        chat.setOnAction(event -> mainManager.showChatScreen());

        citas.setOnAction(event -> mainManager.showCitasScreen());
    }
}

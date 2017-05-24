package main.busqueda;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainManager;

/**
 * Created by andres on 24/05/17.
 * DrApp
 * main.busqueda
 */
public class BusquedaController {
    @FXML private Button cancelar;
    @FXML private Button buscar;
    @FXML private TextField busqueda;

    public void initManager(final BusquedaManager busquedaManager){
        initManager(new MainManager(busquedaManager.scene), busquedaManager);
    }

    private void initManager(final MainManager mainManager, BusquedaManager busquedaManager){
        cancelar.setOnAction(event -> mainManager.showMainScreen());
    }
}

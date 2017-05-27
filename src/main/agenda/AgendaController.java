package main.agenda;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainManager;

/**
 * Created by andres on 27/05/17.
 * DrApp
 * main.agenda
 */
public class AgendaController {

    @FXML
    private Button cancelar;
    @FXML private Button b1;
    @FXML private Button b2;
    @FXML private Button b3;
    @FXML private Button b4;
    @FXML private TextField t1;
    @FXML private TextField t2;
    @FXML private TextField t3;
    @FXML private TextField t4;

    public void initManager(final AgendaManager agendaManager){initManager(agendaManager, new MainManager(agendaManager.scene));}

    private void initManager(final AgendaManager agendaManager, MainManager mainManager){
        cancelar.setOnAction(event -> mainManager.showMainScreen());

    }
}

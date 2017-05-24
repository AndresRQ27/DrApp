package main.chat;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.MainManager;


import java.awt.*;

/**
 * Created by andre on 22/5/2017.
 */
public class ChatController {

    @FXML private Button cancelar;
    @FXML private Button enviar;
    @FXML private TextField de;
    @FXML private TextField para;
    @FXML private javafx.scene.control.TextArea mensajeDe;
    @FXML private javafx.scene.control.TextArea mensajePara;

    public void initManager(final ChatManager chatManager){initManager(chatManager, new MainManager(chatManager.scene));}

    private void initManager(final ChatManager chatManager, MainManager mainManager){
        cancelar.setOnAction(event -> mainManager.showMainScreen());
        enviar.setOnAction(event -> imprimir());
    }

    private void imprimir(){}
}

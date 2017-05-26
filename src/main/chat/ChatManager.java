package main.chat;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by andres on 23/05/17.
 * DrApp
 * main.chat
 */
public class ChatManager {
    public final Scene scene;

    public ChatManager(Scene scene){this.scene = scene;}

    public void showChatScreen() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("chat.fxml"));
            scene.setRoot((loader.load()));
            ChatController controller = loader.getController();
            controller.initManager(this);
        }  catch (IOException ex) {
            Logger.getLogger(ChatManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

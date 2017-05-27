package authLinkedIn;

import java.io.IOException;
import java.util.logging.*;

import connection.SpecialNetClientPost;
import general.Data;
import general.URLName;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/** Manages control flow for logins */
public class LoginManager {
  public final Scene scene;

  public LoginManager(Scene scene) {
    this.scene = scene;
  }

  /**
   * Callback method invoked to notify that a user has been authenticated.
   * Will show the main application screen.
   */ 
  public void authenticated(String name, String user) {
    String output = "{\"nombre\":\""+ name + "\", \"correo\": \"" + user + "\"}";

    JSONArray jsonArray = SpecialNetClientPost.NetClientPost(URLName.getInstance() + "/Doctores", output);
    JSONObject jsonObject = (JSONObject) jsonArray.get(0);
    Data.id = ((Long) jsonObject.get("id")).intValue();
  }

  //Función para abrir ventana
  public void showLoginScreen() {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        scene.setRoot((loader.load()));
        LoginController controller = loader.getController();
        controller.initManager(this);

    }  catch (IOException ex) {
        Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}

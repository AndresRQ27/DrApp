package authLinkedIn;

import java.io.IOException;
import java.util.logging.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.*;

/** Manages control flow for logins */
class LoginManager {
  private final Scene scene;

  public LoginManager(Scene scene) {
    this.scene = scene;
  }

  /**
   * Callback method invoked to notify that a user has been authenticated.
   * Will show the main application screen.
   */ 
  public void authenticated(String sessionID) {
    showMainView(sessionID);
  }

  /**
   * Callback method invoked to notify that a user has logged out of the main application.
   * Will show the authLinkedIn application screen.
   */ 
  public void logout() {
    showLoginScreen();
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

  //Ej para cambio de ventana
  private void showMainView(String sessionID) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("mainview.fxml"));
      scene.setRoot(loader.load());
      MainViewController controller = loader.getController();
      controller.initSessionID(this, sessionID);
    } catch (IOException ex) {
      Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}

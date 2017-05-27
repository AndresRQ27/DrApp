package authLinkedIn;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import main.MainManager;

/** Controls the authLinkedIn screen */
public class LoginController {
  @FXML private TextField name;
  @FXML private TextField user;
  @FXML private TextField password;
  @FXML private Button loginButton;
  
  public void initialize() {}
  
  public void initManager(final LoginManager loginManager) {

    loginButton.setOnAction(event -> {
      loginManager.authenticated(name.getText(), user.getText());
      new MainManager(loginManager.scene).showMainScreen();
    });
  }
}

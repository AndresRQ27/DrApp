package authLinkedIn;

import java.io.IOException;

import general.ScreenSize;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/** Main application class for the authLinkedIn demo application */
public class LoginDemoApplication extends Application {

  public static void main(String[] args) { launch(args); }

  @Override
  public void start(Stage loginStage) throws IOException {
    loginStage.setTitle("DrApp");

    Scene scene = new Scene(new StackPane(), ScreenSize.getWidth(), ScreenSize.getHeight());

    LoginManager loginManager = new LoginManager(scene);
    loginManager.showLoginScreen();

    loginStage.setScene(scene);
    loginStage.show();
  }
}
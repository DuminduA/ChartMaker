package main.Controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.Main;

import java.io.IOException;

public class SceneController {


    public void graph() throws IOException {
        Stage primaryStage = new Stage();
        Controller.ControllerStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("main/Resources/graphs.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Chart Maker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

package main;

import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Platform.isSupported(ConditionalFeature.INPUT_METHOD);
        Main.stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Resources/Home.fxml"));
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Chart Maker");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static Stage getStage(){
        return Main.stage;
    }


    public static void main(String[] args) {
        launch(args);
    }
}

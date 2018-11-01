package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    public static Stage stage;

    @FXML
    public Button EnterButton;

    @FXML
    public Button chooseFileButton;

    @FXML
    public Label FileNameLabal;

    @FXML
    public LineChart chart;

    Map<Integer, Integer> data = new HashMap<>();
    String filelocation = "";

    public void clickEnter(){


    }

    public void clickChooseFileButton(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);


    }
}

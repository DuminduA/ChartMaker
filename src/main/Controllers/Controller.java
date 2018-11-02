package main.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Controller {

    public static Stage ControllerStage;

    @FXML
    public Button EnterButton;

    @FXML
    public Button chooseFileButton;

    @FXML
    public Label FileNameLabal;

    @FXML
    public LineChart chart;

    Map<String, String> data = new HashMap<>();
    String filelocation = "";


    public void clickEnter(){
//        SceneManager.getGraphs();
        ControllerStage = new Stage();
        ControllerStage.setTitle("Chart Name");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("X Axis");
        //creating the chart
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Title");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data

        for (Map.Entry<String, String> entry : data.entrySet())
        {
            try{
                Float X = Float.parseFloat(entry.getKey());
                Float Y = Float.parseFloat(entry.getValue());
                series.getData().add(new XYChart.Data(X, Y));
            }
            catch(Exception e){
                System.out.println("First Line");
            }
        }


        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        ControllerStage.setScene(scene);
        ControllerStage.show();

    }

    public void clickChooseFileButton(){
        FileChooser fileChooser = new FileChooser();
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            filelocation = selectedFile.getPath();
            FileNameLabal.setText(filelocation);

            try (Stream<String> stream = Files.lines(Paths.get(filelocation))) {

                stream.forEach((String line) -> {
                    String[]  list = (line.toString()).split(",");
                    data.put(list[0], list[1]);
                });

                System.out.println(data);

            } catch (IOException e) {
                System.out.println("No File Chosen");
            }
        }
    }
}

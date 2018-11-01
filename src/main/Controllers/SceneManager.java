package main.Controllers;

import java.io.IOException;

public class SceneManager {


    private static SceneController scene = new SceneController();

    public static void getGraphs(){
        try {
            scene.graph();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.eliassen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App extends Application
{

    @Override
    public void start(Stage stage) throws IOException
    {
        URL url = new File("/Github/Christmas-Project/MemoryMatch/src/main/resources/com/eliassen/hello-view.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        stage.setTitle("Christmas Memory Match");
        stage.setScene(new Scene(root));

        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }

}
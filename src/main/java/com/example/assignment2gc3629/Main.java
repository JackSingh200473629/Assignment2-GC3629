package com.example.assignment2gc3629;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("search-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 440);
        stage.setTitle("Search Books!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        //ApiResponse response = ApiUtility.getDataFromAPI("The Endless Lake");
        //System.out.println(response);
    }

}
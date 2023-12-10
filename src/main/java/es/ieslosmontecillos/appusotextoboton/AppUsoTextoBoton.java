package es.ieslosmontecillos.appusotextoboton;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppUsoTextoBoton extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // CONTENIDO NO RELEVANTE RESPECTO AL PROYECTO
        /*
        EventHandler recoge el evento a la subida
        scene.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            System.out.println("Click consumido");
            actionEvent.consume();
        });
        */
        /*
        EventFilter recoge el evento a la bajada
        scene.addEventFilter(ActionEvent.ACTION, actionEvent -> {
            System.out.println("Click consumido");
            actionEvent.consume();
        });
        */


        FXMLLoader fxmlLoader = new FXMLLoader(AppUsoTextoBoton.class.getResource("app-uso-texto-boton.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
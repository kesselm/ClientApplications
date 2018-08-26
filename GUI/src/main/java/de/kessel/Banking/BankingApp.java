package de.kessel.Banking;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @project ClientApplication
 */
public class BankingApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Button button = new Button();
        button.setText("CSV");
        button.setOnAction(event -> {
            try {
                BankingController.openFileChooser();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        primaryStage.setScene(new Scene(button, 400,400));
        primaryStage.show();
    }
}

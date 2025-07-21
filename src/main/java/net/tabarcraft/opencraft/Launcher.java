package net.tabarcraft.opencraft;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) {
        ContentView content = new ContentView();
        Scene scene = new Scene(content, 800, 600);
        OCUtils.applyCSS(scene);

        primaryStage.setTitle("Craftion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

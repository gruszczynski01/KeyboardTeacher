package keyboard_teacher;

import controllers.ScreensController;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;

public class Main extends Application {
    public static String screen1ID = "homeScreen";
    public static String screen1FXML = "Screen1.fxml";
    public static String screen2ID = "learningScreen";
    public static String screen2FXML = "Screen2.fxml";
    public static String screen3ID = "summaryScreen";
    public static String screen3FXML = "Screen3.fxml";





    @Override
    public void start(Stage primaryStage) throws Exception{
        ScreensController screensContainer = new ScreensController();
        screensContainer.loadScreen(Main.screen1ID, Main.screen1FXML);
        screensContainer.loadScreen(Main.screen2ID, Main.screen2FXML);
        screensContainer.loadScreen(Main.screen3ID, Main.screen3FXML);

        screensContainer.setScreen(Main.screen1ID);

        Group root = new Group();
        root.getChildren().addAll(screensContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("KeyboardTeacher - Gruszczyński Szymon - Allegro Summer E-xperience 2019");
        primaryStage.setResizable(false);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}

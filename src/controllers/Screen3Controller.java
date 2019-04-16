package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import keyboard_teacher.Main;

import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

public class Screen3Controller implements Initializable, IControlledScreen {

    ScreensController myController;

    @FXML
    private Button B_tryAgain;

    @FXML
    private Button B_changeText;

    @FXML
    private Label L_scoore;

    @FXML
    void onB_changeText(ActionEvent event) {

    }

    @FXML
    void onB_tryAgain(ActionEvent event) {

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Main.sessionTime = Duration.between(Main.start, Main.stop);
        //L_scoore.setText("Twój wynik to "+ Main.sessionTime + " znaków na minutę.");
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

}

package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import keyboard_teacher.Main;
import keyboard_teacher.TextCoordinator;

import java.io.FileNotFoundException;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.Scanner;

import static keyboard_teacher.TextCoordinator.*;

public class Screen3Controller implements Initializable, IControlledScreen {

    ScreensController myController;


    @FXML
    private Button B_tryAgain;

    @FXML
    private Button B_changeText;

    @FXML
    private AnchorPane AP_showResultPreScreen;

    @FXML
    private Button B_showResult;

    @FXML
    private Label L_scroore;

    @FXML
    private Label L_howManyMistakes;

    @FXML
    void onB_changeText(ActionEvent event) {
        ifFirstLine = true;
        try {
            mainScanner = new Scanner(selectedFile);
        } catch (FileNotFoundException e) {
            System.out.println("Something wrong with loading file again");
        }
        AP_showResultPreScreen.setVisible(true);
        totalSumOfMistakes = 0;
        myController.setScreen(Main.screen1ID);
    }

    @FXML
    void onB_showResult(ActionEvent event) {

        L_scroore.setText("Twoje tempo pisania to: " + charPerSeconds(setSessionTime(start, stop), totalSumOfCharacters) + " znaków na sekundę.");
        L_howManyMistakes.setText("Ilość popełnionych błędów: " + totalSumOfMistakes + ", całkowity czas: " + String.format("%.2f", setSessionTime(start, stop)) + "sek.");
        AP_showResultPreScreen.setVisible(false);

    }

    @FXML
    void onB_tryAgain(ActionEvent event) {
        //PORESETOWAC WIECEJ ZMIENNYCH - MOZE UBRAC TO W FUNKCJE
        ifFirstLine = true;
        try {
            mainScanner = new Scanner(selectedFile);
        } catch (FileNotFoundException e) {
            System.out.println("Something wrong with loading file again");
        }
        AP_showResultPreScreen.setVisible(true);
        totalSumOfMistakes = 0;
       // myController.loadScreen(Main.screen2ID, Main.screen2FXML);
        myController.setScreen(Main.screen2ID);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

}

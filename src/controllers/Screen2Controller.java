package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import keyboard_teacher.Main;
import keyboard_teacher.TextCoordinator;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.ResourceBundle;

import static keyboard_teacher.TextCoordinator.*;

public class Screen2Controller implements IControlledScreen, Initializable {

    ScreensController myController;
    static boolean ifStarted = false;

    @FXML
    private TextField TF_rewrittenText;

    @FXML
    private Label TF_errorNotification;


    @FXML
    private Text TF_textFromFile;

    @FXML
    public void onTF_rewrittenText(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER && !mainScanner.hasNextLine())
        {
            if (ifTextsAreTheSame()) {//DOBRZE
                actionsOnGoodAnswer();
                actionsOnLastLineGoodAnswered();
            } else {//ŹLE
                actionsOnBadAnswer();
            }
        }
        if (event.getCode() == KeyCode.ENTER && !ifFirstLine) {
            if (mainScanner.hasNextLine() || lastGoodAnswer == false) {

                if (ifTextsAreTheSame()) {//DOBRZE
                    actionsOnGoodAnswer();
                } else {//ŹLE
                    actionsOnBadAnswer();
                }
            } else {
                actionsOnLastLineGoodAnswered();

            }
        }
        //checking if its a first line
        if (event.getCode() == KeyCode.ENTER && ifFirstLine) {
            actionsOnFirstLine();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        TF_errorNotification.setText("");
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    public void resetFields(){
        TF_errorNotification.setText("");
        TF_rewrittenText.setText("");
    }
    public boolean ifTextsAreTheSame(){
        System.out.println("file...." + TF_textFromFile.getText() + "....");
        System.out.println("user...." + TF_rewrittenText.getText() + "....");
        System.out.println("SAME: " + TF_rewrittenText.getText().equals(TF_textFromFile.getText()));
        return TF_rewrittenText.getText().equals(TF_textFromFile.getText());
    }
    public void actionsOnGoodAnswer(){
        totalSumOfCharacters += howManyCharacters(TF_rewrittenText.getText());
        resetFields();
        lastGoodAnswer = true;
        if(mainScanner.hasNextLine()) {
            TF_textFromFile.setText(mainScanner.nextLine());
        }
    }
    public void actionsOnBadAnswer(){
        TF_errorNotification.setText("BŁĄD W ZNAKU O INDEKSIE " + indexOfMistake(TF_textFromFile.getText(), TF_rewrittenText.getText()) + ". Popraw błąd i spróbuj ponownie");
        //POKOLOROWANIE STRINGA - opcjonalnie

        totalSumOfMistakes++;
        lastGoodAnswer = false;
    }
    public void actionsOnLastLineGoodAnswered(){
        TextCoordinator.stop = Instant.now();
        myController.setScreen(Main.screen3ID);
    }
    public void actionsOnFirstLine(){
        TF_textFromFile.setText(mainScanner.nextLine());//setting new line from file
        TextCoordinator.start = Instant.now();//starting time counting
        ifFirstLine = false;//changing flag after first line setted
        TF_rewrittenText.setEditable(true);
        //lastGoodAnswer = false;
    }


}

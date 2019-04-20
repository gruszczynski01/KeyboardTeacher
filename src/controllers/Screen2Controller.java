package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import keyboard_teacher.Main;
import keyboard_teacher.TextCoordinator;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.Instant;
import java.util.ResourceBundle;
import java.util.Scanner;

import static keyboard_teacher.TextCoordinator.*;

public class Screen2Controller implements IControlledScreen, Initializable {

    ScreensController myController;

    @FXML
    private TextField TF_rewrittenText;

    @FXML
    private Label TF_errorNotification;


    @FXML
    private Text TF_textFromFile;

    @FXML
    private Button B_cancel;

    @FXML
    private Text TF_goodRewrittenText;

    @FXML
    void onB_cancel(ActionEvent event) {
        ifFirstLine = true;
        try {
            mainScanner = new Scanner(selectedFile);
        } catch (FileNotFoundException e) {
            System.out.println("Something wrong with loading file again");
        }
        resetFields();
        TF_rewrittenText.setEditable(false);
        TF_textFromFile.setText("WCIŚNIJ ENTER ABY ROZPOCZĄĆ, WYŚWIETLI SIĘ TEKST TO PRZEPISANIA ORAZ URUCHOMIONY ZOSTANIE STOPER.");
        totalSumOfMistakes = 0;
        myController.setScreen(Main.screen1ID);

    }


    @FXML
    public void onTF_rewrittenText(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER && !mainScanner.hasNextLine())
        {
            if (ifTextsAreTheSame()) {//GOOD
                actionsOnGoodAnswer();
                actionsOnLastLineGoodAnswered();
            } else {//ŹLE
                actionsOnBadAnswer();
            }
        }
        if (event.getCode() == KeyCode.ENTER && !ifFirstLine) {
            if (mainScanner.hasNextLine() || lastGoodAnswer == false) {

                if (ifTextsAreTheSame()) {//GOOD
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
        TF_textFromFile.setStyle("-fx-fill: black;");
        TF_goodRewrittenText.setText("");
    }
    public boolean ifTextsAreTheSame(){
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
        TF_goodRewrittenText.setText(TF_textFromFile.getText().substring(0, indexOfMistake(TF_textFromFile.getText(), TF_rewrittenText.getText())));
        TF_textFromFile.setStyle("-fx-fill: red;");
        totalSumOfMistakes++;
        lastGoodAnswer = false;
    }
    public void actionsOnLastLineGoodAnswered(){
        TextCoordinator.stop = Instant.now();
        resetFields();
        TF_rewrittenText.setEditable(false);
        TF_textFromFile.setText("WCIŚNIJ ENTER ABY ROZPOCZĄĆ, WYŚWIETLI SIĘ TEKST TO PRZEPISANIA ORAZ URUCHOMIONY ZOSTANIE STOPER.");
        myController.setScreen(Main.screen3ID);

    }
    public void actionsOnFirstLine(){
        TF_textFromFile.setText(mainScanner.nextLine());//setting new line from file
        TextCoordinator.start = Instant.now();//starting time counting
        ifFirstLine = false;//changing flag after first line setted
        TF_rewrittenText.setEditable(true);
    }


}

package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import keyboard_teacher.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen2Controller implements IControlledScreen, Initializable {

    ScreensController myController;

    @FXML
    private TextField TF_rewrittenText;

    @FXML
    private Text TF_textFromFile;

    @FXML
    public void onTF_rewrittenText(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            //to do sth
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try{
            System.out.println("Linia z tekstu: " + Main.mainScanner.nextLine());
            //TF_textFromFile.setText(Main.mainScanner.nextLine());
        }catch (Exception e){
            e.getMessage();
        }

    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}

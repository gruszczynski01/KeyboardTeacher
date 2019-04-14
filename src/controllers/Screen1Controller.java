package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Screen1Controller  implements IControlledScreen, Initializable
{
    //public File selectedFile;

    ScreensController myController;

    @FXML
    private TextField tf_path;

    @FXML
    private Button B_select_file;

    @FXML
    private Label LabelError;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //to do after constructor
    }

    @FXML
    void onWybierz(ActionEvent event) {

//        FileChooser fc = new FileChooser();
//        selectedFile = fc.showOpenDialog(null);
//        if(selectedFile != null) {
//            try {
//                tf_path.setText(selectedFile.getPath());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }else{
//            System.out.println("File is not valid");
//        }
    }

    @FXML
    void onZaczynajmy(MouseEvent event) {

    }


    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
}

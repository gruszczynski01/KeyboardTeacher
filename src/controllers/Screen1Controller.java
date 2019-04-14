package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import keyboard_teacher.Main;
;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Screen1Controller  implements IControlledScreen, Initializable
{


    ScreensController myController;


    @FXML
    private TextField TF_path;

    @FXML
    private Button B_choosePath;

    @FXML
    private Button B_start;

    @FXML
    private Label TF_errorNotification;

    @FXML
    void onB_choosePath(ActionEvent event) {
        //String empty = "";
        //TF_errorNotification.
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TXT files (*.TXT)", "*.TXT"),
                new FileChooser.ExtensionFilter("txt files (*.txt)", "*.txt"));
        Main.selectedFile = fc.showOpenDialog(null);
        if(Main.selectedFile != null) {
            try {
                TF_path.setText(Main.selectedFile.getPath());
                System.out.println(Main.selectedFile.getPath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("File is not valid");
        }
    }

    @FXML
    void onB_start(ActionEvent event) {
        //sprawdzanko pliku
        try {
            Main.selectedFile = new File(TF_path.getText());
            Main.mainScanner = new Scanner(Main.selectedFile);
        } catch (Exception e) {
            TF_errorNotification.setText("Wskazany plik nie istnieje lub nie może zostać otworzony");
        }
        if (Main.selectedFile != null) {
            try {
                System.out.println("FILE EXTENSION: " + getFileExtension(Main.selectedFile));
                if (Main.selectedFile.exists() && getFileExtension(Main.selectedFile).equals(".txt")) {
                    myController.setScreen(Main.screen2ID);
                } else {
                    TF_errorNotification.setText("Wskazany plik nie istnieje lub nie jest plikiem z rozszerzeniem .TXT, wybierz inny plik");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File is not valid");
        }
    }

    @FXML
    void onTF_path(ActionEvent event) {

    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //to do after constructor
    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }
    private static String getFileExtension(File file) {
        String extension = "";

        try {
            if (file != null && file.exists()) {
                String name = file.getName();
                extension = name.substring(name.lastIndexOf("."));
            }
        } catch (Exception e) {
            extension = "";
        }

        return extension;

    }


}

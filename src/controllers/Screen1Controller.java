package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import keyboard_teacher.Main;
import controllers.Screen2Controller;
import keyboard_teacher.TextCoordinator;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import static keyboard_teacher.TextCoordinator.mainScanner;
import static keyboard_teacher.TextCoordinator.selectedFile;


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
        selectedFile = fc.showOpenDialog(null);
        if(selectedFile != null) {
            try {
                TF_path.setText(selectedFile.getPath());
                System.out.println(selectedFile.getPath());
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
            selectedFile = new File(TF_path.getText());
            mainScanner = new Scanner(selectedFile);
        } catch (Exception e) {
            TF_errorNotification.setText("Wskazany plik nie istnieje lub nie może zostać otworzony");
        }
        if (selectedFile != null) {
            try {
                //System.out.println("FILE EXTENSION: " + getFileExtension(selectedFile));
                if (selectedFile.exists() && getFileExtension(selectedFile).equals(".txt")) {
                    TF_errorNotification.setText("");
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
        //screenParent.myTestFunction(Main.mainScanner.nextLine());
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

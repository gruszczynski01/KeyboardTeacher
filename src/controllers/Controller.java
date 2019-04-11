package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


public class Controller {

    @FXML
    private TextField tf_path;

    @FXML
    void onWybierz(MouseEvent event) {
        System.out.println(tf_path.getText());
    }

    @FXML
    void onZaczynajmy(MouseEvent event) {

    }

}

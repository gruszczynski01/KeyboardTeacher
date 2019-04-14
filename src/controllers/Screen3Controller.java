package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class Screen3Controller implements Initializable, IControlledScreen {

    ScreensController myController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void setScreenParent(ScreensController screenParent) {
        myController = screenParent;
    }

    public void onB_tryAgain(ActionEvent actionEvent) {
    }

    public void onB_changeText(ActionEvent actionEvent) {
    }
}

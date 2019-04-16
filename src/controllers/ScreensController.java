package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.HashMap;

public class ScreensController extends StackPane {

    private HashMap<String, Node> screens = new HashMap<>();

    public ScreensController() {
        super();
    }


    public void addScreen(String name, Node screen){
        screens.put(name, screen);
    }
    public Node getScreen(String name){
        return screens.get(name);
    }

    public boolean loadScreen(String name, String resource)
    {
        //loads fxml to loader
        FXMLLoader myFXMLLoader = new FXMLLoader(getClass().getResource(resource));
        try {
            Parent loadScreen = myFXMLLoader.load();
            IControlledScreen myScreenController = (IControlledScreen) myFXMLLoader.getController();
            myScreenController.setScreenParent(this);
            addScreen(name, loadScreen);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean setScreen(final String name){
        if(screens.get(name) != null){//any screen is loaded in the collections
            if(!getChildren().isEmpty()){ //any screen is already displayed
                getChildren().remove(0);
                getChildren().add(0, screens.get(name));
            }else{//no screen displayed
                getChildren().add(screens.get(name));
            }
            return true;
        }else{
            System.out.println("Something went wrong, screen hasnt been loaded!");
            return false;
        }
    }
    public boolean unloadScreen(String name){
        if(screens.remove(name) == null)
        {
            System.out.println("Screen doesnt exist");
            return false;
        }else{
            return true;
        }
    }

}

package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.VegetableController;
import chiefcook.chiecook_coursework.mainMenu.MainMenu;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    private VegetableController vegetableController;
    private SaladController saladController;
    private MainMenu mainMenu;

    @FXML
    private AnchorPane acnhorPane;

    @FXML
    private Button addIgredientBtn;

    @FXML
    private AnchorPane anchorPane2;

    @FXML
    private Button calculateTotalCaloriesBtn;

    @FXML
    private Button clearSaladBtn;

    @FXML
    private Label label;

    @FXML
    private Button removeIngredientBtn;

    @FXML
    private Button sortVegetablesBtn;

    @FXML
    private Button viewAvailableVegetablesBtn;

    @FXML
    private Button viewSaladBtn;

    @FXML
    private Button viewVegetablesWithCaloriesInRangeBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vegetableController = MainMenuApplication.vegetableController;
        saladController = MainMenuApplication.saladController;
        mainMenu = MainMenuApplication.mainMenu;

        viewAvailableVegetablesBtn.setOnAction(event -> {
            mainMenu.execute("vegetables", new ArrayList<String>());
        });
    }
}

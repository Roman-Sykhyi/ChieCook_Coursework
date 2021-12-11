package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.VegetableController;
import chiefcook.chiecook_coursework.controllers.CommandsController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    private VegetableController vegetableController;
    private SaladController saladController;
    private CommandsController commandsController;

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
    private Button removeIngredientBtn;

    @FXML
    private Button sortVegetablesBtn;

    @FXML
    private Button viewAvailableVegetablesBtn;

    @FXML
    private Button viewSaladBtn;

    @FXML
    private Button viewVegetablesWithCaloriesInRangeBtn;

    @FXML
    private Button exitBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vegetableController = MainMenuApplication.vegetableController;
        saladController = MainMenuApplication.saladController;
        commandsController = MainMenuApplication.commandsController;

        viewAvailableVegetablesBtn.setOnAction(event -> {
            commandsController.execute("vegetables");
        });

        viewSaladBtn.setOnAction(event -> {
            commandsController.execute("viewSalad");
        });

        addIgredientBtn.setOnAction(event -> {
            commandsController.execute("addVegetable");
        });

        removeIngredientBtn.setOnAction(event -> {
            commandsController.execute("removeVegetable");
        });

        calculateTotalCaloriesBtn.setOnAction(event -> {
            commandsController.execute("calculateCalories");
        });

        viewVegetablesWithCaloriesInRangeBtn.setOnAction(event -> {
            commandsController.execute("viewVegetablesWithCaloriesInRange");
        });

        clearSaladBtn.setOnAction(event -> saladController.createSalad());

        exitBtn.setOnAction(event -> System.exit(0));
    }
}
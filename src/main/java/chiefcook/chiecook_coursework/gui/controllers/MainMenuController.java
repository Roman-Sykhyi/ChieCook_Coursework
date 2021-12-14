package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.CommandsController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    private static final Logger LOG = Logger.getLogger(MainMenuController.class.getSimpleName());

    private SaladController saladController;
    private CommandsController commandsController;

    @FXML
    private Button addIgredientBtn;

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
        saladController = MainMenuApplication.saladController;
        commandsController = MainMenuApplication.commandsController;

        viewAvailableVegetablesBtn.setOnAction(event -> {
            commandsController.execute("vegetables");
            LOG.info("User clicks ViewAvailableVegetables button. Executing \"vegetables\" command");
        });

        viewSaladBtn.setOnAction(event -> {
            commandsController.execute("viewSalad");
            LOG.info("User clicks ViewSalad button. Executing \"viewSalad\" command");
        });

        addIgredientBtn.setOnAction(event -> {
            commandsController.execute("addVegetable");
            LOG.info("User clicks AddIngredient button. Executing \"addVegetable\" command");
        });

        removeIngredientBtn.setOnAction(event -> {
            commandsController.execute("removeVegetable");
            LOG.info("User clicks RemoveIngredient button. Executing \"removeVegetable\" command");
        });

        calculateTotalCaloriesBtn.setOnAction(event -> {
            commandsController.execute("calculateCalories");
            LOG.info("User clicks CalculateTotalCalories button. Executing \"calculateCalories\" command");
        });

        viewVegetablesWithCaloriesInRangeBtn.setOnAction(event -> {
            commandsController.execute("viewVegetablesWithCaloriesInRange");
            LOG.info("User clicks ViewVegetablesWithCaloriesInRange button. Executing \"viewVegetablesWithCaloriesInRange\" command");
        });

        sortVegetablesBtn.setOnAction(event -> {
            commandsController.execute("sortVegetables");
            LOG.info("User clicks SortVegetables button. Executing \"sortVegetables\" command");
        });

        clearSaladBtn.setOnAction(event -> {
            saladController.createSalad();
            LOG.info("User clicks ClearSalad button. Creating new empty salad");
        });

        exitBtn.setOnAction(event -> {
            LOG.info("User clicks Exit button. Exiting program");
            System.exit(0);
        });
    }
}
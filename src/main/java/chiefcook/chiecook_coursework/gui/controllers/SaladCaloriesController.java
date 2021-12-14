package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class SaladCaloriesController implements Initializable {

    private static final Logger LOG = Logger.getLogger(SaladCaloriesController.class.getSimpleName());

    private SaladController saladController;

    @FXML
    private Label caloriesText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saladController = MainMenuApplication.saladController;

        caloriesText.setText(saladController.getSaladCalories().toString());
        LOG.info("User calculated salad calories");
    }
}

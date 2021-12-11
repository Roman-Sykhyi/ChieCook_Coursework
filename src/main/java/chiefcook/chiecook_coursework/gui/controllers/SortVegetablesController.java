package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.models.Salad;
import chiefcook.chiecook_coursework.models.Vegetable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SortVegetablesController implements Initializable {

    private SaladController saladController;

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Button sortBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saladController = MainMenuApplication.saladController;
        sortBtn.setOnAction(event -> sortVegetables());

        ObservableList<String> list = FXCollections.observableArrayList("назва", "вага", "калорії");
        comboBox.setItems(list);
    }

    private void sortVegetables() {
        String type = comboBox.getValue();

        switch (type) {
            case "назва":
                saladController.sortIngredientsByName();
                showWindow(type);
                break;
            case "вага":
                saladController.sortIngredientsByWeight();
                showWindow(type);
                break;
            case "калорії":
                saladController.sortIngredientsByCalories();
                showWindow(type);
                break;
        }
    }

    private void showWindow(String type) {
        Stage stage = (Stage)comboBox.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText("Овочі в салаті посортовано за параметром [" + type + "]");
        alert.getDialogPane().setHeaderText("Успіх");

        alert.showAndWait();
    }
}

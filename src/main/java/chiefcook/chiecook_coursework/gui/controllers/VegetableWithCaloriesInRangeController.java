package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.models.Vegetable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class VegetableWithCaloriesInRangeController implements Initializable {

    private SaladController saladController;

    @FXML
    private TextField leftBoundInputField;

    @FXML
    private TextField rightBoundInputField;

    @FXML
    private Button showBtn;

    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saladController = MainMenuApplication.saladController;
        showBtn.setOnAction(event -> showVegetablesWithCaloriesInRange());
    }

    private void showVegetablesWithCaloriesInRange() {
        listView.getItems().clear();

        if(!leftBoundInputField.getText().matches("^[0-9]*$") || leftBoundInputField.getText().equals("")) {
            warnIncorrectInput("Неправильно введені дані лівої межі. Вводіть цілі числа");
            leftBoundInputField.setText("");
            return;
        }

        if(!rightBoundInputField.getText().matches("^[0-9]*$") || rightBoundInputField.getText().equals("")) {
            warnIncorrectInput("Неправильно введені дані правої межі. Вводіть цілі числа");
            rightBoundInputField.setText("");
            return;
        }

        double leftBound = Double.parseDouble(leftBoundInputField.getText());
        double rightBound = Double.parseDouble(rightBoundInputField.getText());

        if(leftBound >= rightBound) {
            warnIncorrectInput("Ліва межа не може бути більшою за праву");
            leftBoundInputField.setText("");
            rightBoundInputField.setText("");
            return;
        }

        List<Vegetable> items = saladController.getVegetablesWithCaloriesInRange(leftBound, rightBound);

        for (Vegetable item : items) {
            listView.getItems().add(item.getName() + " калорії = " + item.getCalories());
        }
    }

    private void warnIncorrectInput(String message) {
        Stage stage = (Stage)showBtn.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.WARNING, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().setHeaderText("Помилка");

        alert.showAndWait();
    }
}

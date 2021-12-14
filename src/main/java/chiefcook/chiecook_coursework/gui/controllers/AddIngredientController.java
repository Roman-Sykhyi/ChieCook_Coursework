package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.VegetableController;
import chiefcook.chiecook_coursework.models.Vegetable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class AddIngredientController implements Initializable {

    private static final Logger LOG = Logger.getLogger(AddIngredientController.class.getSimpleName());

    private VegetableController vegetableController;
    private SaladController saladController;

    @FXML
    private Button addBtn;

    @FXML
    private ComboBox<Vegetable> comboBox;

    @FXML
    private Label label;

    @FXML
    private TextField weightInputField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vegetableController = MainMenuApplication.vegetableController;
        saladController = MainMenuApplication.saladController;

        addBtn.setOnAction(event -> {
            addIngredient();
        });

        weightInputField.focusedProperty().addListener((arg0, oldValue, newValue) -> {
            if (!newValue) {
                if(!weightInputField.getText().matches("^[0-9]*$")){
                    weightInputField.setText("");
                }
            }
        });

        ObservableList<Vegetable> list = FXCollections.observableArrayList(vegetableController.getVegetables());
        comboBox.setItems(list);
    }

    private void addIngredient() {
        Vegetable vegetable = comboBox.getValue();
        double weight;

        try {
            weight = Double.parseDouble(weightInputField.getText());
            saladController.addIngredient(vegetable, weight);

            String message = weight + " грам " + vegetable.getName() + " додано до салату";
            showDialogWindow(message, Alert.AlertType.INFORMATION);
            LOG.info("User added " + weight + " grams of " + vegetable.getName() + " to salad");
        } catch (NumberFormatException e) {
            showDialogWindow("Помилка зчитування ваги. Вводіть ціле число.", Alert.AlertType.ERROR);
        } catch (NullPointerException e) {
            showDialogWindow("Ви не вибрали овоч", Alert.AlertType.ERROR);
        }
    }

    private void showDialogWindow(String message, Alert.AlertType type) {
        Stage stage = (Stage)label.getScene().getWindow();

        Alert alert = new Alert(type, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText(message);
        if(type == Alert.AlertType.ERROR)
            alert.getDialogPane().setHeaderText("Помилка");
        else
            alert.getDialogPane().setHeaderText("Успіх");

        alert.showAndWait();
    }
}

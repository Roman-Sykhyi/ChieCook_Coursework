package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
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

import org.apache.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class RemoveVegetableController implements Initializable {

    private static final Logger LOG = Logger.getLogger(RemoveVegetableController.class.getSimpleName());

    private SaladController saladController;

    @FXML
    private ComboBox<Vegetable> comboBox;

    @FXML
    private Button removeBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saladController = MainMenuApplication.saladController;

        updateComboBox();

        removeBtn.setOnAction(event -> {
            removeIngredient();
        });
    }

    private void updateComboBox() {
        ObservableList<Vegetable> list = FXCollections.observableArrayList(saladController.getVegetables());
        comboBox.setItems(list);
    }

    private void removeIngredient() {
        Vegetable vegetable = comboBox.getValue();

        if(vegetable == null) {
            Stage stage = (Stage)comboBox.getScene().getWindow();

            Alert alert = new Alert(Alert.AlertType.WARNING, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setContentText("Ви не вибрали інгредієнт");
            alert.getDialogPane().setHeaderText("Помилка");

            alert.showAndWait();
            return;
        }

        saladController.removeIngredient(vegetable.getName());

        Stage stage = (Stage)comboBox.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "");

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(stage);

        alert.getDialogPane().setContentText(vegetable.getName() + " видалено з салату");
        alert.getDialogPane().setHeaderText("Помилка");

        alert.showAndWait();

        updateComboBox();

        LOG.info("User removed " + vegetable.getName() + " from salad");
    }
}

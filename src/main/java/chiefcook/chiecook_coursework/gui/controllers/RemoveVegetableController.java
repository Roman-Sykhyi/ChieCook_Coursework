package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.commands.RemoveVegetableCommand;
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
    private Button backBtn;

    @FXML
    private Button removeBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saladController = MainMenuApplication.saladController;

        ObservableList<Vegetable> list = FXCollections.observableArrayList(saladController.getVegetables());
        comboBox.setItems(list);

        removeBtn.setOnAction(event -> {
            if(removeIngredient())
                closeWindow();
        });
        backBtn.setOnAction(event -> closeWindow());
    }

    private boolean removeIngredient() {
        Vegetable vegetable = comboBox.getValue();

        if(vegetable == null) {
            Stage stage = (Stage)comboBox.getScene().getWindow();

            Alert alert = new Alert(Alert.AlertType.WARNING, "");

            alert.initModality(Modality.APPLICATION_MODAL);
            alert.initOwner(stage);

            alert.getDialogPane().setContentText("Ви не вибрали інгредієнт");
            alert.getDialogPane().setHeaderText("Помилка");

            alert.showAndWait();

            return false;
        }

        saladController.removeIngredient(vegetable.getName());
        LOG.info("User removed " + vegetable.getName() + " from salad");
        return true;
    }

    private void closeWindow() {
        Stage stage = (Stage)backBtn.getScene().getWindow();
        stage.close();
    }
}

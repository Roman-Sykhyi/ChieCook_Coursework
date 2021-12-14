package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.VegetableController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ViewAvailableVegetablesController implements Initializable {

    private static final Logger LOG = Logger.getLogger(ViewAvailableVegetablesController.class.getSimpleName());

    private VegetableController vegetableController;

    @FXML
    private Label label;

    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vegetableController = MainMenuApplication.vegetableController;

        List<String> items = Arrays.asList(vegetableController.getVegetablesInfo().split("\n"));

        for (String item : items) {
            listView.getItems().add(item);
        }

        LOG.info("User views available vegetables list");
    }
}

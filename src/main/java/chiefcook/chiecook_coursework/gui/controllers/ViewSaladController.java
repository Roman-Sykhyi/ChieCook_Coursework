package chiefcook.chiecook_coursework.gui.controllers;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ViewSaladController implements Initializable {

    private static final Logger LOG = Logger.getLogger(ViewSaladController.class.getSimpleName());

    private SaladController saladController;

    @FXML
    private Label label;

    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        saladController = MainMenuApplication.saladController;

        List<String> items = Arrays.asList(saladController.getSaladInfo().split("\n"));

        for (String item : items) {
            listView.getItems().add(item);
        }

        LOG.info("User views salad");
    }
}

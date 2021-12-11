package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class SortVegetablesCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(SortVegetablesCommand.class.getSimpleName());

    public final static String NAME = "sortVegetables";

    @Override
    public void execute() {
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("sort-salad.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 486, 224);
            stage.setScene(scene);
            stage.showAndWait();

            LOG.info("User sort vegetables in salad");
        } catch (Exception e) {
            LOG.error("Error opening SortVegetables window");
            LOG.error(e.getMessage());

            e.printStackTrace();
        }
    }
}

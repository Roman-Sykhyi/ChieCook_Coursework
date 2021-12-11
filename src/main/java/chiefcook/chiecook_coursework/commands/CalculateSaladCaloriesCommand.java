package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.apache.log4j.Logger;

public class CalculateSaladCaloriesCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(CalculateSaladCaloriesCommand.class.getSimpleName());

    public final static String NAME = "calculateCalories";

    @Override
    public void execute() {
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("salad-calories.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 168);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            LOG.error("Error opening SaladCalories window");
            LOG.error(e.getMessage());

            e.printStackTrace();
        }

        LOG.info("User calculating salad calories");
    }
}

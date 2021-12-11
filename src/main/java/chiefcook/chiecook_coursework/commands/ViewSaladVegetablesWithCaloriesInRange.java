package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.apache.log4j.Logger;

public class ViewSaladVegetablesWithCaloriesInRange implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewSaladVegetablesWithCaloriesInRange.class.getSimpleName());

    public final static String NAME = "viewVegetablesWithCaloriesInRange";

    @Override
    public void execute() {
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("vegetables-with-calories-in-range.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 322);
            stage.setScene(scene);
            stage.showAndWait();
            LOG.info("User views vegetables in salad with calories in range");

        } catch (Exception e) {
            LOG.error("Error opening ViewVegetablesWithCaloriesInRange window");
            LOG.error(e.getMessage());

            e.printStackTrace();
        }
    }
}

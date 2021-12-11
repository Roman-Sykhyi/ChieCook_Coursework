package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.apache.log4j.Logger;

public class ViewSaladCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewSaladCommand.class.getSimpleName());

    public static final String NAME = "viewSalad";

    @Override
    public void execute() {
        LOG.info("User views salad");

        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("view-salad.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 300);
            stage.setScene(scene);
            stage.showAndWait();

            LOG.info("User views available vegetables");
        } catch (Exception e) {
            LOG.error("Error opening ViewAvailableVegetables window");
            LOG.error(e.getMessage());

            e.printStackTrace();
        }
    }
}

package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.apache.log4j.Logger;

public class ViewAvailableVegetablesCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewAvailableVegetablesCommand.class.getSimpleName());

    public final static String NAME = "vegetables";

    @Override
    public void execute() {
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("view-vegetables.fxml"));
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

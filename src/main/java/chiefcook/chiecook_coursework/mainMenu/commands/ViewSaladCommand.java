package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.mainMenu.MainMenu;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.util.List;

public class ViewSaladCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewSaladCommand.class.getSimpleName());

    public static final String NAME = "viewSalad";

    private SaladController saladController;

    public ViewSaladCommand(SaladController saladController) {
        this.saladController = saladController;
    }

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

    @Override
    public String getHelp() {
        return "Shows salad ingredients\nUse: \'viewSalad\' with no parameters";
    }
}

package chiefcook.chiecook_coursework.mainMenu.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.VegetableController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.util.List;

public class ViewAvailableVegetablesCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(ViewAvailableVegetablesCommand.class.getSimpleName());

    public final static String NAME = "vegetables";

    private VegetableController vegetableController;

    public ViewAvailableVegetablesCommand(VegetableController vegetableController) {
        this.vegetableController = vegetableController;
    }

    @Override
    public void execute(List<String> params) {
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

    @Override
    public String getHelp() {
        return "Shows list of all available vegetables\nUse: \'vegetables\' with no parameters";
    }
}

package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.VegetableController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class AddVegetableCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(AddVegetableCommand.class.getSimpleName());

    public final static String NAME = "addVegetable";

    @Override
    public void execute() {
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("add-ingredients.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 214);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            LOG.error("Error opening AddIngredient window");
            LOG.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
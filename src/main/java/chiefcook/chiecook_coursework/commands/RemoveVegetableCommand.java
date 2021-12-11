package chiefcook.chiecook_coursework.commands;

import chiefcook.chiecook_coursework.MainMenuApplication;
import chiefcook.chiecook_coursework.controllers.SaladController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class RemoveVegetableCommand implements IMenuCommand {
    private static final Logger LOG = Logger.getLogger(RemoveVegetableCommand.class.getSimpleName());

    public final static String NAME = "removeVegetable";

    private SaladController saladController;

    public RemoveVegetableCommand(SaladController saladController) {
        this.saladController = saladController;
    }

    @Override
    public void execute() {
        /*System.out.println("Removing vegetable from salad");

        try {
            saladController.removeIngredient(params.get(0));
            LOG.info("User removed " + params.get(0) + " from salad");
            System.out.println(params.get(0) + " removed from salad");
        } catch (Exception e) {
            LOG.error("Error removing vegetable from salad");
            LOG.error(e.getMessage());
            System.out.println("Error removing vegetable from salad");
        }*/

        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);

            FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("remove-ingredient.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 246);
            stage.setScene(scene);
            stage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getHelp() {
        return "Remove vegetable from salad\nUse: \'removeVegetable [name]\'";
    }
}

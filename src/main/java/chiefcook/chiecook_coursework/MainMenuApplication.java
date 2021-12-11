package chiefcook.chiecook_coursework;

import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.VegetableController;
import chiefcook.chiecook_coursework.controllers.CommandsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuApplication extends Application {

    public static VegetableController vegetableController;
    public static SaladController saladController;
    public static CommandsController commandsController;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setResizable(false);

        FXMLLoader fxmlLoader = new FXMLLoader(MainMenuApplication.class.getResource("main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 640);
        stage.setTitle("Chief Cook");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        vegetableController = new VegetableController();
        saladController = new SaladController();
        commandsController = new CommandsController(vegetableController, saladController);
        launch();
    }
}
package chiefcook.chiecook_coursework.mainMenu;

import chiefcook.chiecook_coursework.controllers.SaladController;
import chiefcook.chiecook_coursework.controllers.VegetableController;
import chiefcook.chiecook_coursework.mainMenu.commands.*;

import org.apache.log4j.Logger;

import java.util.*;

public class MainMenu {
        private static final Logger LOG = Logger.getLogger(MainMenu.class.getSimpleName());

        private Map<String, IMenuCommand> commands;
        private Scanner scanner = new Scanner(System.in);

        public MainMenu(VegetableController vegetableController, SaladController saladController) {
                commands = new LinkedHashMap<>();

                commands.put(ViewAvailableVegetablesCommand.NAME, new ViewAvailableVegetablesCommand(vegetableController));
                commands.put(CreateSaladCommand.NAME, new CreateSaladCommand(saladController));
                commands.put(ViewSaladCommand.NAME, new ViewSaladCommand(saladController));
                commands.put(AddVegetableCommand.NAME, new AddVegetableCommand(vegetableController, saladController));
                commands.put(RemoveVegetableCommand.NAME, new RemoveVegetableCommand(saladController));
                commands.put(CalculateSaladCaloriesCommand.NAME, new CalculateSaladCaloriesCommand(saladController));
                commands.put(SortVegetablesCommand.NAME, new SortVegetablesCommand(saladController));
                commands.put(ViewSaladVegetablesWithCaloriesInRange.NAME, new ViewSaladVegetablesWithCaloriesInRange(saladController));
                commands.put(ExitCommand.NAME, new ExitCommand());
        }
}
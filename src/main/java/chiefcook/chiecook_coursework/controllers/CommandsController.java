package chiefcook.chiecook_coursework.controllers;

import chiefcook.chiecook_coursework.commands.*;

import org.apache.log4j.Logger;

import java.util.*;

public class CommandsController {
        private static final Logger LOG = Logger.getLogger(CommandsController.class.getSimpleName());

        private Map<String, IMenuCommand> commands;
        private Scanner scanner = new Scanner(System.in);

        public CommandsController(VegetableController vegetableController, SaladController saladController) {
                commands = new LinkedHashMap<>();

                commands.put(ViewAvailableVegetablesCommand.NAME, new ViewAvailableVegetablesCommand(vegetableController));
                commands.put(CreateSaladCommand.NAME, new CreateSaladCommand(saladController));
                commands.put(ViewSaladCommand.NAME, new ViewSaladCommand(saladController));
                commands.put(AddVegetableCommand.NAME, new AddVegetableCommand(vegetableController, saladController));
                commands.put(RemoveVegetableCommand.NAME, new RemoveVegetableCommand(saladController));
                commands.put(CalculateSaladCaloriesCommand.NAME, new CalculateSaladCaloriesCommand(saladController));
                commands.put(SortVegetablesCommand.NAME, new SortVegetablesCommand(saladController));
                commands.put(ViewSaladVegetablesWithCaloriesInRange.NAME, new ViewSaladVegetablesWithCaloriesInRange(saladController));
        }

        public void execute(String command) {
                IMenuCommand menuCommand = commands.get(command);

                if(menuCommand == null) {
                        LOG.error("Error executing command");
                        LOG.error("Command " + command + " not found");
                        return;
                }

                menuCommand.execute();
        }
}
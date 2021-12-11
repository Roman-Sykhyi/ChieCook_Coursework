package chiefcook.chiecook_coursework.controllers;

import chiefcook.chiecook_coursework.commands.*;

import org.apache.log4j.Logger;

import java.util.*;

public class CommandsController {
        private static final Logger LOG = Logger.getLogger(CommandsController.class.getSimpleName());

        private Map<String, IMenuCommand> commands;
        private Scanner scanner = new Scanner(System.in);

        public CommandsController() {
                commands = new LinkedHashMap<>();

                commands.put(ViewAvailableVegetablesCommand.NAME, new ViewAvailableVegetablesCommand());
                commands.put(ViewSaladCommand.NAME, new ViewSaladCommand());
                commands.put(AddVegetableCommand.NAME, new AddVegetableCommand());
                commands.put(RemoveVegetableCommand.NAME, new RemoveVegetableCommand());
                commands.put(CalculateSaladCaloriesCommand.NAME, new CalculateSaladCaloriesCommand());
                commands.put(SortVegetablesCommand.NAME, new SortVegetablesCommand());
                commands.put(ViewSaladVegetablesWithCaloriesInRange.NAME, new ViewSaladVegetablesWithCaloriesInRange());
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
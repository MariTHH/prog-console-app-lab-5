package commands;

import client.InputManager;
import collection.PersonCollection;
import commands.availableCommands.*;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CommandManager {
    
    private final PersonCollection personCollection;
    private final InputManager inputManager;
    private static boolean isWorking = true;
    private static HashMap<String, Command> commandMap = new HashMap();

    static {
        commandMap = new HashMap<>();
        commandMap.put("add", new Add());
        commandMap.put("add_if_max", new AddIfMax());
        commandMap.put("add_if_min", new AddIfMin());
        commandMap.put("clear", new Clear());
        commandMap.put("remove_by_id", new RemoveById());
        commandMap.put("show", new Show());
        commandMap.put("removeGreater", new RemoveGreater());
        commandMap.put("countGreater", new CountGreaterThanEyeColor());
        commandMap.put("update", new Update());
        commandMap.put("filter_greater_than_location", new FilterGreaterThanLocation());
        commandMap.put("print_unique_location", new PrintUniqueLocation());
        commandMap.put("info", new Info());
        commandMap.put("help", new Help());
    }

    public static HashMap<String, Command> getCommandMap() {
        return commandMap;
    }

    public static void setPersonCollection(PersonCollection personCollection) {
        CommandManager.personCollection = personCollection;
    }

    public static PersonCollection getPersonCollection() {
        return CommandManager.personCollection;
    }

    public void existCommand(String[] name) {
        try {
            if (name.length > 0) {
                Command command = commandMap.get(name[0]);
                command.execute(name);
            } else {
                System.out.println("Вы не ввели команду");
            }
        } catch (IllegalStateException | NullPointerException e) {
            if (name[0].equals("")) {
                System.out.println("Команды " + name[0] + " не существует");
            }
        }
    }
}

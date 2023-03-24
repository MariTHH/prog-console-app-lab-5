package commands.availableCommands;

import commands.Command;
import commands.CommandManager;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ExecuteScript extends Command {
    private HashMap<String, Command> commandMap;
    private ArrayList<String> filePaths;


    public ExecuteScript() {
        this.commandMap = CommandManager.getCommandMap();
        this.filePaths = new ArrayList<>();
    }

    @Override
    public void execute(String[] args) throws JAXBException, IOException {
        if (args.length > 2) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            filePaths.add((String) getArgument());
            ArrayList<String> commandList = new ArrayList<>();

            try (Scanner reader = new Scanner(new FileInputStream((String) getArgument()))) {

                while (reader.hasNextLine()) {
                    String line = reader.nextLine().trim();
                    commandList.add(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
            }

            for (String command : commandList) {
                while (command.contains("  "))
                    command = command.replaceAll("  ", " ");

                String[] commandAndArgument = command.split(" ");
                String argument;

                if (commandAndArgument.length == 1)
                    argument = null;
                else if (commandAndArgument.length == 2)
                    argument = commandAndArgument[1];
                else {
                    System.out.println("Введите комманду и аргумент, если нужно");
                    return;
                }

                if (commandMap.containsKey(commandAndArgument[0])) {
                    if (commandAndArgument[0].equals("execute_script")) {
                        if (filePaths.contains(commandAndArgument[1])) {
                            System.out.println("Файл содержит рекурсию!!");
                            continue;
                        }
                    }
                    commandMap.get(commandAndArgument[0]).setArgument(argument);
                    commandMap.get(commandAndArgument[0]).execute(commandAndArgument);
                } else {
                    System.out.println("Команды " + commandAndArgument[0] + " не существует");
                }
            }
            filePaths.remove(getArgument());
        }
    }
}

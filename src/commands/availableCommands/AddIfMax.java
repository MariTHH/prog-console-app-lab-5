package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

import java.util.Scanner;

/**
 * add_if_max {element} :
 * add a new element to a collection if its value exceeds the value of the largest element of that collection
 */
public class AddIfMax extends Command {
    private PersonCollection personCollection;

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            Scanner sc = new Scanner(System.in);
            personCollection.addIfMax(sc);
            System.out.println("Персонаж добавлен");
        }
    }
}

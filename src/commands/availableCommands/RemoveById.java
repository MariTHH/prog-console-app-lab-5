package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

/**
 * Command remove_by_id id : remove an item from the collection by its id
 */
public class RemoveById extends Command {
    public static void remove_by_id(String arg) {
        try {
            int ID = Integer.parseInt(arg);
            if (PersonCollection.existID(ID)) {
                PersonCollection.removePerson(ID);
                System.out.println("Персонаж удален");
            } else {
                System.out.println("Этого персонажа не существует");
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы неправильно ввели команду");
        }
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            RemoveById.remove_by_id(args[1]);
        }
    }
}


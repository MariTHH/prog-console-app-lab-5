package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

/**
 * info :
 * output to the standard output stream information about the collection
 * (type, initialization date, number of items, etc.)
 */
public class Info extends Command {
    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            PersonCollection.info();
        }
    }
}

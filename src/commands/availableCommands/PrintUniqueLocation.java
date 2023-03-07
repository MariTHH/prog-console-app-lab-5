package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

/**
 * print_unique_location : print the unique values of the location field of all items in the collection
 */
public class PrintUniqueLocation extends Command {

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            PersonCollection.printUniqueLocation();
        }
    }
}

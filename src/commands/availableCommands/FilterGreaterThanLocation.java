package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

/**
 * filter_greater_than_location location :
 * display elements whose location field value is greater than the given one
 */
public class FilterGreaterThanLocation extends Command {
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            PersonCollection.filterGreater(args[1]);
        }
    }
}

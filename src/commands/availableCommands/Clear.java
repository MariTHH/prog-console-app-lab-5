package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

/**
 * Command clear : clear the collection
 */
public class Clear extends Command {
    private Clear receiver;

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            receiver.clear();
        }
    }

    public void clear() {
        PersonCollection.clearCollection();
        System.out.println("Коллекция очищена");
    }
}

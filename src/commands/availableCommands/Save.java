package commands.availableCommands;

import collection.PersonCollection;
import commands.Command;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public class Save extends Command {
    private final PersonCollection collection;

    public Save(PersonCollection collection) {
        this.collection = collection;
    }

    @Override
    public void execute(String[] args) throws JAXBException, IOException {
        if (args.length > 1) {
            System.out.println("Вы неправильно ввели команду");
            System.out.println(collection);
        } else {
            collection.save();

        }
    }
  
}

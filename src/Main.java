import collection.PersonCollection;
import commands.CommandManager;

import java.util.Scanner;
import java.util.TreeSet;

import comparator.HeightComparator;

public class Main {
    public static void main(String[] args) throws JAXBException, IOException {
        PersonCollection collection = new PersonCollection();
        new CommandManager(collection);
        while (CommandManager.getWork()) {
            CommandManager.existCommand();
        }
    }
}

import collection.PersonCollection;
import commands.CommandManager;

import java.util.Scanner;
import java.util.TreeSet;

import comparator.HeightComparator;

public class Main {
    public static void main(String[] args) {

        PersonCollection collection = new PersonCollection();
        CommandManager.setPersonCollection(collection);
        PersonCollection.initializeCollection();
        Scanner sc = new Scanner(System.in);
        CommandManager commandManager = new CommandManager();
        CommandManager.existCommand(new String[]{"add"});
        CommandManager.existCommand(new String[]{"help"});
    }
}

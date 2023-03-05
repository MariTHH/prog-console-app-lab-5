package commands.availableCommands;

import client.ClientManager;
import collection.PersonCollection;
import commands.*;

import java.util.Scanner;

/**
 * Command add {element} : add a new element to the collection
 */
public class Add extends Command {
    private Add recevier;

    @Override
    public void execute(String[] args) {
        if (args.length != 0) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            Scanner sc = new Scanner(System.in);
            recevier.add(sc);
        }
    }

    public void add(Scanner sc) {
        PersonCollection.addPerson(ClientManager.getNewPerson(sc));
        System.out.println("Ваш персонаж теперь в коллекции");
    }

}

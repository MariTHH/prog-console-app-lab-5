import collection.PersonCollection;
import commands.CommandManager;

import java.util.Scanner;
import java.io.IOException;
import java.util.TreeSet;

import javax.xml.bind.JAXBException;

import static collection.Parser.convertToJavaObject;

public class Main {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        try {
            Scanner scanner = new Scanner(System.in);
            String Path = scanner.nextLine();
            File file = new File(String.valueOf(Path));
            PersonCollection collection = new PersonCollection();
            collection.setCollection(convertToJavaObject(file).getCollection());
            new CommandManager(collection);
            while (CommandManager.getWork()) {
                CommandManager.existCommand();
            }
        } catch (JAXBException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Приложение не может запуститься");

        }
    }
}

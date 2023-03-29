import collection.PersonCollection;
import commands.CommandManager;

import java.io.*;
import java.util.Scanner;

import javax.xml.bind.JAXBException;

import static collection.Parser.convertToJavaObject;

/**
 * Main class starts the application
 */
public class Main {
    public static void main(String[] args) throws IOException, IllegalArgumentException {
        try {
            System.out.println("Введите название файла из которого будет взята коллекция");
            Scanner scanner = new Scanner(System.in);
            String Path = scanner.nextLine();
            File file = new File(String.valueOf(Path));
            PersonCollection collection = new PersonCollection();
            collection.setCollection(convertToJavaObject(file).getCollection());
            new CommandManager(collection);
            while (CommandManager.getWork()) {
                CommandManager.existCommand();
            }
        } catch (JAXBException | IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.out.println("Приложение не может запуститься");

        }
    }
}

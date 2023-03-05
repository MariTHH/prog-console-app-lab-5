package client;

import commands.*;
import data.*;

import java.util.HashMap;
import java.util.Scanner;

/**
 * The class is responsible for creating the character
 */
public class ClientManager {
    private static HashMap<String, Command> commandMap;
    private static Scanner scanner;

    static {
        commandMap = CommandManager.getCommandMap();
        scanner = new Scanner(System.in);

    }

    public static Person getNewPerson(Scanner sc) {
        String name = ReadManager.readName(sc);
        Long X = ReadManager.readCoordinatesX(sc);
        Integer Y = ReadManager.readCoordinatesY(sc);
        Double X2 = ReadManager.readLocationX(sc);
        Float Y2 = ReadManager.readLocationY(sc);
        String location = ReadManager.readLocationName(sc);
        Integer height = ReadManager.readHeight(sc);
        Color eyeColor = ReadManager.readColor(sc);
        Color hairColor = ReadManager.readColor(sc);
        Country nationality = ReadManager.readCountry(sc);


        return new Person(name, new Coordinates(X, Y), height, eyeColor, hairColor, nationality, new Location(X2, Y2, location));
    }
}

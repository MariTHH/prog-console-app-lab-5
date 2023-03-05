package client;

import data.Color;
import data.Country;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The class is responsible for what the user enters
 */
public class ReadManager {
    public static String readName(Scanner sc) {
        System.out.println("Введите имя персонажа ");
        String name = sc.nextLine().trim();
        while (true) {
            if (name.equals("")) {
                System.out.println("Имя не может быть пустой строкой, введите имя");
                name = sc.nextLine().trim();
            } else {
                return name;
            }
        }
    }
}

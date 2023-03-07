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
            } else if (!name.matches("^[a-zA-Z]*$")) {
                System.out.println("Имя не может быть иными знаками кроме букв");
                name = sc.nextLine().trim();
            } else {
                return name;
            }
        }
    }
    
    public static Long readCoordinatesX(Scanner sc) {
        System.out.println("Введите координату X");
        while (true) {
            try {
                String X_string = sc.nextLine().trim();
                long X = Long.parseLong(X_string);
                if (!X_string.equals("")) {
                    return X;
                } else {
                    System.out.println("Вы должны ввести число, а не пустую строку");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }
        }
    }

    public static Integer readCoordinatesY(Scanner sc) {
        System.out.println("Введите координату Y");
        while (true) {
            try {
                String Y_string = sc.nextLine().trim();
                int Y = Integer.parseInt(Y_string);
                if (Y_string.equals("")) {
                    return Y;
                } else {
                    System.out.println("Вы должны ввести число, а не пустую строку");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }
        }
    }
    
    public static Integer readHeight(Scanner sc) {
        System.out.println("Введите рост персонажа");
        while (true) {
            String height_string = sc.nextLine().trim();
            try {
                int height = Integer.parseInt(height_string);
                if (height > 0) {
                    return height;
                } else {
                    System.out.println("Рост должен быть больше 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }
        }
    }
    
    public static String readLocationName(Scanner sc) {
        System.out.println("Введите название локации");
        String location = sc.nextLine().trim();
        if (location.length() >= 944 || location.equals("")) {
            while (location.length() >= 944) {
                System.out.println("Слишком длинное название");
                location = sc.nextLine().trim();
            }
            while (location.equals("")) {
                System.out.println("Название не может быть пустой строкой");
                location = sc.nextLine().trim();
            }
        }
        return location;
    }

    public static Double readLocationX(Scanner sc) {
        System.out.println("Введите координату X");
        while (true) {
            try {
                String X_s = sc.nextLine().trim();
                double X = Double.parseDouble(X_s);
                if (!X_s.equals("")) {
                    return X;
                } else {
                    System.out.println("Значение не должно быть пустым. Попробуйте ещё раз.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введённое значение не является числом. Попробуйте еще раз.");
            }
        }
    }

    public static Float readLocationY(Scanner sc) {
        System.out.println("Введите координату Y");
        while (true) {
            try {
                String Y_s = sc.nextLine().trim();
                float Y = Float.parseFloat(Y_s);
                if (Y_s.equals("")) {
                    return Y;
                } else {
                    System.out.println("Вы должны ввести число, а не пустую строку");
                }
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели не число");
            }
        }
    }
    
    public static boolean doesThisColorTypeExist(String colors) {
        for (Color ourColor : Color.values()) {
            if (ourColor.name().equals(colors)) {
                return true;
            }
        }
        return false;
    }

    public static Color readColor(Scanner sc) {
        System.out.println("Выберите любой цвет из предложенных" + Arrays.asList(Color.values()));
        String type = sc.nextLine().trim();
        if (!doesThisColorTypeExist(type) || type.equals("")) {
            while (!doesThisColorTypeExist(type)) {
                System.out.println("Такого цвета нет, выберите один из предложенных");
                type = sc.nextLine().trim();
                doesThisColorTypeExist(type);
            }
        }
        return Enum.valueOf(Color.class, type);
    }
    
    public static boolean doesThisCountryTypeExist(String test) {
        for (Country c : Country.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    public static Country readCountry(Scanner sc) {
        System.out.println("Выберите любую страну из предложенных" + Arrays.asList(Country.values()));
        String type = sc.nextLine().trim();
        if (!doesThisCountryTypeExist(type) || type.equals("")) {
            while (!doesThisCountryTypeExist(type)) {
                System.out.println("Такой страны нет, выберите одну из предложенных");
                type = sc.nextLine().trim();
                doesThisCountryTypeExist(type);
            }
        }
        return Enum.valueOf(Country.class, type);
    }
    
}

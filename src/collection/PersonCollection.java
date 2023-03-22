package collection;

import client.ClientManager;
import data.Person;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.TreeSet;

import static java.time.LocalDate.*;

/**
 * A class that implements collection related methods
 */

public class PersonCollection {
    private static TreeSet<Person> treeSet = new TreeSet<>();
    private static Date creationDate = new Date();
    
    public PersonCollection(TreeSet<Person> treeSet, String filename) {
        this.treeSet = treeSet;
        this.filename = filename;
    }
    
    public PersonCollection() {
    }

    public static void initializeCollection() {
        if (treeSet == null) {
            treeSet = new TreeSet<>();
            creationDate = now();
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }
    
    
    public static TreeSet<Person> getCollection() {
        return treeSet;
    }

     public static void addPerson(Person person) {
        treeSet.add(person);
    }
    
     public static void personInfo(Person person) {
        System.out.println("ID: " + person.getId());
        System.out.println("Имя персонажа: " + person.getName());
        System.out.println("Координаты: X=" + person.getCoordinates().getX() + ", Y=" + person.getCoordinates().getY());
        System.out.println("Время создания: " + person.getCreationDate());
        System.out.println("Рост: " + person.getHeight());
        System.out.println("Цвет глаз: " + person.getEyeColor());
        System.out.println("Цвет волос: " + person.getHairColor());
        System.out.println("Страна: " + person.getNationality());
        System.out.println("Локация: " + person.getCoordinates().getX() + person.getCoordinates().getY() + person.getName());
    }
    
        public static void information() {
        if (treeSet == null) {
            System.out.println("В коллекции ничего нет");
        } else
            for (Person person : treeSet) {
                PersonCollection.personInfo(person);
            }
    }

        public void addIfMin(Scanner sc) {
        Person person = ClientManager.getNewPerson(sc);
        if (treeSet == null) {
            addPerson(person);
        } else {
            for (Person person1 : treeSet) {
                if (person1.compareTo(person) > 0) {
                    addPerson(person);
                } else {
                    System.out.println("Персонаж не может быть добавлен");
                }
            }
        }
    }

        public void addIfMax(Scanner sc) {
        Person person = ClientManager.getNewPerson(sc);
        if (treeSet == null) {
            addPerson(person);
        } else {
            for (Person person1 : treeSet) {
                if (person1.compareTo(person) < 0) {
                    addPerson(person);
                } else {
                    System.out.println("Персонаж не может быть добавлен");
                }
            }
        }
    }
    
        public static void clearCollection() {
        treeSet.clear();
    }
    
        public static boolean existID(int ID) {
        for (Person person : PersonCollection.getCollection()) {
            if (person.getId() == ID) {
                return true;
            }
        }
        return false;
    }

        public static void removePerson(int ID) {
        for (Person person : treeSet) {
            if (existID(ID)) {
                treeSet.remove(person);
                break;
            }
        }
    }

        public static void updateElement(Person newPerson, int ID) {
        for (Person person : treeSet) {
            if (person.getId() == ID) {
                person.setName(newPerson.getName());
                person.setCoordinates(newPerson.getCoordinates());
                person.setCreationDate(newPerson.getCreationDate());
                person.setHeight(newPerson.getHeight());
                person.setEyeColor(newPerson.getEyeColor());
                person.setHairColor(newPerson.getHairColor());
                person.setNationality(newPerson.getNationality());
                person.setLocation(newPerson.getLocation());
            }
        }
    }

        public void removeGreater(Scanner sc) {
        Person newPerson = ClientManager.getNewPerson(sc);
        for (Person person : treeSet) {
            if (person.getHeight() > newPerson.getHeight()) {
                treeSet.remove(person);
            }
        }
    }
    
    
    public static void countEyeColor(int code) {
        int count = 1;
        for (Person person : treeSet) {
            if (person.getEyeColor().getCode() == code) {
                count += 1;
            }
            System.out.println(count);
        }
    }
    
    private static final ArrayList<Double> uniq = new ArrayList<>();

    public static void printUniqueLocation() {
        for (Person person : treeSet) {
            double X = person.getLocation().getX();
            if (!uniq.contains(X)) {
                uniq.add(X);
            } else {
                uniq.remove(X);
            }
        }
        System.out.println(uniq);
    }
    
       public static void filterGreater(String xString) {
        double x = Double.parseDouble(xString);
        try {
            for (Person person : treeSet) {
                if (person.getLocation().getX() > x) {
                    System.out.println(person.getName() + " : " + person.getLocation().getX());
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы неправильно ввели данные");
        }
    }
    
    public static void info() {
        System.out.println(treeSet.getClass().getName() + " " + PersonCollection.creationDate + " " + treeSet.size());
    }
}

    public static void help() {
        System.out.println("add {element} : добавить новый элемент в коллекцию \n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции \n" +
                "add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции \n" +
                "clear : очистить коллекцию \n" +
                "count_greater_than_eye_color eyeColor : вывести количество элементов, значение поля eyeColor которых больше заданного \n" +
                "filter_greater_than_location location : вывести элементы, значение поля location которых больше заданного \n" +
                "help : вывести справку по доступным командам \n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов) \n" +
                "print_unique_location : вывести уникальные значения поля location всех элементов в коллекции \n" +
                "remove_by_id id : удалить элемент из коллекции по его id \n" +
                "remove_greater {element} : удалить из коллекции все элементы, превышающие заданный \n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении \n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному"
        );
    }
}


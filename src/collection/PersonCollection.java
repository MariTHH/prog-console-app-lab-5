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
    private static TreeSet<Person> treeSet;
    private static LocalDate creationDate;

    public static void initializeCollection() {
        if (treeSet == null) {
            treeSet = new TreeSet<>();
            creationDate = now();
        }
    }

    public LocalDate getCreationDate() {
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

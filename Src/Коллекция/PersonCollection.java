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
}

   public TreeSet<Person> getTreeSet() {
        return treeSet;
    }

    public static void addPerson(Person person) {
        treeSet.add(person);
    }

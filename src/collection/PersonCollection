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

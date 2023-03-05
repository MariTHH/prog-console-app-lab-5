import data.*;


import java.util.Comparator;
import java.util.TreeSet;

import comparator.HeightComparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Person> personComparator = new HeightComparator(); // sorting check
        TreeSet<Person> persons = new TreeSet(personComparator);
        persons.add(new Person("Tom", new Coordinates(2, 3), 165, Color.BLACK, Color.BLACK, Country.CHINA, new Location(2.0, 4, "place1")));
        persons.add(new Person("Tom1", new Coordinates(88, 88), 8000, Color.BLACK, Color.BLACK, Country.CHINA, new Location(4.0, 5, "place")));

        for (Person p : persons) {
            System.out.println(p.getHeight() + " " + p.getName());
        }
    }
}
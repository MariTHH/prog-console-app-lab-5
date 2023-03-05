package data;

import collection.GenerationId;

import java.time.LocalDate;

public class Person {
    private int id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDate creationDate;
    private int height;
    private Color eyeColor;
    private Color hairColor;
    private Country nationality;
    private Location location;


    public Person(String name, Coordinates coordinates, int height, Color eyeColor, Color hairColor, Country nationality, Location location) {
        this.id = GenerationId.generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = java.time.LocalDate.now();
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }


}

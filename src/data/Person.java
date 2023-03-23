package data;

import collection.GenerationId;
import com.sun.istack.NotNull;

import javax.xml.bind.annotation.*;
import java.time.ZonedDateTime;

public class Person implements Comparable<Person> {
    private final int id;
    @XmlElement(
            name = "name",
            required = true
    )
    @NotNull
    private String name;
    @XmlElement(
            name = "coordinates",
            required = true
    )
    @NotNull
    private Coordinates coordinates;
    @XmlTransient
    private ZonedDataTime creationDate;
    @XmlElement(
            name = "height",
            required = true
    )
    private int height;
    @XmlElement(
            name = "eyeColor",
            required = true
    )
    private Color eyeColor;
    @XmlElement(
            name = "hairColor",
            required = true
    )
    private Color hairColor;
    @XmlElement(
            name = "nationality",
            required = true
    )
    private Country nationality;
    @XmlElement(
            name = "location",
            required = true
    )
    private Location location;
    
    public Person() {
        this.id = GenerationId.generateID();
        this.creationDate = ZonedDateTime.now();
    }

    public Person(String name, Coordinates coordinates, int height, Color eyeColor, Color hairColor, Country nationality, Location location) {
        this.id = GenerationId.generateID();
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = ZonedDataTime.now();
        this.height = height;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.nationality = nationality;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDate getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getEyeColor() {
        return this.eyeColor;
    }

    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    public Color getHairColor() {
        return this.hairColor;
    }

    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    public Country getNationality() {
        return this.nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int compareTo(Person person) { // height comparison
        if (this.height - person.getHeight() > 0) {
            return 1;
        } else {
            if (this.height - person.getHeight() == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }
    
}

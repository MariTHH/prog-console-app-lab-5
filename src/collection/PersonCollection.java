package collection;

import client.ClientManager;
import data.Person;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


/**
 * A class that implements collection related methods
 */
@XmlRootElement(
        name = "persons"
)
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonCollection {
    @XmlElement(name = "Person")
    private String filename = "s";
    private static TreeSet<Person> treeSet = new TreeSet<>();
    private static Date creationDate = new Date();
    
    public PersonCollection(TreeSet<Person> treeSet, String filename) {
        this.treeSet = treeSet;
        this.filename = filename;
    }
    
    public PersonCollection() {
    }


    public Date getCreationDate() {
        return creationDate;
    }
    
    /**
     *
     * @return
     */
    public static TreeSet<Person> getCollection() {
        return treeSet;
    }
    /**
     *adds Person
     * @param person
     */
    public static void addPerson(Person person) {
        treeSet.add(person);
    }
    /**
     * displays information about the character with all fields
     * @param person
     */
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
    /**
     * displays information about each person
     */
    public void information() {
        if (treeSet.isEmpty()) {
            System.out.println("В коллекции ничего нет");
        } else
            for (Person person : treeSet) {
                personInfo(person);
            }
    }
    /**
     * adds a person if he is lower than the other
     * @param sc
     */
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
    
    /**
     * adds a person if he is higher than the other
     * @param sc
     */
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
    /**
     * clears the collection
     */ 
    public static void clearCollection() {
        treeSet.clear();
    }
    /**
     *
     * @param ID could be int
     * @return
     */ 
    public static boolean existID(int ID) {
        for (Person person : PersonCollection.getCollection()) {
            if (person.getId() == ID) {
                return true;
            }
        }
        return false;
    }
    /**
     * removes person
     * @param ID
     */
    public static void removePerson(int ID) {
        for (Person person : treeSet) {
            if (existID(ID)) {
                treeSet.remove(person);
                break;
            }
        }
    }
    /**
     * updates data of person, ID stays the same
     * @param newPerson
     * @param ID
     */
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
    /**
     *removes the highest person
     * @param sc
     */
    public void removeGreater(Scanner sc) {
        Person newPerson = ClientManager.getNewPerson(sc);
        boolean flag = true;
        for (Person person : treeSet) {
            if (person.getHeight() > newPerson.getHeight()) {
                treeSet.remove(person);
                System.out.println("Персонажы удалены: " + person.getName());
            } else {
                flag = false;
            }
        }
        if (!flag) {
            System.out.println("Персонаж выше всех");
        }
    }
    
    /**
     *counter of persons whose color code is greater
     * @param code
     */
    public static void countEyeColor(int code) {
        int count = 0;
        for (Person person : treeSet) {
            if (person.getEyeColor().getCode() == code) {
                count += 1;
            }
        }
        System.out.println(count);
    }
    
    private static final ArrayList<Double> uniq = new ArrayList<>();
    /**
     *print a not repeated location
     */
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
    /**
     * filter of persons whose coordinate is greater
     * @param xString
     */
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
    /**
     *print info about collection
     */
    public static void info() {
        System.out.println(treeSet.getClass().getName() + " " + PersonCollection.creationDate + " " + treeSet.size());
    }

    /**
     *print information about available commands
     */
    public static void help() {

        System.out.println("""
                add {element} : добавить новый элемент в коллекцию\s
                add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\s
                add_if_min {element} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции\s
                clear : очистить коллекцию\s
                count_greater_than_eye_color eyeColor : вывести количество элементов, значение поля eyeColor которых больше заданного\s
                filter_greater_than_location location : вывести элементы, значение поля location которых больше заданного\s
                save : сохранить коллекцию в файл\s
                execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
                help : вывести справку по доступным командам\s
                info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов)\s
                print_unique_location : вывести уникальные значения поля location всех элементов в коллекции\s
                remove_by_id id : удалить элемент из коллекции по его id\s
                remove_greater {element} : удалить из коллекции все элементы, превышающие заданный\s
                show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\s
                update id {element} : обновить значение элемента коллекции, id которого равен заданному"""
        );
    }
        
    /**
     * set collection
     *
     * @param treeSet
     */
    public void setCollection(TreeSet<Person> treeSet) {

        for (Person person : treeSet) {
            person.setName(person.getName());
            person.setNationality(person.getNationality());
            person.setCoordinates(person.getCoordinates());
            person.setEyeColor(person.getEyeColor());
            person.setHairColor(person.getHairColor());
            person.setLocation(person.getLocation());
            person.setHeight(person.getHeight());
        }

        this.treeSet = treeSet;
    }
    
    /**
     * saves collection to file XML
     *
     * @throws JAXBException
     * @throws IOException
     */
    public void save() throws JAXBException, IOException {
        try {
            Parser.convertToXML(this, filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл для сохранения не найден");
        }
    }
}


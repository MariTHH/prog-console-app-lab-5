package collection;

import java.util.HashSet;
import java.util.Random;

/**
 * A class that creates a unique id for each character
 */
public class GenerationId {

    private static final HashSet<Integer> arg = new HashSet<>();

    public static int generateID() {
        int id = new Random().nextInt();
        if (arg.contains(id)) {
            while (arg.contains(id)) {
                id = new Random().nextInt();
            }
        } else {
            arg.add(id);
        }
        return id;
    }
}

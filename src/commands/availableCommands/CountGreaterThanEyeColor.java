package commands.availableCommands;

import client.ReadManager;
import collection.PersonCollection;
import commands.Command;
import data.Color;

/**
 * count_greater_than_eye_color eyeColor :
 * display the number of elements whose eyeColor field value is greater than the set value
 */
public class CountGreaterThanEyeColor extends Command {
    private final PersonCollection personCollection;

    public CountGreaterThanEyeColor (PersonCollection personCollection) {
        this.personCollection = personCollection;
    }
    
    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            System.out.println("Вы неправильно ввели команду");
        } else {
            countGreater(args[1]);
        }
    }

    public static void countGreater(String eyeColor_s) {
        int code;
        try {
            if (ReadManager.doesThisColorTypeExist(eyeColor_s)) {
                code = Enum.valueOf(Color.class, eyeColor_s).getCode();
                PersonCollection.countEyeColor(code);
            } else {
                System.out.println("Такого цвета нет в списке");
            }
        } catch (NumberFormatException e) {
            System.out.println("Вы неправильно ввели команду");
        }
    }
}

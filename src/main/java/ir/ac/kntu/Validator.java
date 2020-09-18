package ir.ac.kntu;


import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * @author AliAfshar
 */

public final class Validator {

    public static boolean checkName(String name) {
        if (name.length()>2){
            return true;
        }
        return false;
    }


    public static boolean checkIranianNationalCode(String input) {
        if (!input.matches("^\\d{10}$"))
            return false;
        int check = Integer.parseInt(input.substring(9, 10));
        int sum = IntStream.range(0, 9)
                .map(x -> Integer.parseInt(input.substring(x, x + 1)) * (10 - x))
                .sum() % 11;
        return (sum < 2 && check == sum) || (sum >= 2 && check + sum == 11);
    }

    private Validator() {
    }
}

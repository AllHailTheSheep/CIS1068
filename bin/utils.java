package bin;
import java.util.Scanner;

public class utils {
    static final boolean DEBUG = true;

    // begin input functions
    public static String get_input(String prompt, Scanner in) {
        /**
        * This function returns a string after prompting the user
        * if the input is not understood the function will re-run
        * @param prompt the promps to be presented to the user
        * @param in the pre-initialized scanner to read input from
        * @return the string the user inputed
        */
        System.out.print(prompt);
        String result;
        try {
            result = in.nextLine();
        } catch (Exception e) {
            if (DEBUG) {
                System.out.println(e);
            } else {
                System.out.println("That didn't work, are you sure you entered a string?");
            }
            result = get_input(prompt, in);
        }
        return result;
    }

    public static int get_int_input(String prompt, Scanner in) {
        /**
        * This function returns an int after prompting the user
        * if the input is not an int the function will re-run
        * @param prompt to be presented to user
        * @param in the pre-initialized scanner to read input from
        * @return the input the user entered as an int
        */
        System.out.print(prompt);
        int result;
        try {
            result = in.nextInt();
        } catch (Exception e) {
            if (DEBUG) {
                System.out.println(e);
            } else {
                System.out.println("That didn't work, are you sure you entered an integer?");
            }
            result = get_int_input(prompt, in);
        }
        return result;
    }

    public static double get_double_input(String prompt, Scanner in) {
        /**
        * This function returns a double after prompting the user
        * if the input is not a double the function will re-run
        * @param prompt the promps to be presented to user
        * @param in the pre-initialized scanner to read input from
        * @return the input the user entered as a double
        */
        System.out.print(prompt);
        double result;
        try {
            result = in.nextDouble();
        } catch (Exception e) {
            if (DEBUG) {
                System.out.println(e);
            } else {
                System.out.println("That didn't work, are you sure you entered a double?");
            }
            result = get_double_input(prompt, in);
        }
        return result;
    }

    // begin string functions
    public static String capitalize(String str) {
        /** This function return the string passed in with the first character capitalized
        * @param str the string to capitalize
        * @return the capitalized string
        */
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
package xenoteo.com.github.day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return the input string
     */
    public static String readInputString(URL path){
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            String input = scanner.nextLine();
            scanner.close();
            return input;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return the map of rules
     */
    public static Map<String, String> readRules(URL path){
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            Map<String, String> rules = new HashMap<>();

            scanner.nextLine();
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String[] rule = scanner.nextLine().split(" -> ");
                rules.put(rule[0], rule[1]);
            }

            scanner.close();
            return rules;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

}

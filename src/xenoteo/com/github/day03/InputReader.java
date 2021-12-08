package xenoteo.com.github.day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    /**
     * Reads binary numbers to the long array from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to a long array
     */
    public static List<Long> readBinaryToLongArray(URL path){
        try {
            List<Long> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                input.add(Long.parseLong(scanner.nextLine(), 2));
            }
            scanner.close();
            return input;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

}

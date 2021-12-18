package xenoteo.com.github.day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to the list
     */
    public static List<Integer> readToList(URL path){
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            String line = scanner.nextLine();
            scanner.close();
            return Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}

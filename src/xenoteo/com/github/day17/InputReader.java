package xenoteo.com.github.day17;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return two ranges stored in a 2D array (the first is for x positions, the second is for y positions)
     */
    public static int[][] readRanges(URL path){
        try {
            int[][] ranges = new int[2][2];
            Scanner scanner = new Scanner(new File(path.getFile()));
            String line = scanner.nextLine();
            ranges[0][0] = Integer.parseInt(line.substring(line.indexOf("x=") + 2, line.indexOf("..")));
            ranges[0][1] = Integer.parseInt(line.substring(line.indexOf("..") + 2, line.indexOf(",")));
            ranges[1][0] = Integer.parseInt(line.substring(line.indexOf("y=") + 2, line.lastIndexOf("..")));
            ranges[1][1] = Integer.parseInt(line.substring(line.lastIndexOf("..") + 2));
            scanner.close();
            return ranges;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

}

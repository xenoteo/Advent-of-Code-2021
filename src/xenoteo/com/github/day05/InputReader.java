package xenoteo.com.github.day05;

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
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to the list of lines
     */
    public static List<Line> readListOfLines(URL path){
        try {
            List<Line> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                int firstCommaIndex = line.indexOf(',');
                int secondCommaIndex = line.lastIndexOf(',');
                int arrowIndex = line.lastIndexOf('-');

                Point point1 = new Point(
                        Integer.parseInt(line.substring(0, firstCommaIndex)),
                        Integer.parseInt(line.substring(firstCommaIndex + 1, arrowIndex - 1))
                );
                Point point2 = new Point(
                        Integer.parseInt(line.substring(arrowIndex + 3, secondCommaIndex)),
                        Integer.parseInt(line.substring(secondCommaIndex + 1))
                );

                input.add(new Line(point1, point2));
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

package xenoteo.com.github.day13;

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
     * @return the list of the dots' positions
     */
    public static List<Point> readDots(URL path){
        try {
            List<Point> dots = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.isEmpty()) break;
                String[] position = line.split(",");
                dots.add(new Point(Integer.parseInt(position[0]), Integer.parseInt(position[1])));
            }
            scanner.close();
            return dots;
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
     * @return the list of folds
     */
    public static List<Fold> readFolds(URL path){
        try {
            List<Fold> folds = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) if (scanner.nextLine().isEmpty()) break;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                folds.add(new Fold(line.charAt(11) == 'x', Integer.parseInt(line.substring(13))));
            }
            scanner.close();
            return folds;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}

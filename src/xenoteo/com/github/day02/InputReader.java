package xenoteo.com.github.day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class processing an input file for Day 2 puzzle.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to a list of moves
     */
    public static List<Move> readToMoveList(URL path){
        try {
            List<Move> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String[] moveStrings = scanner.nextLine().split(" ");
                input.add(new Move(Move.Direction.valueOf(moveStrings[0]), Long.parseLong(moveStrings[1])));
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

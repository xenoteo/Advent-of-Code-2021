package xenoteo.com.github.day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    private List<Integer> numbers;

    private List<Board> boards;

    /**
     * Initializes the object - reads data from the input file with provided filename to the variables numbers and boards.
     *
     * @param path  the path of the file
     */
    public InputReader(URL path) {
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));

            numbers = Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).collect(Collectors.toList());

            scanner.nextLine();

            boards = new ArrayList<>();
            while (scanner.hasNextLine()) {
                Board board = new Board();
                for (int i = 0; i < 5; i++) {
                    board.board[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                            .filter(str -> !str.isEmpty())
                            .map(Integer::parseInt)
                            .mapToInt(x -> x)
                            .toArray();
                }
                boards.add(board);
                if (scanner.hasNextLine()) scanner.nextLine();
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<Board> getBoards() {
        return boards;
    }

}

package xenoteo.com.github.day04.part2;

import xenoteo.com.github.day04.Board;
import xenoteo.com.github.day04.InputReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader inputReader = new InputReader(Main.class.getResource(filePath));
        List<Integer> numbers = inputReader.getNumbers();
        List<Board> boards = inputReader.getBoards();
        System.out.println(new Solution().findWinnerScore(numbers, boards));
    }

}

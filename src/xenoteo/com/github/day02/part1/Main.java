package xenoteo.com.github.day02.part1;


import xenoteo.com.github.day02.InputReader;
import xenoteo.com.github.day02.Move;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Move> moves = InputReader.readToMoveList(Main.class.getResource(filePath));
        System.out.println(new Solution().findMultiplicationOfFinalPositions(moves));
    }

}

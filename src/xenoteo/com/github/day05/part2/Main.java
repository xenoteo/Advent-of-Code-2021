package xenoteo.com.github.day05.part2;

import xenoteo.com.github.day05.InputReader;
import xenoteo.com.github.day05.Line;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Line> lines = InputReader.readListOfLines(Main.class.getResource(filePath));
        System.out.println(new Solution().countPointsWithOverlaps(lines));
    }

}

package xenoteo.com.github.day10.part2;

import xenoteo.com.github.InputReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<String> lines = InputReader.readToStringList(Main.class.getResource(filePath));
        System.out.println(new Solution().middleScoreOfIncompleteLines(lines));
    }

}

package xenoteo.com.github.day17.part1;

import xenoteo.com.github.day17.InputReader;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[][] ranges = InputReader.readRanges(Main.class.getResource(filePath));
        System.out.println(new Solution().findHighestYPosition(ranges));
    }

}

package xenoteo.com.github.day15.part2;

import xenoteo.com.github.InputReader;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[][] map = InputReader.readTo2DIntArray(Main.class.getResource(filePath));
        System.out.println(new Solution().lowestTotalRisk(map));
    }

}

package xenoteo.com.github.day11.part2;

import xenoteo.com.github.InputReader;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[][] octopuses = InputReader.readTo2DIntArray(Main.class.getResource(filePath));
        System.out.println(new Solution().findFirstStepWhenAllFlash(octopuses));
    }

}

package xenoteo.com.github.day01.part2;

import xenoteo.com.github.InputReader;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[] depths = InputReader.readToIntArray(Main.class.getResource(filePath));
        System.out.println(new Solution().countIncreasesOfWindows(depths, 3));
    }

}

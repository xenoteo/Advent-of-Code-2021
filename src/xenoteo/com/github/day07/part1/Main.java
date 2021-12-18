package xenoteo.com.github.day07.part1;

import xenoteo.com.github.InputReader;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[] crabs = InputReader.readNumbersSeparatedByCommasToArray(Main.class.getResource(filePath));
        System.out.println(new Solution().minimumFuelSpentToMakeCrabsPositionsMatch(crabs));
    }

}

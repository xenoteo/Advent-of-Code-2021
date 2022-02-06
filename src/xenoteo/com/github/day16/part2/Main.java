package xenoteo.com.github.day16.part2;

import xenoteo.com.github.day16.InputReader;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        int[] binary = InputReader.readToBinary(Main.class.getResource(filePath));
        System.out.println(new Solution().evaluateExpression(binary));
    }

}

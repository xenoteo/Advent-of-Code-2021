package xenoteo.com.github.day14;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        String input = InputReader.readInputString(Main.class.getResource(filePath));
        Map<String, String> rules = InputReader.readRules(Main.class.getResource(filePath));
        System.out.println(new Solution().quantityDiffOfMostCommonAndLeastCommon(input, rules, 40));
    }

}

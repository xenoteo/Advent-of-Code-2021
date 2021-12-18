package xenoteo.com.github.day06.part1;

import xenoteo.com.github.InputReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Integer> lanternfishes = InputReader.readNumbersSeparatedByCommasToList(Main.class.getResource(filePath));
        System.out.println(new Solution().countLanternfishes(lanternfishes, 80));
    }

}

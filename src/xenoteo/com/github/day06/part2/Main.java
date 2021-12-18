package xenoteo.com.github.day06.part2;

import xenoteo.com.github.day06.InputReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Integer> lanternfishes = InputReader.readToList(Main.class.getResource(filePath));
        System.out.println(new Solution().countLanternfishes(lanternfishes, 256));
    }

}

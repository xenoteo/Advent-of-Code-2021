package xenoteo.com.github.day03.part2;

import xenoteo.com.github.day03.InputReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Long> numbers = InputReader.readBinaryToLongArray(Main.class.getResource(filePath));
        System.out.println(new Solution().countLifeSupportRating(numbers));
    }

}

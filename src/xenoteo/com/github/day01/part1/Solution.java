package xenoteo.com.github.day01.part1;

public class Solution {

    public int countIncreases(int[] depths) {
        int counter = 0;
        for (int i = 1; i < depths.length; i++) {
            if (depths[i] > depths[i - 1]) {
                counter++;
            }
        }
        return counter;
    }

}

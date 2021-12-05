package xenoteo.com.github.day01.part1;

/**
 * Solution of the day 1, part 1.
 * @see <a href="https://adventofcode.com/2021/day/1">Day 1</a>
 */
public class Solution {

    /**
     * Counts the number of times a depth measurement increases
     * by iterating over the array of depth and comparing the current depth with the previous one.
     *
     * Time complexity is O(N), space complexity is O(1).
     *
     * @param depths  the array of depth measurements
     * @return the number of times a depth measurement increases
     */
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

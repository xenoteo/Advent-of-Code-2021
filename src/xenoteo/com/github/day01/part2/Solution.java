package xenoteo.com.github.day01.part2;

/**
 * Solution of the day 1, part 2.
 * @see <a href="https://adventofcode.com/2021/day/1">Day 1</a>
 */
public class Solution {

    /**
     * Counts the number of times the sum of measurements in a sliding window increases from the previous sum
     * by iterating over the array of depths, updating the sum for each window and comparing it to the previous one.
     *
     * Time complexity is O(N), space complexity is O(1).
     *
     * @param depths  the array of depth measurements
     * @param windowSize  the size of the sliding window
     * @return the number of times the sum of measurements in a sliding window increases
     */
    public int countIncreasesOfWindows(int[] depths, int windowSize) {
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += depths[i];
        }

        int counter = 0;
        for (int i = 0; i < depths.length - windowSize ; i++) {
            int newSum = sum + depths[i + windowSize] - depths[i];
            if (newSum > sum) counter++;
            sum =  newSum;
        }
        return counter;
    }

}

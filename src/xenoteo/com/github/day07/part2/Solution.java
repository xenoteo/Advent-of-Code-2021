package xenoteo.com.github.day07.part2;

import java.util.Arrays;

/**
 * Solution of the day 7, part 2.
 * @see <a href="https://adventofcode.com/2021/day/7">Day 7</a>
 */
public class Solution {

    /**
     * Count the minimum amount of fuel needed to align all crabs to one horizontal position.
     *
     * Sets the final position to the mean of initial positions and count the fuel needed.
     *
     * Time complexity is O(N), space complexity is O(1),
     * where N is the number of crabs.
     *
     * @param crabs  the array of crabs horizontal positions
     * @return the minimum amount of fuel needed to align all crabs to one horizontal position
     */
    public int minimumFuelSpentToMakeCrabsPositionsMatch(int[] crabs) {
        int sum = Arrays.stream(Arrays.stream(crabs).toArray()).sum();
        int finalPosition = sum / crabs.length;
        int fuel = 0;
        for (int crab : crabs) {
            int diff = Math.abs(crab - finalPosition);
            fuel += (diff + 1) * diff/ 2;
        }
        return fuel;
    }

}

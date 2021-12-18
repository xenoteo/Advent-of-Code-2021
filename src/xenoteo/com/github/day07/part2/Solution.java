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
     * Tries each position in the range between crabs min and max position to be chosen as crabs final position,
     * and finds the minimum fuel needed.
     *
     * Time complexity is O(N * D), space complexity is O(1),
     * where N is the number of crabs and D is the difference between crabs min and max positions.
     *
     * @param crabs  the array of crabs horizontal positions
     * @return the minimum amount of fuel needed to align all crabs to one horizontal position
     */
    public int minimumFuelSpentToMakeCrabsPositionsMatch(int[] crabs) {
        int minFuel = Integer.MAX_VALUE;
        int minPossibleCrab = Arrays.stream(Arrays.stream(crabs).toArray()).min().getAsInt();
        int maxPossibleCrab = Arrays.stream(Arrays.stream(crabs).toArray()).max().getAsInt();
        for (int chosenCrab = minPossibleCrab; chosenCrab <= maxPossibleCrab; chosenCrab++) {
            int fuel = 0;
            for (int crab : crabs) {
                int diff = Math.abs(crab - chosenCrab);
                fuel += (diff + 1) * diff/ 2;
            }
            minFuel = Math.min(fuel, minFuel);
        }
        return minFuel;
    }

}

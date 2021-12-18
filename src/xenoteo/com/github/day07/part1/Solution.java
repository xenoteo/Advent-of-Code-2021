package xenoteo.com.github.day07.part1;

/**
 * Solution of the day 7, part 1.
 * @see <a href="https://adventofcode.com/2021/day/7">Day 7</a>
 */
public class Solution {

    /**
     * Count the minimum amount of fuel needed to align all crabs to one horizontal position.
     *
     * Tries each position present in the array to be chosen as crabs final position, and finds the minimum fuel needed.
     *
     * Time complexity is O(N^2), space complexity is O(1), where N is the number of crabs.
     *
     * @param crabs  the array of crabs horizontal positions
     * @return the minimum amount of fuel needed to align all crabs to one horizontal position
     */
    public int minimumFuelSpentToMakeCrabsPositionsMatch(int[] crabs) {
        int minFuel = Integer.MAX_VALUE;
        for (int chosenCrab : crabs) {
            int fuel = 0;
            for (int crab : crabs) {
                fuel += Math.abs(crab - chosenCrab);
            }
            minFuel = Math.min(fuel, minFuel);
        }
        return minFuel;
    }

}

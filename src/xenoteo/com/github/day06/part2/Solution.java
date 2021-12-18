package xenoteo.com.github.day06.part2;

import java.util.Arrays;
import java.util.List;

/**
 * Solution of the day 6, part 2.
 * @see <a href="https://adventofcode.com/2021/day/6">Day 6</a>
 */
public class Solution {

    /**
     * Counts how many lanternfish there would be in the provided number of days.
     *
     * Creates an array state, which keeps the information about the number of lanternfishes of different states,
     * mapped by array index (e.g. the element at index 0 keeps the number lanternfishes of state 0).
     * Iterates over the array of states and creates the array of new day states based on lanternfishes counters.
     *
     * Time complexity is O(D), space complexity is O(1), where D is the number of days.
     *
     * @param lanternfishes  the list of lanternfishes
     * @param days  the number of days
     * @return the number of lanternfishes in the provided number of days
     */
    public long countLanternfishes(List<Integer> lanternfishes, int days) {
        long[] state = new long[9];
        for (int lanternfish : lanternfishes) {
            state[lanternfish]++;
        }

        for (int day = 0; day < days; day++) {
            long[] newState = new long[9];
            newState[6] = state[0];
            newState[8] = state[0];
            for (int i = 1; i < 9; i++) {
                newState[i - 1] += state[i];
            }
            state = newState;
        }
        return Arrays.stream(state).sum();
    }

}

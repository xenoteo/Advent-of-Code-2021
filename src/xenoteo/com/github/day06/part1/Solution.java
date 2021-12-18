package xenoteo.com.github.day06.part1;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution of the day 6, part 1.
 * @see <a href="https://adventofcode.com/2021/day/6">Day 6</a>
 */
public class Solution {

    /**
     * Counts how many lanternfish there would be in the provided number of days.
     *
     * Creates a list of next day lanternfishes and updates it according to the current day lanternfishes "state".
     *
     * Time complexity is O(N * 2^(D/6)), space complexity is O(N * 2^(D/6)),
     * where D is the number of days and N is the number of lanternfishes on the first day
     * (as 6 is the length of lanternfish cycle).
     *
     * @param lanternfishes  the list of lanternfishes
     * @param days  the number of days
     * @return the number of lanternfishes in the provided number of days
     */
    public int countLanternfishes(List<Integer> lanternfishes, int days) {
        for (int i = 0; i < days; i++) {
            List<Integer> nextDayLanternfishes = new LinkedList<>();
            int newLanternfishes = 0;
            for (int lanternfish : lanternfishes) {
                nextDayLanternfishes.add(lanternfish > 0 ? lanternfish - 1 : 6);
                if (lanternfish == 0) newLanternfishes++;
            }
            for (int fish = 0; fish < newLanternfishes; fish++) {
                nextDayLanternfishes.add(8);
            }
            lanternfishes = nextDayLanternfishes;
        }
        return lanternfishes.size();
    }

}

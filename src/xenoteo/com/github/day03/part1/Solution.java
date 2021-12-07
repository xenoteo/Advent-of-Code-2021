package xenoteo.com.github.day03.part1;

/**
 * Solution of the day 3, part 1.
 * @see <a href="https://adventofcode.com/2021/day/3">Day 3</a>
 */
public class Solution {

    /**
     * Counts the submarine power consumption using bit offsets.
     *
     * Iterates over the array of numbers and counts the number of ones on each bit position.
     * Then, after comparing these counts with the half of array length, updates either gamma or epsilon value.
     *
     * Time complexity is O(N * b), space complexity is O(b),
     * where N is the number of numbers and b is the number of bits in these numbers.
     *
     * @param numbers  the array of numbers
     * @return the power consumption
     */
    public long countPowerConsumption(long[] numbers) {
        int bits = 12;

        int[] oneCounts = new int[bits];   // counting the number of ones on ith bit
        long mask = 1;
        for (int i = 0; i < bits; i++) {
            for (long number : numbers) {
                if ((number & mask) != 0) {
                    oneCounts[i]++;
                }
            }
            mask <<= 1;
        }

        long gamma = 0;
        long epsilon = 0;
        for (int i = 0; i < bits; i ++) {
            // if ones are most common at position i, then add 2^i to gamma
            // (if it is zero then we don't need to add anything)
            if (oneCounts[i] > numbers.length / 2) {
                gamma += (long) Math.pow(2, i);
            }
            // if ones are least common at position i, then add 2^i to epsilon
            // (if it is zero then we don't need to add anything)
            else {
                epsilon += (long) Math.pow(2, i);
            }
        }

        return gamma * epsilon;
    }
}

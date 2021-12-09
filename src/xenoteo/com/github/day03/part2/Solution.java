package xenoteo.com.github.day03.part2;

import java.util.LinkedList;
import java.util.List;

/**
 * Solution of the day 3, part 2.
 * @see <a href="https://adventofcode.com/2021/day/3">Day 3</a>
 */
public class Solution {

    /**
     * Counts the submarine life support rating using bit offsets.
     *
     * Iterates over the copies of the list of numbers, determines the most and the least common value
     * in the current bit position and keeps only numbers with required (depending on a value being counted)
     * bit in that position until only one number remains.
     *
     * Time complexity is O(N * b), space complexity is O(N),
     * where N is the number of numbers and b is the number of bits in these numbers.
     *
     * @param numbers  the list of numbers
     * @return the power consumption
     */
    public long countLifeSupportRating(List<Long> numbers) {
        int bits = 12;

        // using linked lists because of constant time of removing
        LinkedList<Long> oxygenGeneratorValues = new LinkedList<>(numbers);
        long mask = (long) Math.pow(2, bits - 1);
        while (oxygenGeneratorValues.size() > 1) {
            int desiredBit = mostCommonValue(oxygenGeneratorValues, mask);
            for (Long number : numbers) {
                int bit = (number & mask) == 0 ? 0 : 1;
                if (bit != desiredBit) oxygenGeneratorValues.remove(number);
            }
            mask >>= 1;
        }

        LinkedList<Long> co2ScrubberValues = new LinkedList<>(numbers);
        mask = (long) Math.pow(2, bits - 1);
        while (co2ScrubberValues.size() > 1) {
            int desiredBit = leastCommonValue(co2ScrubberValues, mask);
            for (Long number : numbers) {
                int bit = (number & mask) == 0 ? 0 : 1;
                if (bit != desiredBit) co2ScrubberValues.remove(number);
            }
            mask >>= 1;
        }

        return oxygenGeneratorValues.getFirst() * co2ScrubberValues.getFirst();
    }

    /**
     * Finds the most common bit on the provided bit position in the list of elements.
     *
     * @param numbers  the list of elements
     * @param mask  the mask determining the bit position
     * @return the most common bit
     */
    private int mostCommonValue(LinkedList<Long> numbers, long mask) {
        return numbers.stream().filter(number -> (number & mask) != 0).count()  // the number of ones
                >= (numbers.size() + 1) / 2     // adding one to consider an odd number of elements
                ? 1 : 0;
    }

    /**
     * Finds the least common bit on the provided bit position in the list of elements.
     *
     * @param numbers  the list of elements
     * @param mask  the mask determining the bit position
     * @return the least common bit
     */
    private int leastCommonValue(LinkedList<Long> numbers, long mask) {
        return mostCommonValue(numbers, mask) == 1 ? 0 : 1;
    }

}

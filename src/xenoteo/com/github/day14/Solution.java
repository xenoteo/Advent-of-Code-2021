package xenoteo.com.github.day14;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution of the day 14.
 * @see <a href="https://adventofcode.com/2021/day/14">Day 14</a>
 */
public class Solution {

    /**
     * Finds the difference between most and least common elements quantities in the provided number of steps.
     *
     * Uses a map to store the quantity of pairs, which are being updated in each step accordingly to the map of rules.
     *
     * Time complexity is O(S), where S is the number of steps;
     * space complexity is O(1) (it's linear to the number of possible pairs and elements which is constant).
     *
     * @param input  the input string
     * @param rules  the map of rules
     * @param steps  the number of steps
     * @return the difference of quantities of most and least common elements
     */
    public long quantityDiffOfMostCommonAndLeastCommon(String input, Map<String, String> rules, int steps) {
        Map<String, Long> pairCounter = countPairs(input);

        for (int s = 0; s < steps; s++) {
            Map<String, Long> newPairCounter = new HashMap<>();
            for (Map.Entry<String, Long> entry : pairCounter.entrySet()) {
                String pair = entry.getKey();
                String newElement = rules.get(pair);

                String newPair1 = pair.charAt(0) + newElement;
                String newPair2 = newElement + pair.charAt(1);

                newPairCounter.put(newPair1, newPairCounter.getOrDefault(newPair1, 0L) + entry.getValue());
                newPairCounter.put(newPair2, newPairCounter.getOrDefault(newPair2, 0L) + entry.getValue());
            }
            pairCounter = newPairCounter;
        }

        return findDiff(pairCounter, input.charAt(0), input.charAt(input.length() - 1));
    }

    /**
     * Counts the pairs in the input string.
     *
     * Time complexity is O(N), where N is the length of the input string;
     * space complexity is O(1).
     *
     * @param input  the input string
     * @return the map of pair counters
     */
    private Map<String, Long> countPairs(String input) {
        Map<String, Long> pairCounter = new HashMap<>();
        for (int i = 0; i < input.length() - 1; i++) {
            String pair = input.substring(i, i + 2);
            pairCounter.put(pair, pairCounter.getOrDefault(pair, 0L)  + 1);
        }
        return pairCounter;
    }

    /**
     * Having the map of pair counters, finds the difference of quantities of most and least common elements.
     *
     * Time complexity is O(1), space complexity is O(1).
     *
     * @param pairCounter  the map of pair counters
     * @param firstChar  the first character of the input string
     * @param lastChar  the last character of the input string
     * @return the difference of quantities of most and least common elements
     */
    private long findDiff(Map<String, Long> pairCounter, char firstChar, char lastChar) {
        Map<Character, Long> elementCounter = new HashMap<>();
        for (Map.Entry<String, Long> entry : pairCounter.entrySet()) {
            char char1 = entry.getKey().charAt(0);
            char char2 = entry.getKey().charAt(1);

            elementCounter.put(char1, elementCounter.getOrDefault(char1, 0L) + entry.getValue());
            elementCounter.put(char2, elementCounter.getOrDefault(char2, 0L) + entry.getValue());
        }

        // in this loop we are considering that each element is counted twice
        // (except first and last elements)
        for (Map.Entry<Character, Long> entry : elementCounter.entrySet()) {
            char element = entry.getKey();
            if (element == firstChar || element == lastChar)
                elementCounter.put(element, (elementCounter.get(element) - 1) / 2 + 1);
            else elementCounter.put(entry.getKey(), elementCounter.get(entry.getKey()) / 2);
        }

        long maxCount = elementCounter.values().stream().max(Comparator.comparingLong(u -> u)).get();
        long minCount = elementCounter.values().stream().min(Comparator.comparingLong(u -> u)).get();

        return maxCount - minCount;
    }

}

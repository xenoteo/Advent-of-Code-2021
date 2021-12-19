package xenoteo.com.github.day08.part2;

import xenoteo.com.github.day08.Record;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution of the day 8, part 2.
 * @see <a href="https://adventofcode.com/2021/day/8">Day 8</a>
 */
public class Solution {

    /**
     * For the provided list of records, decodes each pattern and finds the sum of output numbers.
     *
     * Time complexity is O(N), space complexity is O(1); N is the number of records.
     *
     * @param records  the list of records
     * @return the sum of output numbers
     */
    public long decodeAndFindSum(List<Record> records) {
        long sum = 0;
        for (Record record : records) {
            Map<String, Integer> patternToDigit = decode(record.patterns);
            for (int i = 0; i < 4; i++) {
                sum += patternToDigit.get(sorted(record.output[i])) * Math.pow(10, 3 - i);
            }
        }
        return sum;
    }

    /**
     * Decodes the patterns to its digits.
     *
     * The decoding is based on the number of segments, whether the unknown pattern fully contains the known pattern and
     * the number of common segment with known patterns. The known patterns are 1, 4, 7 and 8, which can be determined
     * right away by the number of segments.
     *
     * Time complexity is O(1), space complexity is O(1)
     * (as we operate on strings of predefined length which cannot be more than 7).
     *
     * @param patterns  the array of digit patterns
     * @return the map of decoded patterns (pattern -> digit)
     */
    private Map<String, Integer> decode(String[] patterns) {
        String[] decoded = new String[10];
        decoded[1] = Arrays.stream(patterns).filter(x -> x.length() == 2).findFirst().get();
        decoded[4] = Arrays.stream(patterns).filter(x -> x.length() == 4).findFirst().get();
        decoded[7] = Arrays.stream(patterns).filter(x -> x.length() == 3).findFirst().get();
        decoded[8] = Arrays.stream(patterns).filter(x -> x.length() == 7).findFirst().get();

        for (String pattern : patterns) {
            int length = pattern.length();
            if (length == 5) {
                if (contains(pattern, decoded[1]))                                      decoded[3] = pattern;
                else if (commonSegments(pattern, decoded[4]) == 3)                      decoded[5] = pattern;
                else                                                                    decoded[2] = pattern;
            }
            else if (length == 6) {
                if (contains(pattern, decoded[1]) && contains(pattern, decoded[4]))     decoded[9] = pattern;
                else if (contains(pattern, decoded[1]))                                 decoded[0] = pattern;
                else                                                                    decoded[6] = pattern;
            }
        }

        Map<String, Integer> patternToDigit = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            patternToDigit.put(sorted(decoded[i]), i);
        }
        return patternToDigit;
    }

    /**
     * Determines whether the pattern fully contains the element.
     *
     * For example 4 fully contains 1; 3 fully contains 7.
     *
     * Time complexity is O(1), space complexity is O(1) (for string used in this problem).
     *
     * @param pattern  the pattern
     * @param element  the element
     * @return whether the pattern fully contains the element
     */
    private boolean contains(String pattern, String element) {
        return element.chars().mapToObj(c -> ((char) c) + "").allMatch(pattern::contains);
    }

    /**
     * Counts the number of common segments of the pattern and the element.
     *
     * For example 3 and 4 have 3 common segments; 1 and 7 have 2 common segments; 0 and 8 have 6 common segments.
     *
     * Time complexity is O(1), space complexity is O(1) (for string used in this problem).
     *
     * @param pattern  the pattern
     * @param element  the element
     * @return the number of common segments of the pattern and the element
     */
    private int commonSegments(String pattern, String element) {
        return (int) element.chars().mapToObj(c -> ((char) c) + "").filter(pattern::contains).count();
    }

    /**
     * Sorts the string.
     *
     * Time complexity is O(1), space complexity is O(1) (for string used in this problem).
     *
     * @param string  the string
     * @return the sorted string
     */
    private String sorted(String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

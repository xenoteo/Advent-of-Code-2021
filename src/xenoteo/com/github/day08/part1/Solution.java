package xenoteo.com.github.day08.part1;

import xenoteo.com.github.day08.Record;

import java.util.Arrays;
import java.util.List;

/**
 * Solution of the day 8, part 1.
 * @see <a href="https://adventofcode.com/2021/day/8">Day 8</a>
 */
public class Solution {

    /**
     * Counts how many times digits 1, 4, 7 or 8 (by the number of segments they use) appear in the output.
     *
     * Time complexity is O(N), space complexity is O(1); N is the number of records.
     *
     * @param records  the list of records
     * @return how many times digits 1, 4, 7 or 8 appear in the output
     */
    public long countNumbersOfUniqueSegmentNumbers(List<Record> records) {
        return records.stream()
                .flatMap(record -> Arrays.stream(record.output))
                .filter(digit -> digit.length() == 2 || digit.length() == 3 || digit.length() == 4 || digit.length() == 7)
                .count();
    }
}

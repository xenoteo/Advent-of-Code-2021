package xenoteo.com.github.day04.part1;

import xenoteo.com.github.day04.Board;

import java.util.List;

/**
 * Solution of the day 4, part 1.
 * @see <a href="https://adventofcode.com/2021/day/4">Day 4</a>
 */
public class Solution {

    /**
     * Finds the winner's score by iterating over the list of numbers and by marking those numbers on the boards.
     *
     * Time complexity is O(N * B), where N is the number of elements and B is the number of boards;
     * space complexity is O(1).
     *
     * @param numbers  the list of numbers
     * @param boards  the list of boards
     * @return the winner's score
     */
    public int findWinnerScore(List<Integer> numbers, List<Board> boards) {
        for (int number : numbers) {
            for (Board board : boards) {
                int result = board.mark(number);
                if (result > 0) return result * number;
            }
        }
        return 0;
    }

}

package xenoteo.com.github.day02.part2;

import xenoteo.com.github.day02.Move;

import java.util.List;

/**
 * Solution of the day 2, part 2.
 * @see <a href="https://adventofcode.com/2021/day/2">Day 2</a>
 */
public class Solution {

    /**
     * Finds the multiplication of the final horizontal position and the final depth.
     *
     * Iterates over the list of moves and updates the current horizontal position, the depth and the aim.
     *
     * Time complexity is O(N), space complexity is O(1).
     *
     * @param moves  the list of moves
     * @return the multiplication of the final horizontal position and the final depth
     */
    public long findMultiplicationOfFinalPositions(List<Move> moves) {
        long horizontal = 0;
        long depth = 0;
        long aim = 0;
        for (Move move : moves) {
            switch (move.direction) {
                case up -> aim -= move.value;
                case down -> aim += move.value;
                case forward -> {
                    horizontal += move.value;
                    depth += aim * move.value;
                }
            }
        }
        return horizontal * depth;
    }

}

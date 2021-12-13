package xenoteo.com.github.day04.part2;

import xenoteo.com.github.day04.Board;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution of the day 4, part 2.
 * @see <a href="https://adventofcode.com/2021/day/4">Day 4</a>
 */
public class Solution {

    /**
     * Finds the score of the last winning board by iterating over the list of numbers,
     * marking those numbers on the boards and removing won boards from the list.
     *
     * Time complexity is O(N * B), space complexity is O(B),
     * where N is the number of elements and B is the number of boards.
     *
     * @param numbers  the list of numbers
     * @param boards  the list of boards
     * @return the winner's score
     */
    public int findWinnerScore(List<Integer> numbers, List<Board> boards) {
        // using linked list because of constant removing time
        LinkedList<Board> boardLinkedList = new LinkedList<>(boards);
        int score = 0;
        for (int number : numbers) {
            List<Board> wonBoards = new ArrayList<>();
            for (Board board : boardLinkedList) {
                int result = board.mark(number);
                if (result > 0) {
                    score = result * number;
                    wonBoards.add(board);
                }
            }
            for (Board wonBoard : wonBoards) {
                boardLinkedList.remove(wonBoard);
            }
        }
        return score;
    }

}

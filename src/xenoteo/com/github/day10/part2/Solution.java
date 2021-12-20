package xenoteo.com.github.day10.part2;

import java.util.*;

/**
 * Solution of the day 10, part 2.
 * @see <a href="https://adventofcode.com/2021/day/10">Day 10</a>
 */
public class Solution {

    /**
     * Finds the middle score of incomplete lines.
     *
     * Firstly, remove the corrupted lines, and then uses stack to count the score.
     *
     * Time complexity is O(max[N*L, I*log(I)]), space complexity is O(L),
     * where N is the number of lines, L is the length of lines, I is the number of incomplete lines.
     *
     * @param lines  the list of lines
     * @return the middle score of incomplete lines
     */
    public long middleScoreOfIncompleteLines(List<String> lines) {
        // using linked list because of constant removing time
        LinkedList<String> linkedLines = new LinkedList<>(lines);
        linkedLines.removeAll(findCorruptedLines(lines));

        List<Long> scores = new ArrayList<>();
        for (String line : linkedLines) {
            Stack<Character> stack = new Stack<>();
            for (char ch : line.toCharArray()) {
                if (opening(ch)) stack.push(ch);
                else stack.pop();
            }
            long score = 0;
            while (!stack.isEmpty()) {
                score *= 5;
                score += characterScore(stack.pop());
            }
            scores.add(score);
        }

        scores.sort(Comparator.naturalOrder());
        return scores.get(scores.size() / 2);
    }

    /**
     * Using stack, finds the list of corrupted lines.
     *
     * Time complexity is O(N * L), space complexity is O(L),
     * where N is the number of lines, L is the length of lines.
     *
     * @param lines  the list of lines
     * @return the list of corrupted lines
     */
    private List<String> findCorruptedLines(List<String> lines) {
        List<String> corruptedLines = new ArrayList<>();
        for (String line : lines) {
            Stack<Character> stack = new Stack<>();
            for (char ch : line.toCharArray()) {
                if (opening(ch)) stack.push(ch);
                else {
                    if (stack.isEmpty())  {
                        corruptedLines.add(line);
                        break;
                    }
                    char top = stack.pop();
                    if (top != pair(ch)) {
                        corruptedLines.add(line);
                        break;
                    }
                }
            }
        }
        return corruptedLines;
    }

    /**
     * Determines whether the provided character is opening or not.
     *
     * @param ch  the character
     * @return whether the provided character is opening or not
     */
    private boolean opening(char ch) {
        return ch == '(' || ch == '[' || ch == '{' || ch == '<';
    }

    /**
     * Returns the character score.
     *
     * @param ch  the character
     * @return the character score
     */
    private int characterScore(char ch) {
        return switch (ch) {
            case '(' -> 1;
            case '[' -> 2;
            case '{' -> 3;
            case '<' -> 4;
            default -> -1;
        };
    }

    /**
     * Finds the pair for the character.
     *
     * @param ch  the character
     * @return the pair for the character
     */
    private char pair(char ch) {
        return switch (ch) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            case '>' -> '<';
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            case '<' -> '>';
            default -> ' ';
        };
    }

}

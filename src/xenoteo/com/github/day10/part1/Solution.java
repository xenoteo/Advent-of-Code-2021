package xenoteo.com.github.day10.part1;

import java.util.List;
import java.util.Stack;

/**
 * Solution of the day 10, part 1.
 * @see <a href="https://adventofcode.com/2021/day/10">Day 10</a>
 */
public class Solution {

    /**
     * Finds the syntax error score.
     *
     * Uses stack to keep track of opening characters.
     *
     * Time complexity is O(N * L), space complexity is O(L),
     * where N is the number of lines, L is the length of lines.
     *
     * @param lines  the list of lines
     * @return the syntax error score
     */
    public int syntaxErrorScore(List<String> lines) {
        int errorScore = 0;
        for (String line : lines) {
            Stack<Character> stack = new Stack<>();
            for (char ch : line.toCharArray()) {
                if (opening(ch)) stack.push(ch);
                else {
                    if (stack.isEmpty())  {
                        errorScore += characterScore(ch);
                        break;
                    }
                    char top = stack.pop();
                    if (top != pair(ch)) {
                        errorScore += characterScore(ch);
                        break;
                    }
                }
            }
        }
        return errorScore;
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
     * Returns the illegal character score.
     *
     * @param ch  the character
     * @return the illegal character score
     */
    private int characterScore(char ch) {
        return switch (ch) {
            case ')' -> 3;
            case ']' -> 57;
            case '}' -> 1197;
            case '>' -> 25137;
            default -> -1;
        };
    }

    /**
     * Finds the pair for closing character.
     *
     * @param ch  the closing character
     * @return the opening character
     */
    private char pair(char ch) {
        return switch (ch) {
            case ')' -> '(';
            case ']' -> '[';
            case '}' -> '{';
            case '>' -> '<';
            default -> ' ';
        };
    }

}

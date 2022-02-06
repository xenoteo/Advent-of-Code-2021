package xenoteo.com.github.day16.part2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Solution of the day 16, part 2.
 * @see <a href="https://adventofcode.com/2021/day/16">Day 16</a>
 */
public class Solution {

    /**
     * Evaluates the given binary expression.
     *
     * Calls the inner helper method in order to get a result.
     *
     * Time complexity is O(N), space complexity is O(D),
     * where N is the number of bits in the input binary array,
     * D is the depth of the expression, that is how nested the expression is.
     *
     * @param binary  the array of binary data
     * @return the result of expression evaluation
     */
    public long evaluateExpression(int[] binary) {
        return evaluateExpression(binary, 0).value;
    }

    /**
     * Evaluates the expression of one packet starting on the provided position.
     *
     * Iterates over bits and evaluated packets accordingly to the rules defined.
     * Calls the methods recursively in order to evaluate inner sub-packets.
     *
     * Time complexity is O(N), space complexity is O(D),
     * where N is the number of bits in the input binary array,
     * D is the depth of the expression, that is how nested the expression is.
     *
     * @param binary  the array of binary data
     * @param startingPosition  the starting position of the packet
     * @return the result containing evaluated packet and the position at which packet finished
     */
    private Result evaluateExpression(int[] binary, int startingPosition) {
        int k = startingPosition;
        k += 3;
        int type = readNBits(binary, k, 3);
        k += 3;
        long value;

        if (type == 4) {
            StringBuilder builder = new StringBuilder();
            while (binary[k] == 1) {
                appendGroup(binary, k, builder);
                k += 5;
            }
            appendGroup(binary, k, builder);
            k += 5;
            value = Long.parseLong(builder.toString(), 2);
        }
        else {
            List<Long> values = new ArrayList<>();

            if (binary[k] == 0) {
                int bitsLen = readNBits(binary, k + 1, 15);
                k += 16;
                int endPosition = k + bitsLen;
                while (k < endPosition) {
                    Result result = evaluateExpression(binary, k);
                    k = result.endPosition;
                    values.add(result.value);
                }
            }
            else {
                int subPackets = readNBits(binary, k + 1, 11);
                k += 12;
                for (int i = 0; i < subPackets; i++) {
                    Result result = evaluateExpression(binary, k);
                    k = result.endPosition;
                    values.add(result.value);
                }
            }
            value = evaluateOperation(values, type);
        }

        return new Result(value, k);
    }

    /**
     * Reads the provided number of bits from the binary array starting from the provided position.
     *
     * Time complexity is O(N), space complexity is O(1),
     * where N is the number of bits to read.
     *
     * @param binary  the array of binary data
     * @param startingPosition  the starting position
     * @param numberOfBits  the number of bits to read
     * @return the read number
     */
    private int readNBits(int[] binary, int startingPosition, int numberOfBits) {
        int num = 0;
        int pow = 1;
        for (int i = startingPosition + numberOfBits - 1; i >= startingPosition; i--) {
            num += binary[i] * pow;
            pow *= 2;
        }
        return num;
    }

    /**
     * Appends one bit group to the provided string builder.
     *
     * @param binary  the array of binary data
     * @param startingPosition  the group starting position
     * @param builder  the string builder
     */
    private void appendGroup(int[] binary, int startingPosition, StringBuilder builder) {
        builder.append(binary[startingPosition + 1]);
        builder.append(binary[startingPosition + 2]);
        builder.append(binary[startingPosition + 3]);
        builder.append(binary[startingPosition + 4]);
    }

    /**
     * Evaluates the operation accordingly to its type and to the list of values provided.
     *
     * @param values  the list of values
     * @param type  the operation type
     * @return the result of operation evaluation
     */
    private long evaluateOperation(List<Long> values, int type) {
        return switch (type) {
            case 0 -> values.stream().reduce(Long::sum).orElse(-1L);
            case 1 -> values.stream().reduce((a, b) -> a * b).orElse(-1L);
            case 2 -> values.stream().reduce(Math::min).orElse(-1L);
            case 3 -> values.stream().reduce(Math::max).orElse(-1L);
            case 5 -> values.get(0) > values.get(1) ? 1 : 0;
            case 6 -> values.get(0) < values.get(1) ? 1 : 0;
            case 7 -> Objects.equals(values.get(0), values.get(1)) ? 1 : 0;
            default -> -1;
        };
    }

    /**
     * Helper structure storing the result value and the end position of the packet.
     */
    private static class Result {
        public final long value;
        public final int endPosition;

        public Result(long value, int endPosition) {
            this.value = value;
            this.endPosition = endPosition;
        }
    }

}

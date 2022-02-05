package xenoteo.com.github.day16.part1;

/**
 * Solution of the day 16, part 1.
 * @see <a href="https://adventofcode.com/2021/day/16">Day 16</a>
 */
public class Solution {

    /**
     * Finds the sum of all packets' versions.
     *
     * Iterates over the bits and finds the beginnings of the following packets
     * accordingly to the defined rules.
     *
     * Time complexity is O(N), space complexity is O(1),
     * where N is the number of bits in the input binary array.
     *
     * @param binary  the array of binary data
     * @return the sum of all packets' versions
     */
    public int findSumOfVersionNumbers(int[] binary) {
        int versionsSum = 0;
        int k = 0;
        while (k < binary.length - 11) {    // 11 is the minimum length of one packet
            int version = readNBits(binary, k, 3);
            k += 3;
            int type = readNBits(binary, k, 3);
            k += 3;
            if (type == 4) {
                while (binary[k] == 1) k += 5;
                k += 5;
            }
            else {
                if (binary[k] == 0) k += 16;
                else k += 12;
            }
            versionsSum += version;
        }
        return versionsSum;
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

}

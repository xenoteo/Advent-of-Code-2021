package xenoteo.com.github.day01.part2;

public class Solution {

    public int countIncreasesOfWindows(int[] depths, int windowSize) {
        int sum = 0;
        for (int i = 0; i < windowSize; i++) {
            sum += depths[i];
        }

        int counter = 0;
        for (int i = 0; i < depths.length - windowSize ; i++) {
            int newSum = sum + depths[i + windowSize] - depths[i];
            if (newSum > sum) counter++;
            sum =  newSum;
        }
        return counter;
    }

}

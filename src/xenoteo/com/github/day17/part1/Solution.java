package xenoteo.com.github.day17.part1;

/**
 * Solution of the day 17, part 1.
 * @see <a href="https://adventofcode.com/2021/day/17">Day 17</a>
 */
public class Solution {

    /**
     * Finds the highest y position of the probe.
     *
     * Let's consider a function y(t), where y is the probe's y position and t is the number of steps
     * passed since the beginning. Let's denote the initial y velocity as h and the bottom of the target area as B.
     * Then y(t) = h + (h - 1) + (h - 2) + ... + (h - t + 1) = (h + (h - t + 1)) * 1/2 * t = (2h - t + 1) * t / 2.
     * It is easy to notice that the maximum y position will be at the moment when the y velocity reaches 0.
     * This happens in h steps (because the initial velocity h gets decremented exactly h times).
     * Having this we can compute the maximum y position as y_max = (2h - h + 1) * h / 2 = (h + 1) * h / 2.
     * So now to count the y_max we have to find the maximum possible initial y velocity.
     * This velocity is equal to -B - 1 (assuming that the target area is below the "horizon").
     * Note that the probe will meet the horizon with the y velocity equal to -h.
     * That is in the step next to the step of meeting the horizon the y velocity will be (-h - 1).
     * If (-h - 1) is equal to the bottom of the target area then the probe will reach the target area in exactly one
     * step after meeting the horizon. And at the same time in this case it would be the maximum possible value of h,
     * while reaching the target. This way we can count the maximum y position:
     * -h - 1 = B =>
     * h = -B - 1 =>
     * y_max = (-B - 1) * (-B - 1 + 1) / 2 = (B + 1) * B / 2.
     *
     * Time complexity is O(1), space complexity is O(1).
     *
     * @param ranges  two target ranges stored in a 2D array (the first is for x positions, the second is for y positions)
     * @return the highest y position of the probe
     */
    public int findHighestYPosition(int[][] ranges) {
        int bottom = ranges[1][0];
        return bottom * (bottom + 1) / 2;
    }

}

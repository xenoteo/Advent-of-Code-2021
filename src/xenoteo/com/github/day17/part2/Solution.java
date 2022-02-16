package xenoteo.com.github.day17.part2;

/**
 * Solution of the day 17, part 2.
 * @see <a href="https://adventofcode.com/2021/day/17">Day 17</a>
 */
public class Solution {

    /**
     * Counts distinct initial velocity values that cause the probe to be within the target area after any step.
     *
     * Brute force solution, trying each possible starting velocity and checking whether it hits the target.
     *
     * Assuming that xes are greater than 0 and yes are less than 0.
     *
     * Time complexity is O(X * Y), space complexity is O(1),
     * where X and Y are maximum absolute values of x and y coordinates of the target area.
     *
     * @param ranges  two target ranges stored in a 2D array (the first is for x positions, the second is for y positions)
     * @return the highest y position of the probe
     */
    public int countPossibleVelocities(int[][] ranges) {
        int velocities = 0;
        for (int vx = 0; vx <= ranges[0][1]; vx++) {
            for (int vy = ranges[1][0]; vy <= -ranges[1][0]; vy++) {
                if (hitsTarget(vx, vy, ranges[0][0], ranges[0][1], ranges[1][0], ranges[1][1])) velocities++;
            }
        }
        return velocities;
    }

    /**
     * Checks whether the given initial velocity will lead to reaching the target area.
     *
     * @param vx  the initial x velocity
     * @param vy  the initial y velocity
     * @param xMin  the minimum x position of the target area
     * @param xMax  the maximum x position of the target area
     * @param yMin  the minimum y position of the target area
     * @param yMax  the maximum y position of the target area
     * @return whether the given initial velocity hits the target
     */
    private boolean hitsTarget(int vx, int vy, int xMin, int xMax, int yMin, int yMax) {
        int x = 0;
        int y = 0;
        while (true) {
            if (x > xMax) return false;
            if (vx == 0 && x < xMin) return false;
            if (vx == 0 && y < yMin) return false;

            if (xMin <= x && x <= xMax && yMin <= y && y <= yMax) return true;

            x += vx;
            y += vy;
            vx = Math.max(vx - 1, 0);
            vy--;
        }
    }

}

package xenoteo.com.github.day11.part1;

/**
 * Solution of the day 11, part 1.
 * @see <a href="https://adventofcode.com/2021/day/11">Day 11</a>
 */
public class Solution {

    /**
     * The size of one side of the octopuses' grid.
     */
    private static final int GRID_SIZE = 10;

    /**
     * Counts the number of flashes in the provided number of steps.
     *
     * Time complexity is O(S) and space complexity is O(1) (assuming that the grid size is constant and is equal 10),
     * where S is the number of steps.
     *
     * @param octopuses  the grid of octopuses
     * @param steps  the number of steps
     * @return the number of flashes in the provided number of steps
     */
    public int countFlashes(int[][] octopuses, int steps) {
        int flashes = 0;
        for (int step = 0; step < steps; step++) {
            boolean[][] flashed = new boolean[GRID_SIZE][GRID_SIZE];
            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    octopuses[i][j]++;
                    if (octopuses[i][j] > 9 && !flashed[i][j]) {
                        flashes += flash(octopuses, flashed, i, j);
                    }
                }
            }

            for (int i = 0; i < GRID_SIZE; i++) {
                for (int j = 0; j < GRID_SIZE; j++) {
                    if (flashed[i][j]) {
                        octopuses[i][j] = 0;
                    }
                }
            }
        }
        return flashes;
    }

    /**
     * Flashes one octopus at the provided position and recursively causes the flashes of adjacent octopus
     * if their energy level is appropriate and they did not flash at this step.
     *
     * Time complexity is O(1) and space complexity is O(1) (assuming that the grid size is constant and is equal 10).
     *
     * @param octopuses  the grid of octopuses
     * @param flashed  the array indicating whether an octopus at the given position flashed or not
     * @param i  an octopus' row
     * @param j  and octopus' column
     * @return the number of flashes caused by the flash of the octopus at the given position
     */
    private int flash(int[][] octopuses, boolean[][] flashed, int i, int j) {
        flashed[i][j] = true;
        int flashes = 1;

        if (i > 0 && j > 0) {
            octopuses[i - 1][j - 1]++;
            if (octopuses[i - 1][j - 1] > 9 && !flashed[i - 1][j - 1]) {
                flashes += flash(octopuses, flashed, i - 1, j - 1);
            }
        }
        if (i > 0) {
            octopuses[i - 1][j]++;
            if (octopuses[i - 1][j] > 9 && !flashed[i - 1][j]) {
                flashes += flash(octopuses, flashed, i - 1, j);
            }
        }
        if (i > 0 && j < GRID_SIZE - 1) {
            octopuses[i - 1][j + 1]++;
            if (octopuses[i - 1][j + 1] > 9 && !flashed[i - 1][j + 1]) {
                flashes += flash(octopuses, flashed, i - 1, j + 1);
            }
        }
        if (j > 0) {
            octopuses[i][j - 1]++;
            if (octopuses[i][j - 1] > 9 && !flashed[i][j - 1]) {
                flashes += flash(octopuses, flashed, i, j - 1);
            }
        }
        if (j < GRID_SIZE - 1) {
            octopuses[i][j + 1]++;
            if (octopuses[i][j + 1] > 9 && !flashed[i][j + 1]) {
                flashes += flash(octopuses, flashed, i, j + 1);
            }
        }
        if (i < GRID_SIZE - 1 && j > 0) {
            octopuses[i + 1][j - 1]++;
            if (octopuses[i + 1][j - 1] > 9 && !flashed[i + 1][j - 1]) {
                flashes += flash(octopuses, flashed, i + 1, j - 1);
            }
        }
        if (i < GRID_SIZE - 1) {
            octopuses[i + 1][j]++;
            if (octopuses[i + 1][j] > 9 && !flashed[i + 1][j]) {
                flashes += flash(octopuses, flashed, i + 1, j);
            }
        }
        if (i < GRID_SIZE - 1 && j < GRID_SIZE - 1) {
            octopuses[i + 1][j + 1]++;
            if (octopuses[i + 1][j + 1] > 9 && !flashed[i + 1][j + 1]) {
                flashes += flash(octopuses, flashed, i + 1, j + 1);
            }
        }

        return flashes;
    }
}

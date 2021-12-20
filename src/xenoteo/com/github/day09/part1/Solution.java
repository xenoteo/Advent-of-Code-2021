package xenoteo.com.github.day09.part1;

/**
 * Solution of the day 9, part 1.
 * @see <a href="https://adventofcode.com/2021/day/9">Day 9</a>
 */
public class Solution {

    /**
     * Finds the sum of the risk levels of all low points on the heightmap.
     *
     * Time complexity is O(N * M), space complexity is O(1).
     *
     * @param map  the heightmap
     * @return the sum of the risk levels of all low points
     */
    public int sumOfRiskLevels(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        int sum = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (map[i][j] < map[i - 1][j] && map[i][j] < map[i][j - 1]
                        && map[i][j] < map[i + 1][j] && map[i][j] < map[i][j + 1]) {
                    sum += 1 + map[i][j];
                }
            }
        }

        if (map[0][0] < map[0][1] && map[0][0] < map[1][0]) sum += 1 + map[0][0];
        if (map[0][m - 1] < map[0][m - 2] && map[0][m - 1] < map[1][m - 1]) sum += 1 + map[0][m - 1];
        if (map[n - 1][m - 1] < map[n - 1][m - 2] && map[n - 1][m - 1] < map[n - 2][m - 1]) sum += 1 + map[n - 1][m - 1];
        if (map[n - 1][0] < map[n - 1][1] && map[n - 1][0] < map[n - 2][0]) sum += 1 + map[n - 1][0];

        for (int j = 1; j < m - 1; j++) {
            if (map[0][j] < map[0][j - 1] && map[0][j] < map[1][j] && map[0][j] < map[0][j + 1]) {
                sum += 1 + map[0][j];
            }
        }

        for (int j = 1; j < m - 1; j++) {
            if (map[n - 1][j] < map[n - 1][j - 1] && map[n - 1][j] < map[n - 2][j] && map[n - 1][j] < map[n - 1][j + 1]) {
                sum += 1 + map[n - 1][j];
            }
        }

        for (int i = 1; i < n - 1;i++) {
            if (map[i][0] < map[i - 1][0] && map[i][0] < map[i + 1][0] && map[i][0] < map[i][1]) {
                sum += 1 + map[i][0];
            }
        }

        for (int i = 1; i < n - 1;i++) {
            if (map[i][m - 1] < map[i - 1][m - 1] && map[i][m - 1] < map[i][m - 2] && map[i][m - 1] < map[i + 1][m - 1]) {
                sum += 1 + map[i][m - 1];
            }
        }

        return sum;
    }
}

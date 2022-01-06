package xenoteo.com.github.day15.part1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Solution of the day 15, part 1.
 * @see <a href="https://adventofcode.com/2021/day/15">Day 15</a>
 */
public class Solution {

    /**
     * Finds the lowest total risk of any path from the top left to the bottom right.
     *
     * Uses Dijkstra algorithm to find the less risky path.
     *
     * Time complexity is O(V * log(V)), space complexity is O(V),
     * where V is the total number of elements in the map.
     *
     * @param map  the map
     * @return the lowest total risk
     */
    public int lowestTotalRisk(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        int[][] risk = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                risk[i][j] = Integer.MAX_VALUE;
            }
        }
        risk[0][0] = 0;

        Set<Point> queue = new HashSet<>();
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Set<Point> newQueue = new HashSet<>();

            for (Point point : queue) {
                if (point.i > 0 && (risk[point.i][point.j] + map[point.i - 1][point.j] < risk[point.i - 1][point.j])) {
                    risk[point.i - 1][point.j] = risk[point.i][point.j] + map[point.i - 1][point.j];
                    newQueue.add(new Point(point.i - 1, point.j));
                }
                if (point.i < n - 1 && (risk[point.i][point.j] + map[point.i + 1][point.j] < risk[point.i + 1][point.j])) {
                    risk[point.i + 1][point.j] = risk[point.i][point.j] + map[point.i + 1][point.j];
                    newQueue.add(new Point(point.i + 1, point.j));
                }
                if (point.j > 0 && (risk[point.i][point.j] + map[point.i][point.j - 1] < risk[point.i][point.j - 1])) {
                    risk[point.i][point.j - 1] = risk[point.i][point.j] + map[point.i][point.j - 1];
                    newQueue.add(new Point(point.i, point.j - 1));
                }
                if (point.j < m - 1 && (risk[point.i][point.j] + map[point.i][point.j + 1] < risk[point.i][point.j + 1])) {
                    risk[point.i][point.j + 1] = risk[point.i][point.j] + map[point.i][point.j + 1];
                    newQueue.add(new Point(point.i, point.j + 1));
                }
            }

            queue = newQueue;
        }

        return risk[n - 1][m- 1];
    }

    /**
     * The class representing a 2D point.
     */
    private static class Point {
        public final int i;
        public final int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return i == point.i && j == point.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

}

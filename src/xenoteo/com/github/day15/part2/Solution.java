package xenoteo.com.github.day15.part2;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Solution of the day 15, part 2.
 * @see <a href="https://adventofcode.com/2021/day/15">Day 15</a>
 */
public class Solution {

    /**
     * Finds the lowest total risk of any path from the top left to the bottom right.
     *
     * Firstly creates the full map having the first tile as an input,
     * and then uses Dijkstra algorithm to find the less risky path.
     *
     * Time complexity is O(V * log(V)), space complexity is O(V),
     * where V is the total number of elements in the map.
     *
     * @param map  the map
     * @return the lowest total risk
     */
    public int lowestTotalRisk(int[][] map) {
        int[][] fullMap = findFullMap(map);
        return findLowestTotalRisk(fullMap);
    }

    /**
     * Creates a full map of 5 * 5 tiles having the first tile.
     *
     * In the map of 5 * 5 tiles there are 9 diagonals.
     * The diagonal's number is also the difference between the elements of the current diagonal and the elements of the first tile;
     * this fact is used to iterate over diagonals and to update the elements of diagonals accordingly.
     *
     * Time complexity is O(V), space complexity is O(V),
     * where V is the total number of elements in the map.
     *
     * @param map  the first tile
     * @return the full map
     */
    private int[][] findFullMap(int[][] map) {
        int n = map.length;
        int m = map[0].length;

        int[][] fullMap = new int[5 * n][5 * m];
        for (int diff = 0; diff < 9; diff++) {
            // iterating over diagonal's tiles;
            // (tileI, tileJ) is the tile's position
            // (upperLeftI, upperLeftJ) is the position of upperLeft element of the current tile
            for (int tileJ = diff, tileI = 0; tileJ >= 0 && tileI <= diff; tileJ--, tileI++) {
                int upperLeftI = tileI * n;
                int upperLeftJ = tileJ * m;
                if (upperLeftI > 4 * n || upperLeftJ > 4 * m) continue;
                for (int i = upperLeftI; i < upperLeftI + n;  i++) {
                    for (int j = upperLeftJ; j < upperLeftJ + m; j++) {
                        fullMap[i][j] = map[i - upperLeftI][j - upperLeftJ] + diff;
                        if (fullMap[i][j] > 9) fullMap[i][j] -= 9;
                    }
                }
            }
        }

        return fullMap;
    }

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
    private int findLowestTotalRisk(int[][] map) {
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

package xenoteo.com.github.day09.part2;

import java.util.*;

/**
 * Solution of the day 9, part 2.
 * @see <a href="https://adventofcode.com/2021/day/9">Day 9</a>
 */
public class Solution {

    /**
     * Finds the multiplications of the three largest basins.
     *
     * Uses BFS to find parts of map bounded by 9s.
     *
     * Time complexity is O(N * M), space complexity is O(N * M).
     *
     * @param map  the heightmap
     * @return the multiplications of the three largest basins
     */
    public int multiplicationOfThreeLargestBasins(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        boolean[][] visited = new boolean[n][m];
        List<Integer> sizes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 9) {
                    sizes.add(visitBasin(map, visited, new Point(i, j)));
                }
            }
        }

        sizes.sort(Comparator.reverseOrder());
        return sizes.get(0) * sizes.get(1) * sizes.get(2);
    }

    /**
     * Using BFS, visits one full basin starting from the provided point.
     *
     * Time complexity is O(N * M), space complexity is O(N * M).
     *
     * @param map  the heightmap
     * @param visited  the map of visited points
     * @param startingPoint  the starting point
     * @return the size of the basin
     */
    private int visitBasin(int[][] map, boolean[][] visited, Point startingPoint) {
        int size = 0;
        Set<Point> parents = Set.of(startingPoint);
        while (!parents.isEmpty()) {
            Set<Point> children = new HashSet<>();
            for (Point point : parents) {
                visited[point.r][point.c] = true;
                size++;
                children.addAll(notVisitedNeighbours(point, map, visited));
            }
            parents = children;
        }
        return size;
    }

    /**
     * Finds the list of not visited neighbours of the point (excluding 9s, as they cannot be a part of basins).
     *
     * @param point  the point
     * @param map  the heightmap
     * @param visited  the map of visited points
     * @return the list of not visited neighbours of the point
     */
    private List<Point> notVisitedNeighbours(Point point, int[][] map, boolean[][] visited) {
        int n = map.length;
        int m = map[0].length;
        List<Point> neighbours = new ArrayList<>();
        if (point.r > 0 && map[point.r - 1][point.c] != 9 && !visited[point.r - 1][point.c])
            neighbours.add(new Point(point.r - 1, point.c));
        if (point.r < n - 1 && map[point.r + 1][point.c] != 9 && !visited[point.r + 1][point.c])
            neighbours.add(new Point(point.r + 1, point.c));
        if (point.c > 0 && map[point.r][point.c - 1] != 9 && !visited[point.r][point.c - 1])
            neighbours.add(new Point(point.r, point.c - 1));
        if (point.c < m - 1 && map[point.r][point.c + 1] != 9 && !visited[point.r][point.c + 1])
            neighbours.add(new Point(point.r, point.c + 1));
        return neighbours;
    }

    /**
     * The class representing a 2D grid point.
     */
    private static class Point {
        final int r;
        final int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return r == point.r && c == point.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }

    }
}

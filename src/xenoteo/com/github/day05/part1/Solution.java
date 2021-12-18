package xenoteo.com.github.day05.part1;

import xenoteo.com.github.day05.Line;
import xenoteo.com.github.day05.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution of the day 5, part 1.
 * @see <a href="https://adventofcode.com/2021/day/5">Day 5</a>
 */
public class Solution {

    /**
     * Counts the number of points covered by at least 2 lines.
     *
     * Iterating over the list of liens and by adding each point of the line to the pointsCoverage map,
     * which is counting how many lines each point is covered by.
     * Next, counting how many points are covered by more than one line.
     *
     * Time complexity is O(P), space complexity is O(P),
     * where P is the number of points of all lines (tin other words, the number of points of determined 2D plane).
     *
     * @param lines  the list of lines
     * @return the number of points covered by at least 2 lines
     */
    public long countPointsWithOverlaps(List<Line> lines) {
        Map<Point, Integer> pointsCoverage = new HashMap<>();
        for (Line line : lines) {
            if (!horizontalOrVertical(line)) continue;

            int xDiff;
            int yDiff;
            if (line.point1.x == line.point2.x) {
                xDiff = 0;
                yDiff = 1;
            }
            else {
                xDiff = 1;
                yDiff = 0;
            }

            int xStart = Math.min(line.point1.x, line.point2.x);
            int xEnd = Math.max(line.point1.x, line.point2.x);
            int yStart = Math.min(line.point1.y, line.point2.y);
            int yEnd = Math.max(line.point1.y, line.point2.y);

            for (int x = xStart, y = yStart; x <= xEnd && y <= yEnd; x += xDiff, y += yDiff) {
                Point point = new Point(x, y);
                pointsCoverage.put(point, pointsCoverage.getOrDefault(point, 0) + 1);
            }
        }

        return pointsCoverage.values().stream().filter(n -> n > 1).count();
    }

    /**
     * Checks whether the provided line is horizontal or vertical.
     *
     * @param line  the line
     * @return whether the provided line is horizontal or vertical
     */
    private boolean horizontalOrVertical(Line line) {
        return line.point1.x == line.point2.x || line.point1.y == line.point2.y;
    }
}

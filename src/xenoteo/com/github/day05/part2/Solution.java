package xenoteo.com.github.day05.part2;

import xenoteo.com.github.day05.Line;
import xenoteo.com.github.day05.Point;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution of the day 5, part 2.
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
     * where P is the number of points of all lines (in other words, the number of points of determined 2D plane).
     *
     * @param lines  the list of lines
     * @return the number of points covered by at least 2 lines
     */
    public long countPointsWithOverlaps(List<Line> lines) {
        Map<Point, Integer> pointsCoverage = new HashMap<>();
        for (Line line : lines) {
            int xDiff = line.point1.x == line.point2.x ? 0 :
                    (line.point2.x - line.point1.x) / Math.abs(line.point2.x - line.point1.x);
            int yDiff = line.point1.y == line.point2.y ? 0 :
                    (line.point2.y - line.point1.y) / Math.abs(line.point2.y - line.point1.y);

            for (int x = line.point1.x, y = line.point1.y; !(x == line.point2.x && y == line.point2.y); x += xDiff, y += yDiff) {
                Point point = new Point(x, y);
                pointsCoverage.put(point, pointsCoverage.getOrDefault(point, 0) + 1);
            }
            pointsCoverage.put(line.point2, pointsCoverage.getOrDefault(line.point2, 0) + 1);
        }

        return pointsCoverage.values().stream().filter(n -> n > 1).count();
    }

}

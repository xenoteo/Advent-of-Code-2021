package xenoteo.com.github.day12.part1;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution of the day 12, part 1.
 * @see <a href="https://adventofcode.com/2021/day/12">Day 12</a>
 */
public class Solution {

    /**
     * Counts the number of paths through the cave system that visit small caves at most once.
     *
     * Used DFS-based solution to count the paths. Big caves are never marked as visited,
     * only small ones are being marked as visited. Starting and ending caves are visited only once.
     *
     * Time complexity is O(S + B * S), space complexity is O(B + S) (because of recursive calls),
     * where (B + S) is the number of all caves in the cave system,
     * S is the number of small caves and B is the number of big caves.
     *
     * @param cave  the starting cave
     * @return the number of paths through the cave system that visit small caves at most once
     */
    public int countPaths(Cave cave) {
        if (cave.type == Cave.CaveType.END) return 1;

        List<Cave> possibleCaves = possiblePaths(cave);
        if (possibleCaves.isEmpty()) return 0;

        if (cave.type == Cave.CaveType.SMALL) cave.visited = true;

        int paths = 0;
        for (Cave neighbour : possibleCaves) {
            paths += countPaths(neighbour);
        }

        cave.visited = false;   // clear "visited" for other possible paths being counted in other recursive calls

        return paths;
    }

    /**
     * Finds the list of cave's neighbours which are yet possible to be visited.
     *
     * Time complexity is O(N), space complexity O(1), where N is the number of cave's neighbours.
     *
     * @param cave  the cave
     * @return the list of cave's neighbours which are yet possible to be visited
     */
    private List<Cave> possiblePaths(Cave cave) {
        return cave.neighbours.stream()
                .filter(neighbour -> !neighbour.visited && neighbour.type != Cave.CaveType.START)
                .collect(Collectors.toList());
    }
}

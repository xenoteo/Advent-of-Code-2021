package xenoteo.com.github.day12.part2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution of the day 12, part 2.
 * @see <a href="https://adventofcode.com/2021/day/12">Day 12</a>
 */
public class Solution {

    /**
     * Counts the number of paths through the cave system.
     *
     * Used DFS-based solution to count the paths. Big caves are never marked as visited,
     * only small ones are being marked as visited. Starting and ending caves are visited only once.
     *
     * Time complexity is O((S + B * S) * N) ~ O(B * S * N), space complexity is O(B + S) (because of recursive calls),
     * where (B + S) is the number of all caves in the cave system,
     * S is the number of small caves, B is the number of big caves and N is the number of one cave neighbours.
     *
     * @param cave  the starting cave
     * @return the number of paths through the cave system that visit small caves at most once
     */
    public int countPaths(Cave cave, boolean smallUniqueChosen) {
        if (cave.type == Cave.CaveType.END) return 1;

        if (cave.type == Cave.CaveType.SMALL) cave.visited++;

        List<Cave> possibleCaves = possiblePaths(cave);
        int paths = 0;
        for (Cave neighbour : possibleCaves) {
            if (neighbour.type == Cave.CaveType.SMALL && neighbour.visited > 0) {
                if (!smallUniqueChosen) paths += countPaths(neighbour, true);
                // otherwise there are no possible paths
            }
            else paths += countPaths(neighbour, smallUniqueChosen);
        }

        // clear "visited" for other possible paths being counted in other recursive calls
        if (cave.type == Cave.CaveType.SMALL) cave.visited--;

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
                .filter(neighbour -> neighbour.type != Cave.CaveType.START && neighbour.visited < 2)
                .collect(Collectors.toList());
    }

}

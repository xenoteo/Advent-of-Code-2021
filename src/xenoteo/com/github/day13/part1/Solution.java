package xenoteo.com.github.day13.part1;

import xenoteo.com.github.day13.Fold;
import xenoteo.com.github.day13.Point;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Solution of the day 13, part 1.
 * @see <a href="https://adventofcode.com/2021/day/13">Day 13</a>
 */
public class Solution {

    /**
     * Counts the dots which are visible after the first fold.
     *
     * Time complexity is O(N), space complexity is O(N),
     * where N is the number of the dots.
     *
     * @param dots  the list of dots
     * @param folds  the list of folds
     * @return the number of dots visible after the first fold
     */
    public int countDots(List<Point> dots, List<Fold> folds) {
        Set<Point> dotsSet = new HashSet<>(dots);

        for (int i = 0; i < 1; i++) {
            Fold fold = folds.get(i);

            // removing the dots which are located after the folding position
            Set<Point> dotsToRemove = fold(dotsSet, fold);

            // adding the dots which are now at new positions after the fold
            for (Point dot : dotsToRemove) {
                // new dot position = fold.position - diff,
                // diff = dot.position - fold.position =>
                // new dot position = fold.position - (dot.position - fold.position) = 2 * fold.position - dot.position)
                dotsSet.add(fold.isX ?
                        new Point(2 * fold.position - dot.x, dot.y) :
                        new Point(dot.x, 2 * fold.position - dot.y));
            }
        }

        return dotsSet.size();
    }

    /**
     * Removes from the set all of the dots, which are located after the folding position.
     *
     * Time complexity is O(N), space complexity is O(N),
     * where N is the number of the dots.
     *
     * @param dots  the set of the dots
     * @param fold  the fold
     * @return the set of removed dots
     */
    private Set<Point> fold(Set<Point> dots, Fold fold) {
        Set<Point> dotsToRemove = fold.isX ?
                dots.stream().filter(point -> point.x > fold.position).collect(Collectors.toSet()) :
                dots.stream().filter(point -> point.y > fold.position).collect(Collectors.toSet());
        dots.removeAll(dotsToRemove);
        return dotsToRemove;
    }

}

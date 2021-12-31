package xenoteo.com.github.day13.part2;

import xenoteo.com.github.day13.Fold;
import xenoteo.com.github.day13.Point;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Solution of the day 13, part 2.
 * @see <a href="https://adventofcode.com/2021/day/13">Day 13</a>
 */
public class Solution {

    /**
     * Prints the code obtained after performing all of the folds.
     *
     * Time complexity is O(D * F + M * N), space complexity is O(M * N),
     * where D is the number of dots, F is the number of folds,
     * N and M are the maximum x and y coordinates.
     *
     * @param dots  the list of dots
     * @param folds  the list of folds
     */
    public void printCode(List<Point> dots, List<Fold> folds) {
        Set<Point> dotsSet = new HashSet<>(dots);

        for (Fold fold : folds) {
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

        print2dArray(createMap(dotsSet));
    }

    /**
     * Removes from the set all of the dots, which are located after the folding position.
     *
     * Time complexity is O(D), space complexity is O(D),
     * where D is the number of the dots.
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

    /**
     * Creates a map based on a set of dots.
     *
     * Time complexity is O(N * M), space complexity is O(N * M),
     * where N and M are the maximum x and y coordinates.
     *
     * @param dots  the set of dots
     * @return  the 2D char map
     */
    private char[][] createMap(Set<Point> dots) {
        int xMax = dots.stream().max(Comparator.comparingInt(point -> point.x)).get().x;
        int yMax = dots.stream().max(Comparator.comparingInt(point -> point.y)).get().y;

        boolean[][] dotsMap = new boolean[yMax + 1][xMax + 1];
        for (Point dot : dots) {
            dotsMap[dot.y][dot.x] = true;
        }

        char[][] map = new char[yMax + 1][xMax + 1];
        for (int i = 0; i <= yMax; i++) {
            for (int j = 0; j <= xMax; j++) {
                map[i][j] = dotsMap[i][j] ? '#' : '.';
            }
        }
        return map;
    }

    /**
     * Prints a 2D char array.
     *
     * @param arr  the 2D char array
     */
    private void print2dArray(char[][] arr) {
        for (char[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }

}

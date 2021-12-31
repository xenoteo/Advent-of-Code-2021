package xenoteo.com.github.day13.part1;

import xenoteo.com.github.day13.Fold;
import xenoteo.com.github.day13.InputReader;
import xenoteo.com.github.day13.Point;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Point> dots = InputReader.readDots(Main.class.getResource(filePath));
        List<Fold> folds = InputReader.readFolds(Main.class.getResource(filePath));
        System.out.println(new Solution().countDots(dots, folds));
    }

}

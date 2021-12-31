package xenoteo.com.github.day12.part2;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        Cave startingCave = InputReader.readCaves(Main.class.getResource(filePath));
        System.out.println(new Solution().countPaths(startingCave, false));
    }

}

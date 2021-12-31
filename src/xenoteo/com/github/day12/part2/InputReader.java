package xenoteo.com.github.day12.part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to the graph, the starting cave
     */
    public static Cave readCaves(URL path){
        try {
            Map<String, Cave> graph = new HashMap<>();

            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                String[] caves = scanner.nextLine().split("-");

                if (!graph.containsKey(caves[0])) graph.put(caves[0], new Cave(caves[0]));
                if (!graph.containsKey(caves[1])) graph.put(caves[1], new Cave(caves[1]));

                Cave cave1 = graph.get(caves[0]);
                Cave cave2 = graph.get(caves[1]);

                cave1.neighbours.add(cave2);
                cave2.neighbours.add(cave1);
            }
            scanner.close();
            return graph.get("start");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}

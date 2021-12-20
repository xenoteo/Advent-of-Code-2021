package xenoteo.com.github;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to an integer array
     */
    public static int[] readToIntArray(URL path){
        try {
            List<Integer> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                input.add(Integer.valueOf(scanner.nextLine()));
            }
            scanner.close();
            return input.stream().mapToInt(Integer::intValue).toArray();    // converting list to array
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to a long array
     */
    public static long[] readToLongArray(URL path){
        try {
            List<Long> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                input.add(Long.valueOf(scanner.nextLine()));
            }
            scanner.close();
            return input.stream().mapToLong(Long::longValue).toArray(); // converting list to array
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to a list of strings
     */
    public static List<String> readToStringList(URL path){
        try {
            List<String> input = new ArrayList<>();
            Scanner scanner = new Scanner(new File(path.getFile()));
            while (scanner.hasNextLine()) {
                input.add(scanner.nextLine());
            }
            scanner.close();
            return input;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to 2D char array
     */
    public static char[][] readTo2DCharArray(URL path){
        return stringListTo2DCharArray(Objects.requireNonNull(readToStringList(path)));
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to 2D int array
     */
    public static int[][] readTo2DIntArray(URL path){
        return stringListTo2DIntArray(Objects.requireNonNull(readToStringList(path)));
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to the list of integers
     */
    public static List<Integer> readNumbersSeparatedByCommasToList(URL path){
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            String line = scanner.nextLine();
            scanner.close();
            return Arrays.stream(line.split(",")).map(Integer::parseInt).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to an int array
     */
    public static int[] readNumbersSeparatedByCommasToArray(URL path){
        return readNumbersSeparatedByCommasToList(path).stream().mapToInt(x -> x).toArray();
    }

    /**
     * Converts a list of strings to a 2D char array.
     *
     * @param list  the list to convert
     * @return the 2D char array
     */
    private static char[][] stringListTo2DCharArray(List<String> list){
        char[][] arr = new char[list.size()][list.get(0).length()];
        for (int i = 0; i < list.size(); i++){
            String line = list.get(i);
            for (int j = 0; j < line.length(); j++){
                arr[i][j] = line.charAt(j);
            }
        }
        return arr;
    }

    /**
     * Converts a list of strings to a 2D int array.
     *
     * @param list  the list to convert
     * @return the 2D int array
     */
    private static int[][] stringListTo2DIntArray(List<String> list){
        int[][] arr = new int[list.size()][list.get(0).length()];
        for (int i = 0; i < list.size(); i++){
            String line = list.get(i);
            for (int j = 0; j < line.length(); j++){
                arr[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }
        return arr;
    }

}
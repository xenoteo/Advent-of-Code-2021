package xenoteo.com.github.day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;

/**
 * Class proceeding an input file.
 */
public class InputReader {

    private static final Map<Character, String> hexadecimalToBinary = new HashMap<>() {{
        put('0', "0000");
        put('1', "0001");
        put('2', "0010");
        put('3', "0011");
        put('4', "0100");
        put('5', "0101");
        put('6', "0110");
        put('7', "0111");
        put('8', "1000");
        put('9', "1001");
        put('A', "1010");
        put('B', "1011");
        put('C', "1100");
        put('D', "1101");
        put('E', "1110");
        put('F', "1111");
    }};

    /**
     * Reads data from the input file with provided filename.
     *
     * @param path  the path of the file
     * @return data converted to the binary array
     */
    public static int[] readToBinary(URL path){
        try {
            Scanner scanner = new Scanner(new File(path.getFile()));
            String input = scanner.nextLine();
            int[] binary = new int[input.length() * 4];
            int k = 0;
            for (char ch : input.toCharArray()) {
                String bin = hexadecimalToBinary.get(ch);
                binary[k] = bin.charAt(0) - '0';
                binary[k + 1] = bin.charAt(1) - '0';
                binary[k + 2] = bin.charAt(2) - '0';
                binary[k + 3] = bin.charAt(3) - '0';
                k += 4;
            }
            return binary;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}

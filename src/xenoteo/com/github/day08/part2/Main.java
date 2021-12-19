package xenoteo.com.github.day08.part2;

import xenoteo.com.github.day08.InputReader;
import xenoteo.com.github.day08.Record;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        List<Record> records = InputReader.readToRecordList(Main.class.getResource(filePath));
        System.out.println(new Solution().decodeAndFindSum(records));
    }

}

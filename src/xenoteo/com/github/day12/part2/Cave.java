package xenoteo.com.github.day12.part2;

import java.util.ArrayList;
import java.util.List;

/**
 * The class representing a cave.
 */
public class Cave {

    String name;

    int visited = 0;

    List<Cave> neighbours = new ArrayList<>();

    CaveType type;

    public Cave(String name) {
        this.name = name;

        if (name.equals("start")) this.type = CaveType.START;
        else if (name.equals("end")) this.type = CaveType.END;
        else if (name.equals(name.toLowerCase())) this.type = CaveType.SMALL;
        else if (name.equals(name.toUpperCase())) this.type = CaveType.BIG;
    }

    @Override
    public String toString() {
        return name;
    }

    public enum CaveType {
        START,
        END,
        SMALL,
        BIG
    }
}

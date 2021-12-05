package xenoteo.com.github.day02;

/**
 * Class representing a move of the submarine.
 */
public class Move {

    public final Direction direction;
    public final long value;

    public Move(Direction direction, long value) {
        this.direction = direction;
        this.value = value;
    }

    public enum Direction {
        up,
        down,
        forward
    }

}

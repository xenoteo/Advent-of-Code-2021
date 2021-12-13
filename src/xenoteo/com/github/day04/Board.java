package xenoteo.com.github.day04;

/**
 * The class representing one bingo board.
 */
public class Board {

    /**
     * The array representing the board.
     */
    public final int[][] board = new int[5][5];

    /**
     * The array denoting whether numbers are marked or not.
     */
    private final boolean[][] marked = new boolean[5][5];

    /**
     * Marks the provided number on the board (if it is present) and, in case if the board has won,
     * returns the sum of unmarked numbers; otherwise just marks the number and returns -1.
     *
     * @param number  the number to be marked
     * @return the sum of unmarked elements if the board has won; -1 otherwise
     */
    public int mark(int number) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == number) {
                    marked[i][j] = true;
                    if((marked[0][j] && marked[1][j] && marked[2][j] && marked[3][j] && marked[4][j])
                            || (marked[i][0] && marked[i][1] && marked[i][2] && marked[i][3] && marked[i][4])) {
                        return unmarkedSum();
                    }
                }
            }
        }
        return -1;
    }

    /**
     * Counts the sum of unmarked elements.
     *
     * @return the sum of unmarked elements
     */
    private int unmarkedSum() {
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) sum += board[i][j];
            }
        }
        return sum;
    }
}

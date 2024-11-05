import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

public class AssignmentTest {
    @Test
    public void nQueensTest() {
        final int BOARD_SIZE= 4;

        ChessBoard board = new ChessBoard(BOARD_SIZE);
        board.solveNQueens();

        assertArrayEquals(new int[][]{
            {0,0,1,0},
            {1,0,0,0},
            {0,0,0,1},
            {0,1,0,0}
        }, board.getBoard());
    }
}

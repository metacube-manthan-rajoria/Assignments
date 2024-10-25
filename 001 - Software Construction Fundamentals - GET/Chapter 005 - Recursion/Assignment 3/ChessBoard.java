// import java.util.Scanner;
// import java.util.ArrayList;
// import java.util.HashMap;

public class ChessBoard {
	int board[][];
	int boardSize = 0;

	public ChessBoard(int size) {
		board = new int[size][size];
		boardSize = size;
	}

	public boolean solveNQueens() {
		if(boardSize == 2 || boardSize == 3) return false;

		boolean solvableBoard = nQueens(board, 0);
		if (solvableBoard) {
			printBoard();
			return true;
		} else {
			return false;
		}
	}

	private boolean nQueens(int[][] board, int col) {
		if (col >= boardSize)
			return true;

		for (int row = 0; row < boardSize; row++) {
			if (isPositionSafe(board, row, col)) {
				board[row][col] = 1;
				printBoard();

				if (nQueens(board, col + 1) == true)
					return true;

				board[row][col] = 0;
			}
		}

		return false;
	}

	private boolean isPositionSafe(int[][] board, int row, int col) {
		int rowCopy = row;
		int colCopy = col;

		for (int i = 0; i < boardSize; i++)
			if (board[row][i] == 1)
				return false;

		for (int i = 0; i < boardSize; i++)
			if (board[i][col] == 1)
				return false;

		// First Diagonal \
		for (int i = 0; i < boardSize; i++) {
			rowCopy--;
			colCopy--;
			if (rowCopy < 0 || colCopy < 0)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}
		rowCopy = row;
		colCopy = col;
		for (int i = 0; i < boardSize; i++) {
			rowCopy++;
			colCopy++;
			if (rowCopy == boardSize || colCopy == boardSize)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}
		rowCopy = row;
		colCopy = col;

		// Second Diagonal /
		for (int i = 0; i < boardSize; i++) {
			rowCopy--;
			colCopy++;
			if (rowCopy < 0 || colCopy == boardSize)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}
		rowCopy = row;
		colCopy = col;
		for (int i = 0; i < boardSize; i++) {
			rowCopy++;
			colCopy--;
			if (rowCopy == boardSize || colCopy < 0)
				break;
			if (board[rowCopy][colCopy] == 1)
				return false;
		}

		return true;
	}

	public void printBoard() {
		for (int i = 0; i < boardSize; i++) {
			if (i < boardSize)
				System.out.println("=================");
			for (int j = 0; j < boardSize; j++) {
				System.out.print("| " + board[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("=================");
		System.out.println();
	}
}

class Assignment {
	public static void main(String[] args) {
		ChessBoard cb = new ChessBoard(4);
		cb.solveNQueens();
	}
}

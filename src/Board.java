import java.util.ArrayList;
import java.util.Objects;

public class Board {
    public static final String PLAYER_X = "X";
    public static final String PLAYER_O = "O";
    public static final String EMPTY_CELL = " ";
    public static final int BOARD_SIZE = 3;
    private final String[][] board;

    public Board() {
        board = new String[][]{
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL},
                {EMPTY_CELL, EMPTY_CELL, EMPTY_CELL}
        };
    }

    public void printBoard() {
        for(int row = 0; row < BOARD_SIZE; row++) {
            System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
            if (row < BOARD_SIZE - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public boolean isMoveValid(int row, int column) throws IllegalArgumentException {
        if(row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE) {
            if (Objects.equals(board[row][column], EMPTY_CELL)) {
                return true;
            } else {
                System.out.println("Cell already occupied.");
                return false;
            }
        } else {
            throw new IllegalArgumentException("Invalid coordinates.");
        }
    }

    public String getCellValue(int row, int column) throws IllegalArgumentException {
        if(row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE) {
            return board[row][column];
        } else {
            throw new IllegalArgumentException("Invalid coordinates.");
        }
    }

    public boolean setCellValue(int row, int column, String symbol) throws IllegalArgumentException {
        if(row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE) {
            if(Objects.equals(symbol, PLAYER_X) || Objects.equals(symbol, PLAYER_O)) {
                if(Objects.equals(board[row][column], EMPTY_CELL)) {
                    board[row][column] = symbol;
                    return true;
                } else {
                    System.out.println("Cell already occupied.");
                    return false;
                }
            } else {
                throw new IllegalArgumentException("Invalid symbol.");
            }
        } else {
            throw new IllegalArgumentException("Invalid coordinates.");
        }
    }

    public boolean isBoardFull() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if(Objects.equals(board[row][column], EMPTY_CELL)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBoardEmpty() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if(!Objects.equals(board[row][column], EMPTY_CELL)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                board[row][column] = EMPTY_CELL;
            }
        }
    }

    public int getBoardSize() {
        return BOARD_SIZE;
    }

    public ArrayList<int[]> getEmptyCells() {
        ArrayList<int[]> emptyCells = new ArrayList<>();
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int column = 0; column < BOARD_SIZE; column++) {
                if(Objects.equals(board[row][column],EMPTY_CELL)) {
                    emptyCells.add(new int[]{row, column});
                }
            }
        }
        return emptyCells;
    }
}

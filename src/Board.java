import java.util.Objects;

public class Board {
    private final String[][] board;

    public Board() {
        board = new String[][]{
                {" ", " ", " "},
                {" ", " ", " "},
                {" ", " ", " "}
        };
    }

    public static void main (String[] args) {
        Board board = new Board();
        board.printBoard();
    }

    public void printBoard() {
        for(int row = 0; row < 3; row++) {
            System.out.println(" " + board[row][0] + " | " + board[row][1] + " | " + board[row][2]);
            if (row < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public boolean makeMove(int row, int column, String symbol) {
        boolean validMove = false;
        if(row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            if (Objects.equals(board[row][column], " ")) {
                board[row][column] = symbol;
                System.out.println("Move made successfully!");
                validMove = true;
            } else {
                System.out.println("Cell already occupied.");
            }
        } else {
            System.out.println("Coordinates out of bond.");
        }
        return validMove;
    }
}

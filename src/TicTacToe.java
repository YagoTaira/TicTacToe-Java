public class TicTacToe {
    Board board;
    Player player1;
    Player player2;
    GameLogic gameLogic;
    UserInterface userInterface;

    public TicTacToe() {
        board = new Board();
        player1 = new Player();
        player2 = new Player();
        gameLogic = new GameLogic();
        userInterface = new UserInterface();
    }

    public void run() {
        System.out.println("TicTacToe running!");
    }
}

public class TicTacToeDriver {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.logDate();
        for (int i = 0; i < 9; i++) {
            game.takeTurn();
            if (WinningBoards.containsWin(game, 0)) {
                System.exit(0);
            }
        }
    }
}

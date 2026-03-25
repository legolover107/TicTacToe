public class TicTacToeDriver {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println(game);
        for (int i = 0; i < 9; i++) {
            game.takeTurn();
            if (WinningBoards.containsWin(game)) {
                System.exit(0);
            }
        }
    }
}

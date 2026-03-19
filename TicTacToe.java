import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private boolean hasTwoPlayers;
    private char turn;
    private String[] x   =   {  "     XXXXXXX        XXXXXXX     ", //1
                                "     X:::::X        X:::::X     ", //2
                                "     X:::::X        X:::::X     ", //3
                                "     X::::::X      X::::::X     ", //4
                                "     XXX:::::X    X:::::XXX     ", //5
                                "        X:::::X  X:::::X        ", //6
                                "         X:::::XX:::::X         ", //7
                                "          X::::::::::X          ", //8
                                "          X::::::::::X          ", //9
                                "         X:::::XX:::::X         ", //10
                                "        X:::::X  X:::::X        ", //11
                                "     XXX:::::X    X:::::XXX     ", //12
                                "     X::::::X      X::::::X     ", //13
                                "     X:::::X        X:::::X     ", //14
                                "     X:::::X        X:::::X     ", //15
                                "     XXXXXXX        XXXXXXX     "};//16

    private String[] o   =   {  "          OOOOOOOOOOOO          ", //1
                                "        OO::::::::::::OO        ", //2
                                "      OO::::::::::::::::OO      ", //3
                                "     O:::::::OOOOOO:::::::O     ", //4
                                "     O::::::O      O::::::O     ", //5
                                "     O:::::O        O:::::O     ", //6
                                "     O:::::O        O:::::O     ", //7
                                "     O:::::O        O:::::O     ", //8
                                "     O:::::O        O:::::O     ", //9
                                "     O:::::O        O:::::O     ", //10
                                "     O:::::O        O:::::O     ", //11
                                "     O::::::O      O::::::O     ", //12
                                "     O:::::::OOOOOO:::::::O     ", //13
                                "      OO::::::::::::::::OO      ", //14
                                "        OO::::::::::::OO        ", //15
                                "          OOOOOOOOOOOO          "};//16
                            
    private String[] blank = {  "                                ", //1
                                "                                ", //2
                                "                                ", //3
                                "                                ", //4
                                "                                ", //5
                                "                                ", //6
                                "                                ", //7
                                "                                ", //8
                                "                                ", //9
                                "                                ", //10
                                "                                ", //11
                                "                                ", //12
                                "                                ", //13
                                "                                ", //14
                                "                                ", //15
                                "                                "};//16

    public TicTacToe () {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        hasTwoPlayers = true;
        turn = 'x';
    }

    public TicTacToe (boolean hasTwoPlayers) {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        this.hasTwoPlayers = hasTwoPlayers;
        turn = 'x';
    }

    public String toString() {
        String str = "";
        for (int h = 0; h < board.length; h++) {
            char[] row = board[h];
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < row.length; j++) {
                    char col = row[j];
                    if (col == 'x') {
                        str += x[i];
                    } else if (col == 'o') {
                        str += o[i];
                    } else {
                        str += blank[i];
                    }
                    if (j < 2) {
                        str += "###";
                    }
                }
                str += "\n";
            }
            if (h < 2) {
                for (int i = 0; i < 2; i++) {
                    str += "######################################################################################################\n";
                }
            }
        }
        return str;
    }

    public void takeTurn() {
        Scanner scan = new Scanner(System.in);
        System.out.println(String.valueOf(turn).toUpperCase() + "'s turn");
        System.out.print("Row:  \t");
        int row = scan.nextInt();
        System.out.print("Column:\t");
        int col = scan.nextInt();
        if (board[row][col] == ' ') {
            board[row][col] = turn;
            if (turn == 'x') {
                turn = 'o';
            } else if (turn == 'o') {
                turn = 'x';
            }
            System.out.println(toString());
        } else {
            System.out.println("Try again");
            takeTurn();
        }
    }
}

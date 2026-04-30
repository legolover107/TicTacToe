import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class TicTacToe {
    private int boardSize = 8;
    public final boolean DOLOGGING = true;
    private char[][] board;
    private int[][] turnTaken;
    private boolean hasTwoPlayers;
    private char turn;
    private String file = "boards.txt";
    private int turns;
    private String[] x16 =   {  "     XXXXXXX        XXXXXXX     ", //1
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

    private String[] o16 =   {  "          OOOOOOOOOOOO          ", //1
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
                            
    private String[] blank16={  "                                ", //1
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

    private String[] x8 =    {  " XXXXX  XXXXX ", //1
                                " XX::X  X::XX ", //2
                                "   X::XX::X   ", //3
                                "    X::::X    ", //4
                                "    X::::X    ", //5
                                "   X::XX::X   ", //6
                                " XX::X  X::XX ", //7
                                " XXXXX  XXXXX "}; //8

    private String[] o8 =    {  "  OOOOOOOOOO  ", //1
                                " O::::::::::O ", //2
                                " O:::OOOO:::O ", //3
                                " O::O    O::O ", //4
                                " O::O    O::O ", //5
                                " O:::OOOO:::O ", //6
                                " O::::::::::O ", //7
                                "  OOOOOOOOOO  " }; //8

    private String[] blank8 ={  "              ", //1
                                "              ", //2
                                "              ", //3
                                "              ", //4
                                "              ", //5
                                "              ", //6
                                "              ", //7
                                "              "}; //8

    public TicTacToe () {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        turnTaken = new int[3][3];
        hasTwoPlayers = true;
        turn = 'x';
        turns = 0;
    }

    public TicTacToe (boolean hasTwoPlayers) {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        turnTaken = new int[3][3];
        this.hasTwoPlayers = hasTwoPlayers;
        turn = 'x';
        turns = 0;
    }

    public TicTacToe (char[][] board) {
        this.board = board;
        turnTaken = new int[3][3];
        hasTwoPlayers = true;
        turn = 'x';
        turns = 0;
    }

    public String toString() {
        String str = "";
        if (boardSize == 16) {
            for (int h = 0; h < board.length; h++) {
                char[] row = board[h];
                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < row.length; j++) {
                        char col = row[j];
                        if (col == 'x') {
                            str += x16[i];
                        } else if (col == 'o') {
                            str += o16[i];
                        } else {
                            str += blank16[i];
                        }
                        if (j < 2) {
                            str += "####";
                        }
                    }
                    str += "\n";
                }
                if (h < 2) {
                    for (int i = 0; i < 2; i++) {
                        str += "########################################################################################################\n";
                    }
                }
            }
        } else if (boardSize == 8) {
            for (int h = 0; h < board.length; h++) {
                char[] row = board[h];
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < row.length; j++) {
                        char col = row[j];
                        if (col == 'x') {
                            str += x8[i];
                        } else if (col == 'o') {
                            str += o8[i];
                        } else {
                            str += blank8[i];
                        }
                        if (j < 2) {
                            str += "##";
                        }
                    }
                    str += "\n";
                }
                if (h < 2) {
                    for (int i = 0; i < 2; i++) {
                        str += "##############################################\n";
                    }
                }
            }
        } else if (boardSize == 1) {
            for (int h = 0; h < board.length; h++) {
                char[] row = board[h];
                for (int j = 0; j < row.length; j++) {
                    char col = row[j];
                    if (col == 'x') {
                        str += " x ";
                    } else if (col == 'o') {
                        str += " o ";
                    } else {
                        str += "   ";
                    }
                    if (j < 2) {
                        str += "#";
                    }
                }
                str += "\n";
                if (h < 2) {
                    str += "###########\n";
                }
            }
        }
        return str;
    }

    public void takeTurn() {
        Scanner scan = new Scanner(System.in);
        System.out.println(toString());
        System.out.println(String.valueOf(turn).toUpperCase() + "'s turn");
        System.out.print("Enter location using number pad:\t");
        int num = scan.nextInt() - 1;
        int row = 0, col = 0;
        if (num >= 0) {
            row = 2 - (num / 3);
            col = num % 3;
        } else {
            System.out.println("Invalid input, try again");
            takeTurn();
        }
        if (board[row][col] == ' ') {
            board[row][col] = turn;
            if (turn == 'x') {
                turns++;
                turnTaken[row][col] = turns;
                turn = 'o';
            } else if (turn == 'o') {
                turnTaken[row][col] = turns;
                turn = 'x';
            }
        } else {
            System.out.println("Try again");
            takeTurn();
        }
    }

    public boolean equals(TicTacToe other) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (this.board[row][col] != other.board[row][col] && other.board[row][col] != ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void logDate() {
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        File log = new File(file);
        log.setWritable(DOLOGGING);
        try {
            FileWriter logWriter = new FileWriter(log, true);
            logWriter.write((time.format(myFormatObj) + "\n"));
            logWriter.close();
        } catch (IOException e) {
            System.err.println("Error: File not found");
        }
    }

    public void logGame() {
        File log = new File(file);
        log.setWritable(DOLOGGING);
        try {
            FileWriter logWriter = new FileWriter(log, true);
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    if (board[row][col] != ' ') {
                        logWriter.write(Character.toString(board[row][col]) + Integer.toString(turnTaken[row][col]));
                    } else {
                        logWriter.write("__");
                    }
                    if (col < 2) {
                        logWriter.write(" ");
                    }
                }
                logWriter.write("\n\n");
            }
            logWriter.close();
        } catch (IOException e) {
            System.err.println("Error: File not found");
        }
    }

    public void logText(String str) {
        File log = new File(file);
        log.setWritable(DOLOGGING);
        try {
            FileWriter logWriter = new FileWriter(log, true);
            logWriter.write(str + "\n");
            logWriter.close();
        } catch (IOException e) {
            System.err.println("Error: File not found");
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public int getTurns() {
        return turns;
    }

    public void playGame() {
        //logDate();
        for (int i = 0; i < 9; i++) {
            takeTurn();
            if (WinningBoards.containsWin(this, 0)) {
                System.exit(0);
            }
        }
    }

}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.IOException;
import java.nio.file.*;

public class WinningBoards {
    private static final char[][][] XWINS = {{{'x','x','x'},
                                              {' ',' ',' '},
                                              {' ',' ',' '}},
                                             {{' ',' ',' '},
                                              {'x','x','x'},
                                              {' ',' ',' '}},
                                             {{' ',' ',' '},
                                              {' ',' ',' '},
                                              {'x','x','x'}},
                                             {{'x',' ',' '},
                                              {'x',' ',' '},
                                              {'x',' ',' '}},
                                             {{' ','x',' '},
                                              {' ','x',' '},
                                              {' ','x',' '}},
                                             {{' ',' ','x'},
                                              {' ',' ','x'},
                                              {' ',' ','x'}},
                                             {{'x',' ',' '},
                                              {' ','x',' '},
                                              {' ',' ','x'}},
                                             {{' ',' ','x'},
                                              {' ','x',' '},
                                              {'x',' ',' '}}};
    private static final char[][][] OWINS = {{{'o','o','o'},
                                              {' ',' ',' '},
                                              {' ',' ',' '}},
                                             {{' ',' ',' '},
                                              {'o','o','o'},
                                              {' ',' ',' '}},
                                             {{' ',' ',' '},
                                              {' ',' ',' '},
                                              {'o','o','o'}},
                                             {{'o',' ',' '},
                                              {'o',' ',' '},
                                              {'o',' ',' '}},
                                             {{' ','o',' '},
                                              {' ','o',' '},
                                              {' ','o',' '}},
                                             {{' ',' ','o'},
                                              {' ',' ','o'},
                                              {' ',' ','o'}},
                                             {{'o',' ',' '},
                                              {' ','o',' '},
                                              {' ',' ','o'}},
                                             {{' ',' ','o'},
                                              {' ','o',' '},
                                              {'o',' ',' '}}};
    /*
    public static boolean containsWin(TicTacToe test) {
        TicTacToe win = new TicTacToe(XWINS[0]);
        if (!test.equals(win, 'x')) {
            return containsWin(test, 1);
        }
        System.out.println("X wins");
        return true;
    }*/

    public static boolean containsWin(TicTacToe test, int take) {
        String str = "";
        if (take >= 16) {
            return false;
        } else if (take < 8) {
            TicTacToe win = new TicTacToe(XWINS[take]);
            if (!test.equals(win)) {
                return containsWin(test, take + 1);
            }
            test.logText("X wins\n");
            System.out.println(test + "\nX wins");
            try {
                List<String> lines = Files.readAllLines(Paths.get("LargeLetters.txt"));
                for (int h = 0; h < test.getBoard().length; h++) {
                    char[] row = test.getBoard()[h];
                    char[] winningBoardRow = XWINS[take][h];
                    for (int i = 0; i < 16; i++) {
                        for (int j = 0; j < row.length; j++) {
                            char col = row[j];
                            if (winningBoardRow[j] == 'x') {
                                if (take < 3) {
                                    str += lines.get(i+16);
                                } else if (take < 6) {
                                    str += lines.get(i+32);
                                } else if (take == 6) {
                                    
                                } else if (take == 7) {
                                    
                                }
                            } else if (col == 'x') {
                                str += lines.get(i);
                            } else if (col == 'o') {
                                str += lines.get(i+80);
                            } else {
                                str += "                                ";
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
            } catch (IOException e) {
                System.err.println("File not found");
            }
            System.out.println(str);
            return true;
        } else {
            TicTacToe win = new TicTacToe(OWINS[take - 8]);
            if (!test.equals(win)) {
                return containsWin(test, take + 1);
            }
            test.logText("O wins\n");
            System.out.println(test + "\nO wins");
            return true;
        }
    }
}

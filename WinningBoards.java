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
        if (take >= 16) {
            return false;
        } else if (take < 8) {
            TicTacToe win = new TicTacToe(XWINS[take]);
            if (!test.equals(win)) {
                return containsWin(test, take + 1);
            }
            test.logText("X wins\n");
            System.out.println(test + "\nX wins");
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

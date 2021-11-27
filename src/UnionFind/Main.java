package UnionFind;


public class Main {
    public static void main(String[] args) {

        char[][] board = {
                new char[]{'X', 'X', 'X', 'X', '0'},
                new char[]{'X', 'X', 'X', '0', 'X'},
                new char[]{'0', '0', 'X', '0', 'X'},
                new char[]{'X', '0', 'X', 'X', 'X'},
        };

        //answer:
        /*
        * X X X X 0
        * X X X X X
        * 0 0 X X X
        * X 0 X X X
        * */

        new UFMatrixReplace().solve(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
}

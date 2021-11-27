package DFS;

//输入MxN的二维矩阵，其中包含字符X和O 找到矩阵中四面被X围住的O ，并且把它们替换成X
public class MatrixReplace {

    void dfs(char[][] board, int i, int j) {

        System.out.println("dfs board i = " + i +" j = " + j);

        int m = board.length;
        int n = board[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return;
        }

        if (board[i][j] != '0') {
            return;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j);
        dfs(board, i, j + 1);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            System.out.println("solve call dfs board i = " + i +" j = 0");
            dfs(board, i, 0);
            System.out.println("solve call dfs board i = " + i +" j = " + (n-1));
            dfs(board, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            System.out.println("solve call dfs board i = 0" +" j = " + j);
            dfs(board, 0, j);
            System.out.println("solve call dfs board i = " + (m-1) +" j = " + j);
            dfs(board, m - 1, j);
        }

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == '0') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = '0';
                }
            }
        }

    }
}

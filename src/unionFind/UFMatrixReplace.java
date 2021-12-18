package unionFind;

public class UFMatrixReplace {

    public void solve(char[][] board) {

        if (board.length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        UnionFind unionFind = new UnionFind(m * n + 1);
        int dummy = m * n;
        //首列末列的0与dummy连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == '0') {
                unionFind.union(n * i, dummy);
            }
            if (board[i][n-1] == '0') {
                unionFind.union(n * i + n - 1, dummy);
            }
        }

        //首行末行的0与dummy连通
        for (int j = 0; j < n; j++) {
            if (board[0][j] == '0') {
                unionFind.union(j, dummy);
            }
            if (board[m-1][j] == '0') {
                unionFind.union((m - 1) * n + j, dummy);
            }
        }

        //方向数组
        int[][] d = new int[][]{
                {1, 0},
                {0, 1},
                {0, -1},
                {-1, 0}
        };

        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == '0') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == '0') {
                            unionFind.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }

        //所有不和dummy连通的0 都需要被替换
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!unionFind.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}

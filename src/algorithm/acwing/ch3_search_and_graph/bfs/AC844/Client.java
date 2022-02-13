package algorithm.acwing.ch3_search_and_graph.bfs.AC844;

import java.util.Arrays;

//844.走迷宫
public class Client {

    private class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private static final int N = 110;
    private int n, m;
    private int[][] g;
    private int[][] d;
    private Pair[] q;
    private int hh, tt;

    private Pair[] dirs;

    public Client() {
        g = new int[N][N];
        d = new int[N][N];
        q = new Pair[N * N];
        dirs = new Pair[] {
            new Pair(-1, 0),
            new Pair(0, -1),
            new Pair(1, 0),
            new Pair(0, 1)
        };
    }

    public void testBFS() {
        n = m = 5;
        g = new int[][] {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0}
        };

        // n = m = 3;
        // g = new int[][] {
        //     {0, 1, 0},
        //     {0, 1, 0},
        //     {0, 0, 0}
        // };

        for(int i = 0; i < n; i++) {
            Arrays.fill(d[i], -1);
        }
        d[0][0] = 0;
        q[0] = new Pair(0, 0);
        hh = tt = 0;
        
        bfs();
    }

    private void bfs() {
        while(hh <= tt) {
            Pair h = q[hh++];

            for(Pair dir : dirs) {
                int newX = h.x + dir.x;
                int newY = h.y + dir.y;
                //element in array d should only be visited once !!!
                if(newX >= 0 && newX < n && newY >= 0 && newY < m && d[newX][newY] == -1 && g[newX][newY] == 0) {
                    d[newX][newY] = d[h.x][h.y] + 1;
                    q[++tt] = new Pair(newX, newY);
                }
            }
        }

        System.out.println(d[n - 1][m - 1]);
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.testBFS();
    }
}
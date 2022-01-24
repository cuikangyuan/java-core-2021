package algorithm.dfs.AC843;

//843 n皇后问题

public class Client2 {


    private static final int N = 20;
    private int n;

    private char[][] g;
    private boolean[] row, col, dg, udg;

    public Client2() {
        g = new char[N][N];
        row = new boolean[N];
        dg = new boolean[N];
        udg = new boolean[N];
    }

    private void dfs(int x, int y, int s) {
        if(y == n) {
            x ++;
            y = 0;
        }


        if(x == n) {
            if(s == n) {
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        System.err.print(g[i][j] + "\t");
                    }
                    System.out.println("");
                }
                System.out.println("----------------------------------------------------------");
            }
            return;
        }

        System.out.println("dfs enter !!! x = " + x + " y = " + y + " s = " + s);

        //not place a queue at this pos
        dfs(x, y + 1, s);

        //place a queue at this pos
        if(!row[x] && !col[y] && !udg[n - y + x] && !dg[y + x]) {
            row[x] = col[y] = udg[n - y + x] = dg[y + x] = true;
            g[x][y] =  'Q';
            dfs(x, y + 1, s + 1);
            row[x] = col[y] = udg[n - y + x] = dg[y + x] = false;
            g[x][y] =  '.';
        }
    }

    private void testNQueue() {
        n = 4;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }

        dfs(0, 0, 0);
    }

    public static void main(String[] args) {
    
        Client2 client2 = new Client2();
        client2.testNQueue();
    }
}
package algorithm.acwing.dfs.AC843;

//843 n皇后问题
public class Client {





    private static final int N = 20;
    private int n;
    private char[][] g;
    private boolean[] col, dg, udg;

    public Client() {
        g = new char[N][N];
        col = new boolean[N];
        dg = new boolean[N];
        udg = new boolean[N];
    }

    private void dfs(int u) {

        if(u == n) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(g[i][j] + "\t");
                }
                System.out.println("");
            }
            System.out.println("----------------------------------------------------------");
        } else {
            for(int j = 0; j < n; j++) {
                if(!col[j] && !dg[j + u] && !udg[n - j + u]) {
                    g[u][j] = 'Q';
                    col[j] = dg[j + u] = udg[n - j + u] = true;
                    dfs(u+1);
                    col[j] = dg[j + u] = udg[n - j + u] = false;
                    g[u][j] = '.';

                }
            }
        }

    }

    private void testNQueue() {
        n = 8;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(0);
    }

    public static void main(String[] args) {
        new Client().testNQueue();
    }
}
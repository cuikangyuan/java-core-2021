package algorithm.acwing.ch3_search_and_graph.floyd;


//854.Floyd求最短路
public class Client {
    
    private static final int N = 210;
    private static final int M = 20010;
    private static final int INF = 0x3f3f3f3f;

    private int n, m , q;
    private int g[][];

    public Client() {
        g = new int[N][N];
    }

    private void test() {
        n = 3;
        m = 3;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
               if(i == j) {
                   g[i][j] = 0;
               } else {
                   g[i][j] = INF;
               } 
            }
        }

        g[1][2] = 1;
        g[2][3] = 2;
        g[1][3] = 1;

        floyd();

        test_floyd(2, 1);

        test_floyd(1, 3);
    }

    private void test_floyd(int a, int b) {
        if (g[a][b] == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(g[a][b]);
        }
    }


    private void floyd() {
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {

                    // if(i != j && i != k && j != k && g[i][k] != INF && g[k][j] != INF) {
                    //     g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    // }
                    //判断连通性
                    if(g[i][k] != INF && g[k][j] != INF) {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        
        Client client = new Client();
        client.test();
    }
}

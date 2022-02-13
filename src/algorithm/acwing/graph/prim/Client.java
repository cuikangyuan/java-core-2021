package algorithm.acwing.graph.prim;

import java.util.Arrays;

//858.Prim算法求最小生成树
//如果是稠密图 直接使用朴素版Prim算法
//如果是稀疏图 使用Kruskal算法
public class Client {

    private static final int N = 510;
    private static final int M = 100010;
    private static final int INF = 0x3f3f3f3f;

    private int g[][];
    private int dist[];
    private boolean st[];

    private int n, m;

    public Client() {
        g = new int[N][N];
        dist = new int[N];
        st = new boolean[N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                g[i][j] = INF;
            }
        }

        for(int i = 0; i < N; i++) {
            dist[i] = INF;
        }

    }


    //返回最小生成树所有边的权重之和
    private int prim() {

        int res = 0;    

        // 每次找一个不在连通块里，并且到连通块距离最近的点
        for(int i = 0; i < n; i++) {
            
            int t = -1;
            for(int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            if(i > 0 && dist[t] == INF) return INF;
            if(i > 0) res += dist[t];

            for(int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }

            st[t] = true;

        }

        return res;
    }

    private void test_prim() {

        
        n = 4;
        m = 5;
        g[1][2] = 1;
        g[2][1] = 1;
        g[1][3] = 2;
        g[3][1] = 2;
        g[1][4] = 3;
        g[4][1] = 3;
        g[2][3] = 2;
        g[3][2] = 2;
        g[3][4] = 4;
        g[4][3] = 4;

        int res = prim();

        if(res == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }

    }


    public static void main(String[] args) {
    
        Client client = new Client();
        client.test_prim();
    }
}

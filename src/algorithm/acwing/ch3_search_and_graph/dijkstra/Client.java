package algorithm.acwing.ch3_search_and_graph.dijkstra;

//AC 849 Dijkstra求最短路径 I
public class Client {

    private static final int INF = 0x3f3f3f3f;

    private static final int N = 500;
    private static final int M = 10000;

    private int n;
    private int m;

    private int[][] g;
    private int[] dist;
    private boolean[] st;


    public Client() {
        g = new int[M][M];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                g[i][j] = Integer.MAX_VALUE;
            }
        }
        dist = new int[N];
        for(int i = 0; i < N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        st = new boolean[N];
    }

    public void testDijkstra() {
        n = m = 3;
        g[1][2] = 2;
        g[2][3] = 1;
        g[1][3] = 4;

        int ans = dijkstra();
        System.out.println(ans);

    }

    public int dijkstra() {

        dist[1] = 0;
        //could crash , because it affect the loop times in below , make t could be -1 when call st[t]
        //st[1] = true;

        for(int i = 0; i < n; i++) {

            int t = -1;
            for(int j = 1; j <= n; j++) {
                if(!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }

            st[t] = true;
            
            for(int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], (dist[t] + g[t][j]) < 0 ? Integer.MAX_VALUE : dist[t] + g[t][j]);
            }
        }

        if(dist[n] == Integer.MAX_VALUE) {
            return -1;        
        } else {
            return dist[n];
        }
    }

    public static void main(String[] args) {
    
        Client client = new Client();
        client.testDijkstra();
    }
}
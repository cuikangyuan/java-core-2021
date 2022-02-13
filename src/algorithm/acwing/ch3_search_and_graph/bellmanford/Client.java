package algorithm.acwing.ch3_search_and_graph.bellmanford;

import java.util.Arrays;


//AC 853 有边数限制的最短路
public class Client {

    private static final int N = 510;
    private static final int M = 100010;
    private static final int INF = 0x3f3f3f3f;


    private int m, n, k;
    private int[] dist, backup;
    private Edge[] edges;

    public class Edge {
        public int a;
        public int b;
        public int w;

        public Edge(int a, int b, int w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }
    }

    public Client() {
        n = 3;
        m = 3;
        k = 2;
        dist = new int[N];
        backup = new int[N];
        edges = new Edge[M];
        edges[0] = new Edge(1, 2, 1);
        edges[1] = new Edge(2, 3, 1);
        edges[2] = new Edge(1, 3, 3);
    }

    public int bellman_ford() {

        Arrays.fill(dist, INF);
        dist[1] = 0;

        for(int i = 0; i < k; i++) {
            //避免串联 影响最终结果
            backup = Arrays.copyOf(dist, dist.length);
            for(int j = 0; j < m; j++) {
                int a = edges[j].a;
                int b = edges[j].b;
                int w = edges[j].w;
                dist[b] = Math.min(dist[b], backup[a] + w);
            }

        }
        
        //路径存在负权回路的话 最短路径也不存在
        if(dist[n] > INF / 2) return -1;

        return dist[n];
    }

    public static void main(String[] args) {
    
        Client client = new Client();
        int res = client.bellman_ford();
        System.out.println(res);
    }
}

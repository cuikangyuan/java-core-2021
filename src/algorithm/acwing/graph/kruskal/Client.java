package algorithm.acwing.graph.kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//859.Kruskal算法求最小生成树
public class Client {

    private static final int N = 100010;
    private static final int M = 2 * 100010;
    private static final int INF = 0x3f3f3f3f;

    private List<Edge> edges = new ArrayList<>();
    private int[] p;//使用并查集还保存连通块

    private int n, m;
    private int cnt;
    private int res;

    private int find(int x) {
         
        if(p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        p[pa] = pb;
    }

    public Client() {
       // edges = new ArrayList<Edge>();
        p = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = i;
        }
    }


    private void test_kruskal() {
        n = 4;
        m = 5;

        edges.add(new Edge(1, 2, 1));
        edges.add(new Edge(2, 1, 1));
        edges.add(new Edge(1, 3, 2));
        edges.add(new Edge(3, 1, 2));
        edges.add(new Edge(1, 4, 3));
        edges.add(new Edge(4, 1, 3));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 2, 2));
        edges.add(new Edge(3, 4, 4));
        edges.add(new Edge(4, 3, 4));

        kruskal();

        if(cnt < n - 1) {
            System.out.println("impossible");
        } else {
            System.out.println(res);
        }
    }

    private void kruskal() {

        Collections.sort(edges);

        for(int i = 0; i < edges.size(); i++) {

            Edge e = edges.get(i);
            int a = e.a;
            int b = e.b;
            int w = e.w;
            
            if(find(a) != find(b)) {
                res += w;
                p[find(a)] = find(b);
                cnt++;    
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.test_kruskal();
    }
}

class Edge implements Comparable<Edge> {

    public int a;
    public int b;
    public int w;

    public Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }

    @Override
    public int compareTo(Edge o) {
        return this.w - o.w;
    }

}

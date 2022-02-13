package algorithm.acwing.ch3_search_and_graph.spfa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//851. spfa求最短路
public class Client {
    
    private static final int INF = 0x3f3f3f3f;
    private static final int N = 100010;
    
    private int n, m;

    private int[] h, e, ne, w;
    private int idx;

    private boolean[] st;
    private int[] dist;

    private void add_edge(int a, int b, int weight) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = weight;
        h[a] = idx ++;
    }

    public Client() {
        n = m = 3;

        h = new int[N];
        e = new int[N];
        ne = new int[N];
        w = new int[N];
        st = new boolean[N];
        dist = new int[N];
        

        Arrays.fill(dist, INF);
        Arrays.fill(h, -1);
        
        add_edge(1, 2, 5);
        add_edge(2, 3, -3);
        add_edge(1, 3, 4);
    }

    private void test() {
        spfa();

        if(dist[n] == INF) {
            System.out.println("impossible");
        } else {
            System.out.println(dist[n]);
        }
    }

    private void spfa() {

        Queue<Integer> queue = new ArrayDeque();
        dist[1] = 0;
        st[1] = true;
        queue.add(1);

        while(queue.size() > 0) {
            
            int t = queue.poll();
            st[t] = false;

            for(int i = h[t]; i != -1; i = ne[i]) {
                int b = e[i];
                if(dist[b] > dist[t] + w[i]) {
                    dist[b] = dist[t] + w[i];
                    if(!st[b]) {
                        st[b] = true;
                        queue.add(b);
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

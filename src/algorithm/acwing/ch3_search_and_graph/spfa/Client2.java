package algorithm.acwing.ch3_search_and_graph.spfa;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//852. spfa判断负环
public class Client2 {
    
    private static final int INF = 0x3f3f3f3f;
    private static final int N = 100010;
    
    private int n, m;

    private int[] h, e, ne, w;
    private int idx;

    private boolean[] st;
    private int[] dist;
    private int[] cnt;

    private void add_edge(int a, int b, int weight) {
        e[idx] = b;
        ne[idx] = h[a];
        w[idx] = weight;
        h[a] = idx ++;
    }

    public Client2() {
        n = m = 3;

        h = new int[N];
        e = new int[N];
        ne = new int[N];
        w = new int[N];
        st = new boolean[N];
        dist = new int[N];
        cnt = new int[N];

        //Arrays.fill(dist, INF);
        Arrays.fill(h, -1);
        
        add_edge(1, 2, -1);
        add_edge(2, 3, 4);
        add_edge(3, 1, -5);
    }

    private void test() {

        if(spfa()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private boolean spfa() {

        Queue<Integer> queue = new ArrayDeque();


        for(int i = 1; i <= n; i++) {
            st[i] = true;
            queue.add(i);
        }

        //dist[1] = 0;
        while(queue.size() > 0) {
            
            int t = queue.poll();
            st[t] = false;

            for(int i = h[t]; i != -1; i = ne[i]) {
                int b = e[i];
                if(dist[b] > dist[t] + w[i]) {
                    dist[b] = dist[t] + w[i];
                    cnt[b] = cnt[t] + 1;
                    if(cnt[b] >= n) {
                        return true;
                    }
                    if(!st[b]) {
                        st[b] = true;
                        queue.add(b);
                    }   
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
    
        Client2 client = new Client2();
        client.test();
    }
}

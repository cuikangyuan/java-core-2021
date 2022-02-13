package algorithm.acwing.ch3_search_and_graph.bfs.AC848;

import java.util.Arrays;

//848.有向图的拓扑排序
public class Client {

    private static final int N = 100010;

    private int n, m;
    
    private int h[], e[], ne[], idx;

    private int q[], d[], hh, tt;


    public Client() {
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        q = new int[N];
        d = new int[N];

        Arrays.fill(h, -1);
        //Arrays.fill(d, 0);
        hh = 0;
        tt = -1;
    }

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx ++;
        d[b]++;
    }

    public void testTopSort() {

        n = 3;
        m = 3;

        add(1, 2);
        add(2, 3);
        add(1, 3);
        //add(3, 1);

        if(topSort()) {
            for(int i = 0; i < n; i++) {
                System.out.print(q[i] + " ");
            }
        } else {
            System.out.println("top sort not exists !!! ");
        }
    }
    
    public boolean topSort() {

        for(int i = 1; i <= n; i++) {
            if(d[i] == 0) {
                q[++tt] = i;
            }
        }

        while(hh <= tt) {
            int qh = q[hh++];
            for(int i = h[qh]; i != -1; i = ne[i]) {
                int dest = e[i];
                d[dest]--;

                if(d[dest] == 0) {
                    q[++tt] = dest;
                }
            }
        }

        // for(int i = 1; i <= n; i++){
        //     System.out.print(d[i] + " ");
        // }

        //all in queue when top sort exists
        return tt == n-1;
    }

    public static void main(String[] args) {
    
        Client client = new Client();
        client.testTopSort();
    }
}
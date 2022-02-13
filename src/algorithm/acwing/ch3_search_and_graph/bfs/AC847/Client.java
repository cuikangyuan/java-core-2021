package algorithm.acwing.ch3_search_and_graph.bfs.AC847;

import java.util.Arrays;

//847.图中点的层次
public class Client {


    private static final int N = 100010;
    private int[] h, e, ne;
    private int n, m, idx;

    private int[] d;
    private int[] q;
    private int hh, tt;


    public Client() {
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        d = new int[N];
        q = new int[N];
        Arrays.fill(h, -1);
        Arrays.fill(d, -1);
    }

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public void testBFS() {

        add(1, 2);
        add(2, 3);
        add(3, 4);
        add(1, 3);
        add(1, 4);

        add(4, 5);

        d[1] = 0;
        q[0] = 1;
        hh = tt = 0;
        n = 5;
        m = 6;

        if(bfs()) {
            System.out.println(d[n]);
        } else {
            System.out.println("-1");
        }
    }

    private boolean bfs() {

        while(hh <= tt) {
            int t = q[hh++];
            
            for(int i = h[t]; i != -1; i = ne[i]) {

                int j = e[i];

                if(d[j] == -1) {
                    d[j] = d[t] + 1;
                    q[++tt] = j;
                }
            }

        }

        return tt == n - 1;
    }

    public static void main(String[] args) {
        
        Client client = new Client();
        client.testBFS();
    }    
}
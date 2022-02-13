package algorithm.acwing.ch3_search_and_graph.dfs.AC846;

import java.util.Arrays;

//846.树的重心
public class Client {


    private static final int N = 10010;
    //private static final int NN = 1000000010;
    private int n;

    private int[] h, e, ne;
    private int idx;
    private boolean[] st;

    private int ans = Integer.MAX_VALUE;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public Client() {
        h = new int[N];
        e = new int[N * N];
        ne = new int[N * N];
        st = new boolean[N];
        Arrays.fill(h, -1);
    }

    public void testDFS() {

        /** 
         * 9
         * 1 2
         * 1 7
         * 1 4
         * 2 8
         * 2 5
         * 4 3
         * 3 9
         * 4 6
         * **/
        n = 9;
        add(1, 2);        
        add(2, 1);

        add(1, 7);
        add(7, 1);
        
        add(1, 4);
        add(4, 1);
        
        add(2, 8);
        add(8, 2);

        add(2, 5);
        add(5, 2);

        add(4, 3);
        add(3, 4);

        add(3, 9);
        add(9, 3);

        add(4, 6);
        add(6, 4);

        dfs(1);

        System.out.println(ans);
    }

    //以u为根的子树的点的数量
    private int dfs(int u) {

        st[u] = true;
        int sum = 1;
        int res = 0;

        for(int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if(!st[j]) {
                st[j] = true;
                int s = dfs(j);
                res = Math.max(res, s);
                sum += s;
            }
        }

        res = Math.max(res, n - sum);//剩余连通块中点数的最大值

        ans = Math.min(ans, res);//使剩余连通块中点数的最大值 最小

        return sum;
        

    }

    public static void main(String[] args) {
        Client client = new Client();
        client.testDFS();
    }
}
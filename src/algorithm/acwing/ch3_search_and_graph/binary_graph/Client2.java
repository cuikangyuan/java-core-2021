package algorithm.acwing.ch3_search_and_graph.binary_graph;


import java.util.Arrays;

//861.匈牙利算法-二分图的最大匹配 O(m*n)
//最大匹配是指最终子图中边的数量，最大匹配是指子图中的边不存在两条边共用同一个点
public class Client2 {

    private static final int N = 510;
    private static final int M = 100010;

    private int n1, n2, m;

    private int[] h, e, ne;
    private int idx;

    private int[] match;//当前右侧点对应的左侧点
    private boolean[] st;//判重

    private int res;

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public Client2() {
        h = new int[N];
        e = new int[M];
        ne = new int[M];
        match = new int[N];
        st = new boolean[N];
    }


    public void test() {
        n1 = 2;
        n2 = 2;
        m = 4;
        add(1, 1);
        //add(1, 2);
        add(2, 1);
        add(2, 2);

        for (int i = 1; i <= n1; i++) {

            Arrays.fill(st, false);
            if (find(i)) {
                res ++;
            }
        }

        System.out.println(res);
    }

    private boolean find(int x) {

        for (int i = h[x]; i != -1; i++) {
            int j = e[i];
            if (!st[j]) {
                st[j] = true;
                if (match[j] <= 0 || find(match[j])) {
                    match[j] = x;
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Client2 client2 = new Client2();
        client2.test();
    }
}

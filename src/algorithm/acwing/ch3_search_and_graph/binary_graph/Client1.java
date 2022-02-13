package algorithm.acwing.ch3_search_and_graph.binary_graph;


import java.util.Arrays;

//860.染色法判定二分图 O(m + n)
public class Client1 {

    private static final int N = 100010;
    private static final int M = 2 * N;

    private int n, m;
    private int[] h, e, ne, color;
    private int idx;

    public Client1() {
        h = new int[N];
        Arrays.fill(h, -1);
        e = new int[M];
        ne = new int[M];
        color = new int[N];

    }

    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;

    }
    private void test() {
        n = 4;
        m = 4;
        add(1, 3);
        add(3, 1);
        add(1, 4);
        add(4, 1);
        add(2, 3);
        add(3, 2);
        add(2, 4);
        add(4, 2);

        boolean flag = true;

        for (int i = 1; i <= n; i++) {
            if (color[i] <= 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                };
            }
        }

        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private boolean dfs(int u, int c) {

        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int t = e[i];
            if (color[t] <= 0) {
                if (!dfs(t, 3 - c)) {
                    return false;
                }
            } else if (color[t] > 0 && color[t] == c) {
                return false;
            }
        }

        return true;
    }

    //dfs 时间复杂度是线性的
    public static void main(String[] args) {
        Client1 client1 = new Client1();
        client1.test();
    }
}

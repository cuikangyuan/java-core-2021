package algorithm.acwing.trie;

public class Trie {

    int N = 100010;
    int[][] son;
    int[] cnt;
    int idx;//下标是0的点 既是根节点 ，也是空节点

    public Trie() {
        son = new int[N][26];
        cnt = new int[N];
        idx = 0;
    }

    public void insert(char[] chars) {
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            int u = chars[i] - 'a';
            if (son[p][u] <= 0) {
                son[p][u] = ++idx;
            }
            p = son[p][u];
        }
        cnt[p]++;
    }

    public int query(char[] chars) {
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            int u = chars[i] - 'a';
            if (son[p][u] <= 0) {
                return 0;
            }
            p = son[p][u];
        }

        return cnt[p];
    }

}

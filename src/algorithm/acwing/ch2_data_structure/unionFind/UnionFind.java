package algorithm.acwing.ch2_data_structure.unionFind;

public class UnionFind {

    private int count;//记录连通分量
    private int[] parent;//节点x的父节点是parent[x]
    private int[] size;//记录树的重量

    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = i;//节点i为根的树有i个节点
        }
    }

    public void union(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);

        if (rootP == rootQ) {
            return;
        }
        //两棵树合并为一棵
        //parent[rootQ] = rootP; 也可以
//        parent[rootP] = rootQ;

        //小树接到大树下面，较平衡
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }

        count--;
    }

    private int findRoot(int x) {
        //根节点的parent[x] = x
//        while (parent[x] != x) {
//            x = parent[x];
//        }

        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }


    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        int rootP = findRoot(p);
        int rootQ = findRoot(q);
        return rootP == rootQ;
    }

}

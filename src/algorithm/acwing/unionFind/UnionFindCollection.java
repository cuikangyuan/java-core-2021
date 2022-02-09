package algorithm.acwing.unionFind;

//836.合并集合
public class UnionFindCollection {

    private int N = 100010;

    private int[] p;

    public UnionFindCollection() {
        p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = i;
        }
    }

    //返回x的祖宗节点+路径压缩
    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        p[px] = py;
    }

    private void inSameCollection(int x, int y) {
        int px = find(x);
        int py = find(y);

        if (px == py) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {

        UnionFindCollection unionFindCollection = new UnionFindCollection();
        unionFindCollection.union(1, 2);
        //unionFindCollection.union(3, 2);
        unionFindCollection.union(3, 4);

        unionFindCollection.inSameCollection(1, 2);
        unionFindCollection.inSameCollection(1, 3);
        unionFindCollection.inSameCollection(3, 4);
    }
}

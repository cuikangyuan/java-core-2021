package algorithm.acwing.ch2_data_structure.unionFind;

//837.连通块中点的数量
public class UnionFindCollection2 {

    private int N = 100010;
    private int[] p;
    private int[] count;


    public UnionFindCollection2() {
        p = new int[N];
        count = new int[N];
        for(int i = 0; i < N; i++) {
            p[i] = i;
        }

        for(int i = 0; i < N; i++) {
            count[i] = 1;
        };
    }

    private int find(int x) {
        if(p[x] != x) {
           p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        p[pi] = pj;
        count[pj] += count[pi];
    }

    private int getUnionBlockItemCount(int x) {
        int px = find(x);
        System.out.println(count[px]);
        return count[px];
    }

    private void isConnected(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if(pi == pj) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void main(String[] args) {
    

        UnionFindCollection2 unionFindCollection2 =  new UnionFindCollection2();
        unionFindCollection2.union(1, 2);
        unionFindCollection2.isConnected(1, 2);
        //query count of index 1 -> 2
        unionFindCollection2.getUnionBlockItemCount(1);
        unionFindCollection2.union(2, 5);
        //query count of index 5 -> 3 
        unionFindCollection2.getUnionBlockItemCount(5);

    }
}
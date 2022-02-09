package algorithm.acwing.linkedListByArray;

public class DeLinkedList {

    private int N = 10010;
    private int[] e;
    private int[] l;
    private int[] r;
    private int idx;

    public DeLinkedList() {
        e = new int[N];
        l = new int[N];
        r = new int[N];
        //index 0表示左端点 1表示右端点
        r[0] = 1;
        l[1] = 0;
        idx = 2;
    }

    public void print() {
        int cur = 0;
        while(r[cur] != 1) {
            System.out.print(e[r[cur]] + " ");
            cur = r[cur];
        }
        System.out.println(" ");
    }


    //在下标是k的点的右面插入x
    public void add(int k, int x) {
        e[idx] = x;
        l[idx] = k;
        r[idx] = r[k];
        l[r[k]] = idx;
        r[k] = idx;
        idx++;
    }

    //删除下标是k的节点
    public void remove(int k) {
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
}

package algorithm.linkedListByArray;

public class DeLinkedList {

    private int N = 100010;
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

    //在下标是k的点的右面插入x
    public void add(int k, int x) {

    }

    //删除第k个节点
    public void remove(int k) {

    }
}

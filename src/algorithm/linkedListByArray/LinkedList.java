package algorithm.linkedListByArray;

public class LinkedList {

    private int N = 100010;
    private int head;
    private int idx;
    private int[] e;
    private int[] ne;


    public LinkedList() {
        e = new int[N];
        ne = new int[N];
        head = -1;
        idx = 0;
    }

    //将x插到头结点
    public void add_to_head(int x) {
        e[idx] = x;
        ne[idx] = head;
        head = idx++;
    }

    //将x插到下标是k的点后面
    public void add(int k, int x) {
        e[idx] = x;
        ne[idx] = ne[k];
        ne[k] = idx++;
    }

    //将下标是k的点后面的点删除
    public void remove(int k) {
        ne[k] = ne[ne[k]];
    }

    public int reverse() {
        if (isEmpty()) {
            return head;
        }
        int pre = -1, cur = head, nxt = head;
        while (cur != -1) {
            nxt = ne[cur];
            ne[cur] = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public boolean isEmpty(int hh) {
        return hh == -1;
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("List Empty");
        } else {
            int cur = head;
            while (cur != -1) {
                System.out.print(e[cur] + " ");
                cur = ne[cur];
            }
            System.out.println("");
        }
    }

    public void print(int hh) {
        if (isEmpty(hh)) {
            System.out.println("List Empty");
        } else {
            int cur = hh;
            while (cur != -1) {
                System.out.print(e[cur] + " ");
                cur = ne[cur];
            }
            System.out.println("");
        }
    }


}

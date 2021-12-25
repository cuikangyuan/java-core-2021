package algorithm.monotonousQueue;

public class Client {
    public static void main(String[] args) {
        int N = 100010;
        int[] q = new int[N];
        int hh = 0, tt = -1;

        //window size = 3
        //1 3 -1 -3 5 3 6 7
        int k = 3;
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};

        for (int i = 0; i < a.length; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] >= a[i]) {
                tt--;
            }
            q[++tt] = i;

            if (i >= k - 1) {
                //min element index
                //System.out.print(q[hh] + " ");
                //min element value
                System.out.print(a[q[hh]] + " ");
            }
        }

        System.out.println("");

        hh = 0; tt = -1;
        for (int i = 0; i < a.length; i++) {
            if (hh <= tt && i - k + 1 > q[hh]) {
                hh++;
            }
            while (hh <= tt && a[q[tt]] <= a[i]) {
                tt--;
            }
            q[++tt] = i;

            if (i >= k - 1) {
                //max element index
                //System.out.print(q[hh] + " ");
                //max element value
                System.out.print(a[q[hh]] + " ");
            }
        }
    }
}

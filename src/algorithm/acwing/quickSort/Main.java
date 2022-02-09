package algorithm.acwing.quickSort;

public class Main {
    public static void main(String[] args) {

        int[] a = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};

        new Main().quick_sort(a, 0, a.length-1);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }

    public void quick_sort(int[] q, int l, int r) {
        if (l >= r) return;
        int x = q[l];
        int i = l - 1;
        int j = r + 1;
        while (i < j) {

            do {i++;} while(q[i] < x);
            do {j--;} while(q[j] > x);
            if (i < j) {
                swap(q, i, j);
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j+1, r);

    }
}

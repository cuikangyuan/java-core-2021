package algorithm.mergeSort;

public class Main {

    int[] a = {9, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1};
    int[] temp = new int[a.length];


    public static void main(String[] args) {

        Main main = new Main();
        main.merge_sort();
    }

    public void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private void merge_sort() {
        merge_sort(a, 0, a.length - 1);
        printArray(a);
    }

    private void merge_sort(int[] a, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;

        merge_sort(a, l, mid);
        merge_sort(a, mid + 1, r);

        int k = 0;
        int i = l;
        int j = mid + 1;
        while (i <= mid && j <= r) {
            if (a[i] <= a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }

        while (i <= mid) temp[k++] = a[i++];
        while (j <= r) temp[k++] = a[j++];

        for (i = l, j = 0 ; i <= r; i++, j++) {
            a[i] = temp[j];
        }

    }

    public void swap(int[] q, int i, int j) {
        int temp = q[i];
        q[i] = q[j];
        q[j] = temp;
    }
}

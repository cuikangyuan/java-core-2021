package algorithm.acwing.ch1_basic.bSearch;

//整数二分
public class Main {

    int a[] = {1, 2, 3, 3, 3, 6, 7, 8, 9};

    public static void main(String[] args) {
        new Main().b_search();
    }

    private void b_search() {
        int target = 3;
        int l = 0;
        int r = a.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
//            int mid = (l + r) >> 2;
            if (a[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (a[l] != target) {
            System.out.println("-1 -1");
        } else {
            System.out.print(l + " ");
            l = 0;
            r = a.length - 1;
            while (l < r) {
                int mid = l + (r - l + 1) / 2;//caution !!! (+ 1)
                if (a[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            System.out.println(l);
        }
    }
}

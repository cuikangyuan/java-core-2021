package algorithm.pancakeSort;

import java.util.LinkedList;

public class PancakeSort {

    public LinkedList<Integer> res = new LinkedList<>();

    public LinkedList<Integer> pancakeSort(int[] cakes) {
        sort(cakes, cakes.length);
        return res;
    }

    public void sort(int[] cakes, int n) {
        //base case
        if (n == 1) {
            return ;
        }

        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i< n; i++) {
            if (cakes[i] > maxCake) {
                maxCake = cakes[i];
                maxCakeIndex = i;
            }
        }
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);

        reverse(cakes, 0, n-1);
        res.add(n);

        sort(cakes, n-1);
    }

    public void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}

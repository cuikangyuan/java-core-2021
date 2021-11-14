package pancakeSort;

public class Main {

    public static void main(String[] args) {
        int[] a = {3, 2, 4, 1};

        PancakeSort pancakeSort = new PancakeSort();
        pancakeSort.sort(a, a.length);
        System.out.println(pancakeSort.res);

    }

}

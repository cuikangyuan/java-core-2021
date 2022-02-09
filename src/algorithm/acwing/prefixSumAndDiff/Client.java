package algorithm.acwing.prefixSumAndDiff;

import java.util.Scanner;

public class Client {

    public static final int N = 1000010;

    public static void main(String[] args) {
        Client client = new Client();
        client.test();

    }

    private void test() {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        //int m = scanner.nextInt();

        int n = 6;
        int m = 3;

        int[] a = new int[N];
        int[] b = new int[N];

        //1 2 2 1 2 1
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
            //a[i] = i;
        }
        System.out.print("a = ");
        printArray(a, n);

        //use insert to fill diff array
        for (int i = 1; i <= n; i++) {
            insert(b, i, i, a[i]);
        }
        System.out.print("b = ");
        printArray(b, n);

//        int l = 1, r = 2, c = 9;
//        insert(b, l, r, c);
//        l = 2; r = 3; c = 1;
//        insert(b, l, r, c);
//        l = 4; r = 5; c = -8;
//        insert(b, l, r, c);
//        l = 1; r = 1; c = 1;
//        insert(b, l, r, c);
//        l = 1; r = 5; c = 10;
//        insert(b, l, r, c);
//        l = 5; r = 5; c = -3;
//        insert(b, l, r, c);

        //System.out.print("after: b = ");
        //printArray(b, n);

        int l = 1, r = 3, c = 1;
        insert(b, l, r, c);
        l = 3; r = 5; c = 1;
        insert(b, l, r, c);
        l = 1; r = 6; c = 1;
        insert(b, l, r, c);


        for (int i = 1; i <= n; i++) {
            b[i] = b[i-1] + b[i];
        }
        //3 4 5 3 4 2
        System.out.print("after: a = ");
        printArray(b, n);
    }

    private void insert(int[] b, int l, int r, int c) {
        b[l] += c;
        b[r+1] -= c;
    }

    private void printArray(int[] res, int length) {
        for(int i = 1; i <= length; i++) {
            System.out.print(String.valueOf(res[i]) + " ");
        }
        System.out.println("");
    }
}

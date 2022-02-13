package algorithm.acwing.ch1_basic.prefixSumAndDiff;

import java.util.Scanner;

public class Client2 {

    public static final int N = 1010;

    public static void main(String[] args) {
        Client2 client = new Client2();
        client.test();

    }

    /*
    * 3 4 3
    * 1 2 2 1
    * 3 2 2 1
    * 1 1 1 1
    * 1 1 2 2 1
    * 1 3 2 3 2
    * 3 1 3 4 1
    *
    * answer
    * 2 3 4 1
    * 4 3 4 1
    * 2 2 2 2
    * */

    private void test() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        //int n = 6;//row
        //int m = 3;//column
        scanner.nextLine();
        int[][] a = new int[N][N];
        int[][] b = new int[N][N];

        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.print("a = \n");
        printArray(a, n, m);

        //use insert to fill diff array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(b, i, j, i, j, a[i][j]);
            }
        }
        System.out.print("b = \n");
        printArray(b, n, m);


        //System.out.print("after: b = ");
        //printArray(b, n);

        int x1 = 1, y1 = 1, x2 = 2, y2 = 2, c = 1;
        insert(b, x1, y1, x2, y2, c);
        x1 = 1; y1 = 3; x2 = 2; y2 = 3; c = 2;
        insert(b, x1, y1, x2, y2, c);
        x1 = 3; y1 = 1; x2 = 3; y2 = 4; c = 1;
        insert(b, x1, y1, x2, y2, c);


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                b[i][j] +=  b[i - 1][j] + b[i][j -1] - b[i -1][j - 1];
            }
        }

        System.out.print("after: a = \n");
        printArray(b, n, m);
    }

    private void insert(int[][] b, int x1, int y1, int x2, int y2,  int c) {
        b[x1][y1] += c;
        b[x1][y2 + 1] -= c;
        b[x2 + 1][y1] -= c;
        b[x2 + 1][y2 + 1] += c;
    }

    private void printArray(int[][] res, int row, int column) {
        for(int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                System.out.print(String.valueOf(res[i][j]) + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}

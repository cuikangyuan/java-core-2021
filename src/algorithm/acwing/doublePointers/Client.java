package algorithm.acwing.doublePointers;

import java.util.Scanner;

public class Client {

    public static final int N = 100000;

    public static void main(String[] args) {


        Client client = new Client();
//        client.basicDoublePointers();
        client.longestSubString();
    }

    private void basicDoublePointers() {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (str == null || str.length() == 0) {
            return;
        }

        char[] chars = str.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            int j = i;
            while (j < length && chars[j] != ' ') j++;

            //certain logic
            System.out.println(str.substring(i, j));
            i = j;
        }
    }

    private void longestSubString() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] a = new int[N];
        int[] s = new int[N];

        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            s[a[i]] ++;
            while (s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }

        System.out.println("max substring length: " + res);
    }

    private void printArray(int[] res, int length) {
        if (res == null || res.length == 0) {
            return;
        }
        for (int i = 0; i < length; i++) {
            System.out.print(String.valueOf(res[i]) + " ");
        }

    }
}

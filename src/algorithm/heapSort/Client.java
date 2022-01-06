package algorithm.heapSort;

import java.util.Scanner;

//838 heap sort
public class Client {
    
    private static final int N = 100010;
    private int[] h;
    private int n = 0;
    private int m = 0;
    private int size = 0;

    /*
    5 3
    4 5 1 3 2
    */
    public Client() {
        h = new int[N];
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.sort();
    }

    private void up(int u) {

    }

    private void down(int u) {
        int t = u;
        if(u * 2 <= size && h[u * 2] < h[t]) {
            t = u * 2;
        }

        if(u * 2 + 1 <= size && h[u * 2 + 1] < h[t]) {
            t = u * 2 + 1;
        }

        if(u != t) {
            swap(u, t);
            down(t);
        }

    }

    private void swap(int i, int j) {
        int t = h[i];
        h[i] = h[j];
        h[j] = t;
    }

    private void sort() {

        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        size = n;
        scanner.nextLine();
        for(int i = 1; i <= size; i++) {
            h[i] = scanner.nextInt();
        }


        //O(n)
        for(int i = size / 2; i >= 1; i--) {
            down(i);
        }

        // for(int i = 1; i <= size; i++) {
        //     System.out.print(h[i] + " ");
        // }

        while(m-- > 0) {
            System.out.print(h[1] + " ");
            h[1] = h[size];
            size--;
            down(1);
        }
    }

}
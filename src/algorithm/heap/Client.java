package algorithm.heap;

import java.util.Scanner;

//839 heap simulation
public class Client {


    private static final int N = 100010;
    private int[] h;
    private int m = 0;
    private int size = 0;

    private int[] ph;
    private int[] hp;

    /*
    10
    66 4 5 1 23 3 2 7 9 1 
    */
    public Client() {
        h = new int[N];
        ph = new int[N];
        hp = new int[N];
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.insert(4);
        client.insert(5);
        client.insert(1);
        client.insert(3);
        client.insert(2);


        //client.deleteMin();
        //client.deleteMin();

        client.deleteKthItem(1);
        // client.deleteKthItem(2);
        // client.deleteKthItem(4);
        // client.deleteKthItem(5);
        
        // client.modifyKthItem(1, 9);
        // client.modifyKthItem(2, 8);
        // client.modifyKthItem(3, 7);
        // client.modifyKthItem(4, 6);
        // client.modifyKthItem(5, 5);
        client.printf();
    }

    private void up(int u) {
        while(u / 2 > 0  && h[u] < h[u / 2]) {
            swap(u, u / 2);
            u = u / 2;
        }
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
        int t = 0;
        
        t = ph[hp[i]];
        ph[hp[i]] = ph[hp[j]];
        ph[hp[j]] = t;


        t = hp[i];
        hp[i] = hp[j];
        hp[j] = t;

        t = h[i];
        h[i] = h[j];
        h[j] = t;


    }

    private void insert(int x) {
        size++;
        m++;
        ph[m] = size;
        hp[size] = m;
        h[size] = x;
        up(size);
    }

    private void deleteMin() {
        swap(1, size);
        size--;
        down(1);
    }

    
    private void deleteKthItem(int k) {

        int idx = ph[k];
        swap(idx, size);
        size--;
        down(idx);
        up(idx);

    }

    private void modifyKthItem(int k, int x) {
        int idx = ph[k];
        h[idx] = x;
        down(idx);
        up(idx);
    }


    private void printf() {
        int m = size;
        while(m-- > 0) {
            System.out.print(h[1] + " ");
            h[1] = h[size];
            size--;
            down(1);
        }
    }
    private void sort() {

        // Scanner scanner = new Scanner(System.in);
        // n = scanner.nextInt();
        // size = n;
        // scanner.nextLine();
        // for(int i = 1; i <= size; i++) {
        //     h[i] = scanner.nextInt();
        // }


        // //O(n)
        // for(int i = size / 2; i >= 1; i--) {
        //     down(i);
        // }


        // int m = size;
        // while(m-- > 0) {
        //     System.out.print(h[1] + " ");
        //     h[1] = h[size];
        //     size--;
        //     down(1);
        // }
    }
}

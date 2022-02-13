package algorithm.acwing.ch2_data_structure.hashTable1;

import java.util.Arrays;

//840.模拟散列表
/*
1
2
3
2
5
*/
public class Client {

    private static final int N = 100003;
    private int[] h;
    private int[] e;
    private int[] ne;
    private int idx = 0;

    public Client() {
        h = new int[N];
        e = new int[N];
        ne = new int[N];
        // Arrays.fill(ne, -1);
        Arrays.fill(h, -1);
    }

    private int hash(int x) {
        return (x % N + N) % N;
    }

    private void insert(int x) {
        int hash = hash(x);
        e[idx] = x;
        ne[idx] = h[hash];
        h[hash] = idx; 
        idx++;

    }

    private void findAndPrint(int x) {
        int hash = hash(x);
        int t = h[hash];
        while(t != -1) {
            if(e[t] == x) {
                System.out.println("Yes");
                return;
            }
            t = ne[t];
        }

        System.out.println("No");
    }

    private boolean find(int x) {
        int k = hash(x);
        for(int i = h[k]; i != -1; i = ne[i]) {
            if(e[i] == x) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
    

        Client client = new Client();
        client.insert(1);
        client.insert(2);
        client.insert(3);
        
        // System.out.println(client.find(2));
        // System.out.println(client.find(5));

        client.findAndPrint(1);
        client.findAndPrint(5);
        
    }
}
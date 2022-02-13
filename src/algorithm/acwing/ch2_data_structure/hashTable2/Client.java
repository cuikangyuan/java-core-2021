package algorithm.acwing.ch2_data_structure.hashTable2;

import java.util.Arrays;

//840.模拟散列表
public class Client {
    //usually double the element range
    //200000
    private static final int N = 200003;
    private int[] h;
    private static final int none = Integer.MAX_VALUE; 
    public Client() {
        h = new int[N];
        Arrays.fill(h, Integer.MAX_VALUE);
    }

    public int find(int x) {
        int k = (x % N + N) % N;
        while(h[k] != none && h[k] != x) {
            k++;
            if(k == N) {
                k = 0;
            }
        }
        return k;
    }

    public void findAndPrint(int x) {
        int k = find(x);
        if(h[k] == x) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public void insert(int x) {
        int k = find(x);
        h[k] = x;
    }

    public static void main(String[] args) {

        Client client = new Client();
        client.insert(1);
        client.insert(2);
        client.insert(3);

        client.findAndPrint(2);
        client.findAndPrint(1);
        client.findAndPrint(3);
        client.findAndPrint(5);

        //2147483647
        //1000000000
        // System.out.println(Integer.MAX_VALUE - (1e9 + 1));
        
        
        // for(int i = 200000; ; i++) {
        //     boolean flag = true;
        //     for(int j = 2; j * j <= 200000; j++) {
        //         if(i % j == 0) {
        //             flag = false;
        //             break;
        //         }
        //     }
        //     if(flag) {
        //         System.out.println(i);
        //         break;
        //     }
        // }
    }
}
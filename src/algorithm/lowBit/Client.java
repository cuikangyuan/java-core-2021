package algorithm.lowBit;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
    
        Client client = new Client();
        //0001
        //0010
        //0011
        //0100
        //1100
        //1111
        int[] a = new int[] {1, 2, 3, 4, 5, 15};
        
        client.printNumberOfOne(a);
    }

    private void printNumberOfOne(int[] a) {
        int length = a.length;
        for(int i = 0; i < length; i++) {
            int res = 0;
            int t = a[i];
            int lowBit = lowBit(t);
            while(lowBit > 0) {
                t -= lowBit;
                res++;
            }
            System.out.print(res + " ");
        }
    }

    private int lowBit(int x) {
        return x & (-x);
    }
    
}
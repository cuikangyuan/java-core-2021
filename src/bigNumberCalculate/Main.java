package bigNumberCalculate;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // int[] a = {9, 9, 1};//199
        // int[] b = {2, 1};//12

        int[] a = {1};
        int[] b = {9};
    
        int[] res = new Main().add1(a, b);        
        for(int i = res.length - 1; i >= 0; i--) {
            if(res[i] != -1) System.out.print(String.valueOf(res[i]));
        }
    }

    private int[] add1(int[] a, int[] b) {

        int aL = a.length;
        int bL = b.length;
        
        int[] result = new int[Math.max(aL, bL) + 1];
        Arrays.fill(result, -1);
        int t = 0;
        
        int i = 0;
        for(i = 0; i < a.length && i < b.length; i++) {
            result[i] =  (a[i] + b[i] + t) % 10;
            t = (a[i] + b[i] + t) / 10;
        }

        while(i < a.length) {
            result[i] = (a[i] + t) % 10;
            t = (a[i] + t) / 10;
            i++;
        }

        while(i < b.length) {
            result[i] = (b[i] + t) % 10;
            t = (b[i] + t) / 10;
            i++;
        }

        if(t > 0) {
            result[i] = 1;
        }

        return result;
    }
}

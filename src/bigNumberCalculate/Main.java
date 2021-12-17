package bigNumberCalculate;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // int[] a = {9, 9, 1};//199
        // int[] b = {2, 1};//12

        int[] a = {1,9};
        int[] b = {9,9};
    
        Main main = new Main();
        int[] res = main.add(a, b);        
        main.printArray(res);

        System.out.println("a >= b : " + main.cmp(a, b));

    }

    private void printArray(int[] res) {
        if(res == null || res.length == 0) {
            return;
        }
        for(int i = res.length - 1; i >= 0; i--) {
            if(res[i] != -1) System.out.print(String.valueOf(res[i]));
        }
        System.out.println("");
    }

    //return whether a >= b
    private boolean cmp(int[] a, int[] b) {
        int aL = a == null ? 0 : a.length;
        int bL = b == null ? 0 : b.length;
        if(aL <= 0) {
            return !(bL > 0);
        }
        if(bL <= 0) {
            return aL >= 0;
        }

        //aL > 0 && bL > 0
        if(aL != bL) {
            return aL > bL;
        } else {
            
            for(int i = aL - 1; i >= 0; i--) {
                if(a[i] < b[i]) {
                    return false;
                }
            }
        }

        return true;
        
    }

    private int[] sub(int[] a, int[] b) {
        int[] res = null;
        return res;
    }

    private int[] add(int[] a, int[] b) {

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

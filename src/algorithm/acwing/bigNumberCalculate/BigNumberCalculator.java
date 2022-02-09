package algorithm.acwing.bigNumberCalculate;

import java.util.Arrays;


public class BigNumberCalculator {


    public void testMul(int[] a, int b) {
        printArray(a);
        System.out.print(" * " + b + " = ");
        printArray(mul(a, b));
        System.out.println("");
    }

    public void testDiv(int[] a, int b) {
        printArray(a);
        System.out.print(" / " + b + " = ");
        DivResult divResult = div(a, b);
        printArray(divResult.divRes);
        System.out.print(" ------ " + divResult.t);
        System.out.println("");
    }


    public int[] mul(int[] a, int b) {
        int aL = a.length;
        int[] res = new int[aL + 1];
        int t = 0;
        for (int i = 0; i < aL; i++) {
            res[i] = (a[i] * b + t) % 10;
            t = (a[i] * b + t) / 10;
        }
        if (t > 0) {
            res[aL] = t;
        }
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] == 0) {
                res[i] = -1;
            } else {
                break;
            }
        }
        return res;
    }

    public DivResult div(int[] a, int b) {
        DivResult divResult = new DivResult();
        int aL = a.length;
        int[] res = new int[aL];
        int t = 0;// balance
        for (int i = aL - 1; i >= 0; i--) {
            res[i] = (t * 10 + a[i]) / b;
            t = (t * 10 + a[i]) % b;
        }
        for (int i = res.length - 1; i > 0; i--) {
            if (res[i] == 0) {
                res[i] = -1;
            } else {
                break;
            }
        }
        divResult.divRes = res;
        divResult.t = t;
        return divResult;
    }

    public void testAdd(int[] a, int[] b) {

        printArray(a);
        System.out.print(" + ");
        printArray(b);
        System.out.print(" = ");
        printArray(add(a, b));
        System.out.println("");
    }


    public void testSub(int[] a, int[] b) {
        printArray(a);
        System.out.print(" - ");
        printArray(b);
        System.out.print(" = ");
        if (!cmp(a, b)) {
            System.out.print("-");
        }
        printArray(sub(a, b));
        System.out.println("");
    }

    private void printArray(int[] res) {
        if (res == null || res.length == 0) {
            return;
        }
        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] != -1) System.out.print(String.valueOf(res[i]));
        }

    }

    //return whether a >= b
    private boolean cmp(int[] a, int[] b) {
        int aL = a == null ? 0 : a.length;
        int bL = b == null ? 0 : b.length;
        if (aL <= 0) {
            return !(bL > 0);
        }
        if (bL <= 0) {
            return aL >= 0;
        }

        //aL > 0 && bL > 0
        if (aL != bL) {
            return aL > bL;
        } else {

            for (int i = aL - 1; i >= 0; i--) {
                if (a[i] < b[i]) {
                    return false;
                }
            }
        }

        return true;

    }

    private int[] sub(int[] a, int[] b) {


        if (cmp(a, b)) {
            int aL = a.length;
            int bL = b.length;

            int[] result = new int[Math.max(aL, bL)];
            Arrays.fill(result, 0);
            for (int i = 0, t = 0; i < aL; i++) {
                t = a[i] - t;
                if (i < bL) t = t - b[i];
                result[i] = (t + 10) % 10;
                if (t < 0) {
                    t = 1;
                } else {
                    t = 0;
                }
            }
            for (int i = result.length - 1; i > 0; i--) {
                if (result[i] == 0) {
                    result[i] = -1;
                } else {
                    break;
                }
            }
            return result;
        } else {
            return sub(b, a);
        }

    }

    private int[] add(int[] a, int[] b) {

        int aL = a.length;
        int bL = b.length;

        int[] result = new int[Math.max(aL, bL) + 1];
        Arrays.fill(result, -1);
        int t = 0;

        int i = 0;
        for (i = 0; i < a.length && i < b.length; i++) {
            result[i] = (a[i] + b[i] + t) % 10;
            t = (a[i] + b[i] + t) / 10;
        }

        while (i < a.length) {
            result[i] = (a[i] + t) % 10;
            t = (a[i] + t) / 10;
            i++;
        }

        while (i < b.length) {
            result[i] = (b[i] + t) % 10;
            t = (b[i] + t) / 10;
            i++;
        }

        if (t > 0) {
            result[i] = 1;
        }

        return result;
    }


}
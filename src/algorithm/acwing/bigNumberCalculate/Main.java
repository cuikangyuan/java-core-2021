package algorithm.acwing.bigNumberCalculate;


public class Main {

    public static void main(String[] args) {
        // int[] a = {9, 9, 1};//199
        // int[] b = {2, 1};//12

        int[] a = {4, 4, 1};
        int[] b = {1, 9};
    
        BigNumberCalculator calculator = new BigNumberCalculator();
//        calculator.testAdd(a, b);
//        calculator.testSub(a, b);

        int c = 12;
//        calculator.testMul(a, c);
        calculator.testDiv(a, c);

    }


    
}

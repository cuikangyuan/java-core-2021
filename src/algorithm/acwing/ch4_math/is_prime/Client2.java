package algorithm.acwing.ch4_math.is_prime;

//867.分解质因数
public class Client2 {

    public static void divide(int n) {

        System.out.print(n + " = ");
        for (int i = 2; i <= n / i; i++) {
            //i 一定是质数
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) {
                    n = n / i;
                    s ++;
                }
                System.out.print(i + "^" + s + " ");
            }
        }
        if (n > 1) {
            System.out.print(n + "^" + 1 + " ");
        }
    }

    public static void main(String[] args) {


        divide(220);
    }
}

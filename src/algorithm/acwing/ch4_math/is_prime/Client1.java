package algorithm.acwing.ch4_math.is_prime;

//866.试除法判定质数
public class Client1 {

    public static boolean is_prime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

//      System.out.println(is_prime(1));
//        System.out.println(is_prime(2));
//        System.out.println(is_prime(3));
//        System.out.println(is_prime(4));
        System.out.println(is_prime(5));
//        System.out.println(is_prime(6));
    }
}

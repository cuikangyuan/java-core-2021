package algorithm.acwing.ch4_math.get_primes;

//868.筛质数
public class Client {


    private static final int N = 1000010;

    //普通筛法求素数
    public static void get_primes1(int n) {
        int[] primes = new int[N];
        boolean[] st = new boolean[N];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
                //优化：只筛掉质数的倍数也可
//                for (int j = i + i; j <= n; j += i) {
//                    st[j] = true;
//                }
            }

            for (int j = i + i; j <= n; j += i) {
                st[j] = true;
            }
        }

        System.out.println("cnt = " + cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.print(primes[i] + " ");
        }
    }

    //线性筛法求素数
    public static void get_primes2(int n) {
        int[] primes = new int[N];
        boolean[] st = new boolean[N];
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes[cnt++] = i;
            }

            for (int j = 0; primes[j] <= n / i; j++) {
                st[primes[j] * i] = true;
                if (i % primes[j] == 0) {
                    break;
                }
            }
        }

        System.out.println("cnt = " + cnt);
        for (int i = 0; i < cnt; i++) {
            System.out.print(primes[i] + " ");
        }
    }

    public static void main(String[] args) {
        get_primes1(7);

        System.out.println("");
        get_primes2(7);
    }
}

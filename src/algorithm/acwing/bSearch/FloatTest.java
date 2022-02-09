package algorithm.acwing.bSearch;

public class FloatTest {

    public static void main(String[] args) {

        //3 -> 1.732
        double x = 3;
        x = 0.1;
        double l = 0;
        double r = x;

        while (r - l > 1e-10) {
            double mid = l + (r - l) / 2;
            if (mid * mid >= x) {
                r = mid;
            } else {
                l = mid;
            }
        }

        System.out.println(l);

    }



}

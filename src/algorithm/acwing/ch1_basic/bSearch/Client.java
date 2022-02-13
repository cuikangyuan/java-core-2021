package algorithm.acwing.ch1_basic.bSearch;

public class Client {
    public static void main(String[] args) {

        Client client = new Client();

        System.out.println(client.mySqrt(8));

    }

    public int mySqrt(int x) {

        if(x == 1) {
            return 1;
        }
        int l = 0, r = x/2;
        int mid = 0;
        while(l < r) {
            mid = l + (r - l + 1) / 2;
            if((long)mid * mid <= x) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}

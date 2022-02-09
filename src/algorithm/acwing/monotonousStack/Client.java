package algorithm.acwing.monotonousStack;

public class Client {

    public static void main(String[] args) {
        int N  = 100010;
        int[] array = {3, 4, 2, 7, 5};
        int length = array.length;
        int[] stk = new int[N];
        int tt = 0;

        for(int i = 0; i < length; i++) {
            while(tt > 0 && stk[tt] >= array[i]) {
                tt--;
            }
            if(tt > 0) {
                System.out.print(stk[tt] + " ");
            } else {
                System.out.print("-1 ");
            }
            stk[++tt] = array[i];
        }


    }
}

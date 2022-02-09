package algorithm.acwing.stringMatch;

public class KMP {

    public void find(char[] s, int m, char[] p, int n) {

        int[] ne = new int[p.length];

        //求next数组
        for (int i = 2, j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j + 1]) {
                j = ne[j];
            }
            if (p[i] == p[j + 1]) {
                j++;
            }
            ne[i] = j;
        }



        //匹配过程
        for (int i = 1, j = 0; i <= m; i++) {
            while (j > 0 && p[j + 1] != s[i]) {
                j = ne[j];
            }

            if (s[i] == p[j + 1]) {
                j++;
            }

            if (j == n) {
                //匹配成功
                System.out.print(i - n + " ");
                j = ne[j];
            }
        }
    }
}

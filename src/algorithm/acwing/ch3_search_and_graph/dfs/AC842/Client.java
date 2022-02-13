package algorithm.acwing.ch3_search_and_graph.dfs.AC842;

import java.util.Scanner;

//842.排列数字
public class Client {

    private int[] path;
    private boolean[] str;
    private int n;

    private void dfs(int u) {
        if(u == n) {
            for(int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println("");
        } else {

            for(int i = 1; i <= n; i++) {
                if(!str[i]) {
                    str[i] = true;
                    path[u] = i;
                    dfs(u+1);
                    str[i] = false;
                }
            }
        }
    }

    private void fullArrangement() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        path = new int[n + 3];
        str = new boolean[n + 3];

        dfs(0);


    }

    public static void main(String[] args) {
            
        new Client().fullArrangement();
    }
    
}
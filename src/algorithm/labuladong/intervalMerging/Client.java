package algorithm.labuladong.intervalMerging;

//see link : https://leetcode-cn.com/problems/merge-intervals/
public class Client {
    public static void main(String[] args) {

        Client client = new Client();
        client.merge_intervals();
    }

    private void merge_intervals() {

        int[][] intervals = {
            {1, 2},
            {2, 4},
            {5, 6},
            {7, 8},
            {7, 9}
        };

        int st = Integer.MIN_VALUE, ed = Integer.MAX_VALUE;

    }
    
}
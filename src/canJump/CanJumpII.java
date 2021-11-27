package canJump;

import java.util.Arrays;

public class CanJumpII {

    private int[] memo;

    public int jump1(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);
        return dp(nums, 0);
    }

    private int dp(int[] nums, int p) {

        int n = nums.length;

        if (p >= n - 1) {
            return 0;
        }

        if (memo[p] != n) {
            return memo[p];
        }

        int steps = nums[p];

        for (int i = 1; i <= steps; i++) {
            int subProblem = dp(nums, p + i);
            memo[p] = Math.min(memo[p], subProblem + 1);
        }

        return memo[p];
    }



    public int jump2(int[] nums) {
        int n = nums.length;
        //from index i, the farthest index can jump to
        int end = 0;
        //from index i to end, the farthest distance can touch
        int farthest = 0;
        //how many times you jumped
        int jumps = 0;

        for (int i = 0; i < n -1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}

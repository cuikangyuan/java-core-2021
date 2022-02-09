package algorithm.labuladong.canJump;

public class CanJumpI {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        System.out.println("length = " + n);
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            System.out.println("i = "  + i + ", num[i] = " + nums[i] + ", farthest = " + farthest);
            if (farthest <= i) {
                return false;
            }
        }

        return farthest >= n-1;
    }
}

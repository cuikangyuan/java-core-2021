package subarraySum;

public class SubArraySum {

    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n+1];
        sum[0] = 0;
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        int ans = 0;
        //all subarray
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                //sum of num[j, i-1] = sum of num[0, i-1] - sum of num[0, j-1]
                if (sum[i] - sum[j] == k) {
                    ans ++;
                }
            }
        }

        return ans;

    }
}

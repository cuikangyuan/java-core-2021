package subarraySum;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        SubArraySum subArraySum = new SubArraySum();

        int i = subArraySum.subarraySum(nums, 2);
        System.out.println(i);
    }
}

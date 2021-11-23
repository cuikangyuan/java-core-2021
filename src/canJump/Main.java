package canJump;

public class Main {

    public static void main(String[] args) {

//        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
//        int[] nums = {5, 5, 5, 5, 5};
//        boolean canJump = new CanJumpI().canJump(nums);
//        System.out.println(canJump);

        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {5, 5, 5, 5, 5};

        int jump = new CanJumpII().jump1(nums);
        System.out.println(jump);

        int jump2 = new CanJumpII().jump2(nums);
        System.out.println(jump2);

    }
}

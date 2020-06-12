package LeetCode;

/**
 * LeetCode 152
 *
 */
public class MaximumProductSubarray152 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,-4,-3};
        int res = maxProduct(nums);
        System.out.println(res);
    }
    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res = nums[0];
        max[0] = nums[0] ;
        min[0] = nums[0];
        for(int i = 1;i < nums.length ; i ++){
            if(nums[i] >= 0){
                max[i] = Math.max(max[i - 1] * nums[i] , nums[i]);
                min[i] = Math.min(min[i - 1] * nums[i] , nums[i]);

            }
            else{
                max[i] = Math.max(min[i - 1] * nums[i] , nums[i]);
                min[i] = Math.min(max[i - 1] * nums[i] , nums[i]);
            }
            res = Math.max(res , max[i]);
        }
        return res;
    }
}

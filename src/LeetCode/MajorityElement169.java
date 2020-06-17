package LeetCode;

public class MajorityElement169 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,3,2,3,3};
        int res = majorityElement(nums);
        System.out.println(res);
    }
    public static int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0 ;
        }
        int major = nums[0];
        int time = 1;
        for(int i = 1;i < nums.length ; i ++){
            if(nums[i] == major){
                time ++;
            }
            else{
                time --;
                if(time == 0){
                    major = nums[i];
                    time ++;
                }
            }
        }
        return major ;
    }
}

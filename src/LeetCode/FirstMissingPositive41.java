package LeetCode;

/**
 * LeetCode 41
 * 题意：给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 * 示例 1:
 * 输入: [1,2,0]
 * 输出: 3
 * 示例 2:
 * 输入: [3,4,-1,1]
 * 输出: 2
 * 示例 3:
 * 输入: [7,8,9,11,12]
 * 输出: 1
 * 提示：
 * 你的算法的时间复杂度应为O(n)，并且只能使用常数级别的额外空间。
 * 思路：如果能使用O(N)的空间，那很简单，并且时间击败100% ， 8.33%
 *      但是不符合提示要求，要使用常数空间，就要对输入数组原地修改，设置一条规则
 *      对于数值在[1,n]之间的元素，将其放到正确的位置上，也就是1，应该放在位置0上，
 *      即nums[nums[i] - 1] 放到nums[i]上，所以对于没有在正确位置上的，就要进行交换，
 *      最后遍历数组，如果nums[i] != i + 1, 就代表是缺失的元素，
 *      如果遍历完数组，数组元素都在正确的位置上了，那就说明缺失的是n + 1 ,如[3,1,2],缺失4
 *      87.52% , 8.33%
 */
public class FirstMissingPositive41 {
    public static void main(String[] args) {
         int[] nums = {-1,3,1,4};
         int res = firstMissingPositive_1(nums);
        System.out.println(res);
    }
    // 时间复杂度O(N),空间复杂度O(N),虽然也能通过，但是不符合常数空间的要求
    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int[] tmp = new int[nums.length];
        for(int i = 0;i < nums.length ; i ++){
            if(nums[i] <= 0 || nums[i] > nums.length){
                continue ;
            }
            tmp[nums[i] - 1] = 1;
        }
        for(int i = 0;i < tmp.length ; i ++){
            if(tmp[i] != 1){
                return i + 1 ;
            }
        }
        return nums.length + 1 ;
    }
    //时间复杂度O(N),空间复杂度O(1)
    public static int firstMissingPositive_1(int[] nums){
        int n = nums.length;
        for(int i = 0;i < n; i ++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0;i < n; i ++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return n + 1;
    }
}

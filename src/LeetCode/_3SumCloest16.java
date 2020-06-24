package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 16
 * 题意：给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 思路：首先对数组进行排序，
 *      然后与求三数之和相似，外层i控制三数中的最左边的数，内存start,end控制另外两个数
 *      将ans = nusms[0] + nums[1] + nums[2],sum记录之和遍历到的每三个数的和
 *      当|sum - target| < |ans - target|时，更新ans,
 *      根据sum 与 target的大小关系，移动start , end，或者sum == target,return sum
 *      86.06% , 6.82%
 */
public class _3SumCloest16 {
    public static void main(String[] args) {
        int[] nums = {1,2,-4,-1};
        int target = 1;
        int res = threeSumClosest(nums , target);
        System.out.println(res);
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0;i < nums.length - 2; i ++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum ;
                }
                if(sum > target){
                    end --;
                }
                else if(sum < target){
                    start ++ ;
                }
                else{
                    return sum ;
                }
            }
        }
        return ans ;
    }
}

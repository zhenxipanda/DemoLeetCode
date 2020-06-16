package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 167
 * 题意：给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 思路：因为是升序并且答案唯一，所以比较简单。
 *      从头和尾向中间遍历
 *      类似于二分的思想，nums[left] + nums[right] > target , right --;
 *      nums[left] + nums[right] < target , left ++;
 *      nums[left] + nums[right] == target ,给数组赋值，return
 *      97.14% , 6.67% 
 */
public class TwoSum2_InputArrayIsSorted167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(numbers , target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers == null || numbers.length == 0){
            return res ;
        }
        int left = 0 , right = numbers.length - 1;
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                res[0] = left + 1;
                res[1] = right + 1;
                return res ;
            }
            else if(numbers[left] + numbers[right] > target){
                right -- ;
            }
            else{
                left ++;
            }
        }
        return res;
    }
}

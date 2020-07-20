package LeetCode;

import java.util.Arrays;

/***
 * LeetCode 167
 * 题意：
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 * 思路：比较简单，
 *      利用两个下标，一个指向最左端，一个指向最右端，
 *      比较他们与target的值，两者向中间移动，
 *      95.52% , 6.67%
 */
public class TwoSumii_InputArrayIsSorted167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int[] res = twoSum(numbers , target);
        System.out.println(Arrays.toString(res));
    }
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int left = 0 , right = numbers.length - 1;
        // 两者向中间移动
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                res[0] = left + 1;
                res[1] = right + 1;
                break;
            }
            // 和 < target， left 右移
            else if(numbers[left] + numbers[right] < target){
                left ++;
            }
            // 和 > target， right 左移
            else{
                right --;
            }
        }
        return res;
    }
}

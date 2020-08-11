package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 448
 * 题意：
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 * 思路：题目中明确说了不能使用额外空间，所以原地操作，
 *      由于只需要判断哪些元素不存在，就相当于判断另一些元素存在，
 *      对于存在的元素，如4，它的下标应该为4-1=3，所以将下标3的元素做标记，
 *      如何做标记？如果此元素大于0，就让其置为相反数，小于0，说明前面存在重复元素，已经标记过了，忽略
 *      最后遍历数组，对于元素大于0的，就是没做标记的，也就是缺失的，需要注意，缺失的元素是下标 + 1
 *      71.16% , 73.64%
 */
public class FindAllNumbersDisappearedInAnArray448 {
    public static void main(String[] args) {
        int[] nums = {7,4,5,3,2,1,1};
        List<Integer> res = findDisappearedNumbers(nums);
        System.out.println(res);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length ; i ++){
            int nId = Math.abs(nums[i]) - 1;
            if(nums[nId] > 0){
                nums[nId] *= -1 ;
            }
        }
        for(int i = 1; i <= nums.length ; i ++){  //因为对i-1操作，所以这里要<=
            if(nums[i - 1] > 0){
                list.add(i);
            }
        }
        return list;
    }
}

package JianZhiOffer;
/**
 * 剑指offer 61
 * 题意：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 * 限制：
 * 数组长度为 5 
 * 数组的数取值为 [0, 13] .
 * 思路：先排序，统计0的个数，统计相邻元素之间的差值-1,gap，如果0的个数> gap ，return true
 *      否则，false;
 *      91.53% , 94.26%
 */

import java.util.Arrays;

public class interview61 {
    public static void main(String[] args) {
        int[] nums = {1,2,0,0,5};
        boolean res = isStraight(nums);
        System.out.println(res);
    }
    public static boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int numOfZero = 0 ,index = 0 ,gap = 0;
        while (index < nums.length && nums[index] == 0){
            numOfZero ++ ;
            index ++ ;
        }
        if(index == nums.length - 1 || index == nums.length){
            return true;
        }
        index ++ ;
        while (index < nums.length){
            if(nums[index] == nums[index - 1]){
                return false;
            }
            gap += nums[index] - nums[index - 1] - 1;
            index ++ ;
        }
        if(numOfZero >= gap){
            return true;
        }
        return false;
    }
}

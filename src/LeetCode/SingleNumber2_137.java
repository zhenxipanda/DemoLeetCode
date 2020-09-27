package LeetCode;

/**
 * LeetCode 137
 * 题意：给定一个非空整数数组，除了某个元素只出现一次以外，
 * 其余每个元素均出现了三次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例 1:
 * 输入: [2,2,3,2]
 * 输出: 3
 * 示例 2:
 * 输入: [0,1,0,1,0,1,99]
 * 输出: 99
 * 思路：重新定义计数规则，需要画图总结出规则
 *      100% , 47.48%
 */
public class SingleNumber2_137 {
    public static void main(String[] args) {
        int[] nums = {2,1,2,2};
        int res = singleNumber(nums);
        System.out.println(res);
    }
    public static int singleNumber(int[] nums){
        int one = 0, two = 0;
        for(int num : nums){
            one = (one ^ num) & (~two);
            two = (two ^ num) & (~one);
        }
        return one;
    }
}

package JianZhiOffer;

/**
 * 剑指offer 56-2
 * 题意：在一个数组 nums 中除一个数字只出现一次之外，
 * 其他数字都出现了三次。请找出那个只出现一次的数字。
 * 示例 1：
 * 输入：nums = [3,4,3,3]
 * 输出：4
 * 示例 2：
 * 输入：nums = [9,1,7,9,7,9,7]
 * 输出：1
 * 限制：
 * 1 <= nums.length <= 10000
 * 1 <= nums[i] < 2^31
 * 思路：关于异或，x^0=x, x^1 = ~x
 *      写状态表，n , two , one 三个输入， two , one 两个输出
 *      96.22% , 98.95%
 */
public class interview56_2 {
    public static void main(String[] args) {
        int[] nums = {3,4,3,3};
        int res = singleNumber(nums);
        System.out.println(res);
    }
    public static int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for(int num : nums){
            b = (b ^ num) & (~a);
            a = (a ^ num) & (~b);
        }
        return b;
    }
}

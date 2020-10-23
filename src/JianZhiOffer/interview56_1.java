package JianZhiOffer;

import java.util.Arrays;

/**
 * 剑指offer 56-1
 * 题意：一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * 限制：
 * 2 <= nums.length <= 10000
 * 思路：整体异或，得到最低位的1，按照此位是否为1进行分组
 *      组内分别异或，
 *      96.00% , 88.52%
 */
public class interview56_1 {
    public static void main(String[] args) {
        int[] nums = {1,2,6,2};
        int[] res = singleNumbers(nums);
        System.out.println(Arrays.toString(res));
    }
    public static int[] singleNumbers(int[] nums){
        int sum = 0;
        for(int num : nums){
            sum ^= num;
        }
        int one = sum & (-sum);    // 获得最低位的1，按照此位是否为1，对数组进行分组
        int[] res = new int[2];
        for(int num : nums){
            if((num & one) == 1){
                res[0] ^= num ;
            }
            else{
                res[1] ^= num ;
            }
        }
        return res;
    }
}

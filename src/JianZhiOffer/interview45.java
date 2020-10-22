package JianZhiOffer;

import java.util.Arrays;

/**
 * 剑指offer 45
 * 题意：输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 示例 1:
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * 提示:
 * 0 < nums.length <= 100
 * 说明:
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 * 思路：关键在于定义数组排序规则，字符串数组按照b+a> a+b的降序排列
 *      65.23% , 94.88%
 */
public class interview45 {
    public static void main(String[] args) {

    }
    public static String minNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] str = new String[nums.length];
        for(int i = 0;i < nums.length; i ++){
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str , (a , b)->(a + b).compareTo(b + a));
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < nums.length; i ++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}

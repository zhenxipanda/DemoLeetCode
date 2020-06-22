package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode 179
 * 题意：给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * 示例 1:
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 思路：难点在于对数组定义特殊的降序排序规则
 *      要比较的是a1 + a2 是否 < a2 + a1，
 *      所以要先把int[] -> Stirng[]，再定义Arrays.sort()排序规则
 *      另外排完序拼接后，需要判断sb.charAt(0) == '0',如果是的话，直接return "0";
 *      31.33% ， 10.00% ，时间复杂度O(NlgN),空间复杂度O(N)
 */
public class LargestNumber179 {
    public static void main(String[] args) {
        int[] nums = {10,25,36};
        String res = largestNumber(nums);
        System.out.println(res);
    }
    public static String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] strs = new String[nums.length];
        for(int i = 0;i < nums.length; i ++){
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuffer sb = new StringBuffer();
        for(int i = 0;i < strs.length;i ++){
            sb.append(strs[i]);
        }
        String res = sb.toString();
        if(res.charAt(0) == '0'){
            return "0";
        }
        return res;
    }
}

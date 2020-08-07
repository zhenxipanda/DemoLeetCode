package LeetCode;

/**
 * LeetCode 409
 * 题意：
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * 示例 1:
 * 输入:
 * "abccccdd"
 * 输出:
 * 7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 思路：主要是统计每个字符出现多少次，构成回文串的是，次数为偶数的，次数为奇数的只能有一个，
 *      用int[128]数组统计每个元素出现的次数，A:65,a:97
 *      再次遍历数组，统计出现次数为奇数的元素个数,res
 *      判断res == 0 ? 如果是，说明字符串中的元素出现次数都是偶数，
 *      如果不是，就用字符串的长度 - res + 1，长度 - res，代表剩下的元素都是偶数次数，
 *      +1 是因为一个奇数字符可以放到回文串的中间位置，满足回文串性质
 *      100% , 32.43%
 */
public class LongestPalindrome409 {
    public static void main(String[] args) {
        String s = "abcccdd";
        int res = longestPalindrome(s);
        System.out.println(res);
    }
    public static int longestPalindrome(String s){
        int[] count = new int[128];
        int res = 0;
        for(char c : s.toCharArray()){
            count[c] ++;
        }
        for(int c : count){
            res += (c & 1);
        }
        return res == 0 ? s.length() : s.length() - res + 1;
    }
}

package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 455
 * 题意：
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，
 * 这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 注意：
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 * 示例 1:
 * 输入: [1,2,3], [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * 输入: [1,2], [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * 思路：比较简单
 *      先对两个数组进行排序，双指针遍历两个数组，
 *      若满足s[j]>=g[i]，说明能分给这个孩子，res ++,i，j后移
 *      否则,j后移，因为要兼顾孩子，并且这个时候饼干小，所以它后移
 *      96.00% , 37.58%
 */
public class AssignCookies455 {
    public static void main(String[] args) {
        int[] g = {2,3,1};
        int[] s = {5,4};
        int res = findContentChildren(g , s);
        System.out.println(res);
    }
    public static int findContentChildren(int[] g, int[] s) {
        int m = g.length , n = s.length;
        int i = 0, j = 0 , res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(i < m && j < n){
            if(s[j] >= g[i]){
                res ++;
                i ++;
                j ++;
            }
            else{
                j ++;
            }
        }
        return res;
    }
}

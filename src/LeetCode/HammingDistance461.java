package LeetCode;

/**
 * LeetCode 461
 * 题意：
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 * 注意：
 * 0 ≤ x, y < 2^31.
 * 示例:
 * 输入: x = 1, y = 4
 * 输出: 2
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 * 上面的箭头指出了对应二进制位不同的位置。
 * 思路：汉明距离就是两个数字二进制位的不同，那可以用异或
 *      然后再统计异或中1的个数，n & (n-1)把n最右边的一位1置为0
 *      100% , 14.08%
 */
public class HammingDistance461 {
    public static void main(String[] args) {

    }
    public static int hammingDistance(int x, int y) {
        int ans = x ^ y;
        int count = 0;
        while(ans != 0){
            ans = ans & (ans - 1);
            count ++;
        }
        return count;
    }
}

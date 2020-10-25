package JianZhiOffer;

/**
 * 剑指offer 62
 * 题意：0,1,,n-1这n个数字排成一个圆圈，从数字0开始，
 * 每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，
 * 则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * 示例 1：
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * 输入: n = 10, m = 17
 * 输出: 2
 * 限制：
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * 思路：f(n-1,m)留下的元素序号以0开头，因此该元素在f(n,m)中的位置相差m，
 *      最后保留的元素在每次序列中都保留，长n-1的序列保留的元素右移m距离即为长为n的序列保留的序号
 *      99.99% , 97.54%
 */
public class interview62 {
    public static void main(String[] args) {
        int n = 10 , m = 17;
        int res = lastRemaining(n, m);
        System.out.println(res);
    }
    public static int lastRemaining(int n, int m) {
        int res = 0;
        for(int i = 2 ; i <= n ; i ++){
            res = (res + m) % i;
        }
        return res;
    }
}

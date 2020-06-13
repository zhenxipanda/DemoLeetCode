package LeetCode;

/**
 * LeetCode 70
 * 题意：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 思路：多些几个数就能发现规律，f(3)=f(2)+f(1),f(4)=f(3)+f(2)......
 *      总结起来就是f(n)=f(n-1)+f(n-2),第一次跳1级，还剩下n-1级 + 第一次跳2级，还剩下n-2级
 *      如果用递归，会存在大量重复，所以用迭代，所有的数据都是从1,2推导出来的
 *      100% , 5.66%
 */
public class ClimbingStairs70 {
    public static void main(String[] args) {
        int n = 5;
        int res = climbStairs(n);
        System.out.println(res);
    }
    public static int climbStairs(int n) {
        if(n <= 2){
            return n ;
        }
        int first = 1 ;
        int second = 2;
        int res = 0;
        for(int i = 2;i < n; i ++){
            res = first + second ;
            first = second ;
            second = res ;
        }
        return res;
    }
}

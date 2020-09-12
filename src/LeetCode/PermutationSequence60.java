package LeetCode;

/**
 * LeetCode 60
 * 题意：给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 说明：
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * 思路：递归，关键在于计算offset , group,三目运算符一定加()
 *      通过group找到应该加入的数字
 *      69.93% , 91.96%
 */
public class PermutationSequence60 {
    public static void main(String[] args) {
        int n = 4 ,k = 3;
        String res = getPermutation(n , k);
        System.out.println(res);
    }
    public static String getPermutation(int n, int k){
        boolean[] visited = new boolean[n];
        return rec(n , f(n - 1) , k , visited);
    }

    private static String rec(int n, int f, int k, boolean[] visited) {
        int offset = k % f;
        int group = k / f + (offset > 0 ? 1 : 0);   // 三目运算符要用()括起来
        int i = 0;
        for(;i < visited.length && group > 0 ; i ++){
            if(!visited[i]){
                group -- ;
            }
        }
        visited[i - 1] = true;
        if(n - 1 > 0){
            return String.valueOf(i) + rec(n - 1 , f / (n - 1) , offset == 0 ? f :offset , visited);
        }
        else{
            return String.valueOf(i);
        }
    }

    private static int f(int m) {
        int res = 1;
        for(int i = 2; i <= m; i ++){
            res *= i;
        }
        return res;
    }
}

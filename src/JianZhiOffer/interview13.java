package JianZhiOffer;

import java.util.Arrays;

/**
 * 剑指offer 13
 * 题意：地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * 思路：(x + 1) % 10 ，必须加()
 *      83.87% ， 85.25%
 */
public class interview13 {
    public static void main(String[] args) {
         int m = 11;
         int n = 8;
         int k = 16;
        System.out.println(movingCount(m , n , k));
    }
    public static int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        return dfs(0 , 0 , 0 , 0 , m , n , k, flag);
    }

    private static int dfs(int x, int y, int s1, int s2, int m, int n, int k, boolean[][] flag) {
        if(x == 10 && y == 7){
            System.out.println(1 + dfs(x + 1 , y , x + 1 % 10 == 0 ? s1 - 8 : s1 + 1 , s2 , m , n , k , flag) +
                    dfs(x , y + 1 , s1 , y + 1 % 10 == 0 ? s2 - 8 : s2 + 1 , m , n , k , flag));
        }
        if(x < 0 || x >= m || y < 0 || y >= n || k < s1 + s2 || flag[x][y]){
            if(x == 10 && y == 7){
            }
            return 0;
        }
        flag[x][y] = true;        // 就因为 x + 1 % 10 == 0 ，x + 1 没加括号，就WA
        return 1 + dfs(x + 1 , y , (x + 1) % 10 == 0 ? s1 - 8 : s1 + 1 , s2 , m , n , k , flag) +
                dfs(x , y + 1 , s1 , (y + 1) % 10 == 0 ? s2 - 8 : s2 + 1 , m , n , k , flag);
    }

}

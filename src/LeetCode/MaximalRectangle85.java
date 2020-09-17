package LeetCode;

/**
 * LeetCode 85
 * 题意：给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 示例:
 * 输入:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * 思路：每行叠加，看做是柱状图，就可以调用84题的代码
 *      不是单纯地统计1的个数，如果为0，就是0，否则，height[j]+1
 *      96.80% , 38.39%
 */
public class MaximalRectangle85 {
    public static void main(String[] args) {

    }
    public static int maximalRectangle(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] height = new int[matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length ; i ++){
            for(int j = 0; j < matrix[0].length ; j ++){
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            max = Math.max(max , large(height));
        }
        return max;
    }

    private static int large(int[] height) {
        int n = height.length;
        int[] rightmin = new int[n];
        rightmin[n - 1] = n;
        for(int i = n - 2;i >= 0;i --){
            int j = i + 1;
            while(j != n  && height[j] >= height[i]){
                j = rightmin[j];
            }
            rightmin[i] = j;
        }
        int[] leftmin = new int[n];
        leftmin[0] = -1;
        for(int i = 1;i < n; i ++){
            int j = i - 1;
            while(j != -1 && height[j] >= height[i]){
                j = leftmin[j];
            }
            leftmin[i] = j;
        }
        int ans = 0;
        for(int i = 0;i < n; i ++){
            ans = Math.max(ans, height[i] * (rightmin[i] - leftmin[i] - 1));
        }
        return ans;
    }
}

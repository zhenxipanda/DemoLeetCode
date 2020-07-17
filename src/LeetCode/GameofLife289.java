package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 289
 * 题意：
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * 示例：
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * 进阶：
 * 你可以使用原地算法解决本题吗？请注意，面板上所有格子需要同时被更新：
 * 你不能先更新某些格子，然后使用它们的更新后的值再更新其他格子。
 * 本题中，我们使用二维数组来表示面板。原则上，面板是无限的，
 * 但当活细胞侵占了面板边界时会造成问题。你将如何解决这些问题？
 * 思路：
 *     题目中要求要同时更新，并且本地更新，且数值都是0或1，
 *     一个巧妙思路就是把原数组的元素，左移一位，高位代表当前状态，
 *     低位代表下一秒要变的状态，这样就能利用当前状态去更新下一秒状态，
 *     做到同时更新，遍历完成后，获取低位状态作为数组元素
 *     100% , 11.11%
 */
public class GameofLife289 {
    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);
        for(int i = 0;i < board.length; i ++){
            System.out.println(Arrays.toString(board[i]));
        }
    }
    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return ;
        }
        int m = board.length;
        int n = board[0].length;
        // 对数组进行左移一位，一个位置既有当前状态（高位），又有下一秒要变得状态（低位）
        for(int i = 0;i < m; i ++){
            for(int j = 0;j < n ; j ++){
                board[i][j] = board[i][j] << 1;
            }
        }
        for(int i = 0;i < m; i ++){
            for(int j = 0;j < n; j ++){
                // 遍历四周8个位置，统计活细胞个数
                int count = dfs(board , i , j);
                if((board[i][j] >> 1) == 1){
                    // 继续存活，下一秒状态要为 1
                    if(count == 2 || count == 3){
                        board[i][j] = board[i][j] | 1;
                    }

                }
                else{
                    // 变为存活状态，下一秒状态要为 1
                    if(count == 3){
                        board[i][j] = board[i][j] | 1;
                    }
                }
            }
        }
        // 去掉高位信息，获取低位信息，即为下一秒的状态
        for(int i = 0;i < m; i ++){
            for(int j = 0;j < n; j ++){
                board[i][j] = board[i][j] & 1;
            }
        }
    }
    public static int dfs(int[][] board , int x , int y){
        int res = 0;
        int m = board.length - 1;
        int n = board[0].length - 1;
        // 二维遍历，8个位置，去掉下标越界位置
        for(int i = Math.max(0 , x - 1); i <= Math.min(m , x + 1); i ++){
            for(int j = Math.max(0 , y - 1) ; j <= Math.min(n , y + 1); j ++){
                // 如果为当前位置，忽略
                if(i == x && j == y){
                    continue;
                }
                else{
                    res += (board[i][j] >> 1);
                }
            }
        }
        // 返回该细胞四周8个位置中，活细胞的个数
        return res;
    }
}

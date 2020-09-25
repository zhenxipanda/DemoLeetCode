package LeetCode;

/**
 * LeetCode 130
 * 题意：给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 * 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。
 * 如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 思路：对于边界的'O'进行递归，将与其相邻的'O'都标记为'M',
 *      然后遍历二维数组，将'O'->'X','M'->'O'
 *      97.24% , 74.76%
 */
public class SurroundedRegions130 {
    public static void main(String[] args) {

    }
    private static int[] dx = {1,-1,0,0,};
    private static int[] dy = {0,0,1,-1};
    public static void solve(char[][] board) {
        if(board == null || board.length == 0 ||board[0].length == 0 ){
            return ;
        }
        int m = board.length ;
        int n = board[0].length ;
        for(int i = 0;i < m; i ++){
            for(int j = 0; j <  n; j ++){
                if(i == 0 || j == 0 || i == m - 1 ||  j == n - 1){
                    if(board[i][j] == 'O'){
                        preTransfer(board , i , j);
                    }
                }
            }
        }
        for(int i = 0;i < m; i ++){
            for(int j = 0;j < n ; j ++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public static void preTransfer(char[][] board , int x , int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O'){
            return ;
        }
        board[x][y] = 'M';
        for(int i = 0;i < dx.length ; i ++){
            preTransfer(board , x + dx[i] , y + dy[i]);
        }
        return ;
    }
}

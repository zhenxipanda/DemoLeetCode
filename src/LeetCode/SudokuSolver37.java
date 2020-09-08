package LeetCode;

/**
 * LeetCode 37
 * 题意：编写一个程序，通过已填充的空格来解决数独问题。
 * 一个数独的解法需遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * Note:
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 * 思路：这也太为难我胖虎了...
 *      计算机解数独和手工解数独一样，都是递归+回溯
 *      但是应用到实际场景就是比较难
 *
 */
public class SudokuSolver37 {
    public static void main(String[] args) {

    }
    public static void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9){
            return ;
        }
        boolean[][] row = new boolean[9][9],col = new boolean[9][9],block = new boolean[9][9];
        for(int i = 0;i < 9; i ++){
            for(int j = 0;j < 9; j ++){
                if(board[i][j] == '.'){
                    continue;
                }
                else{
//                    先把已有的元素进行标记
                    int num = board[i][j] - '1';
                    int k = 3 * (i / 3) + j / 3;
                    row[i][num] = col[j][num] = block[k][num] = true;
                }
            }
        }
        solverSudokuHelper(board , 0 , row , col , block);
    }
    public static boolean solverSudokuHelper(char[][] board , int n , boolean[][] row , boolean[][] col , boolean[][] block){
        if(n == 81){
            return true;
        }
        int i = n / 9 , j = n % 9;
        if(board[i][j] != '.'){
//            这个位置有元素，可以继续向下执行
            return solverSudokuHelper(board , n + 1 , row , col , block);
        }
//        第几块
        int k = 3 * (i / 3) + j / 3;
        for(int num = 0; num < 9; num ++){
//            已存在num
            if(row[i][num] || col[j][num] || block[k][num]){
                continue;
            }
            board[i][j] = (char)(num + '1');
            row[i][num] = col[j][num] = block[k][num] = true;
            if(solverSudokuHelper(board , n + 1 , row , col , block)){
                return true;
            }
            row[i][num] = col[j][num] = block[k][num] = false;
        }
        board[i][j] = '.';   //这一句要加，因为回溯的时候，先是赋值了，然后才判断n+1,如果为false，还要把之前的赋值给取消
        //	System.out.println("i : " + i + ", j:" + j + ". n : " + n + ", " + board[i][j]);
        return false;
    }
}

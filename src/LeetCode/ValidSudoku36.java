package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 36
 * 题意：判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 上图是一个部分填充的有效的数独。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 说明:
 * 一个有效的数独（部分已被填充）不一定是可解的。
 * 只需要根据以上规则，验证已经填入的数字是否有效即可。
 * 给定数独序列只包含数字 1-9 和字符 '.' 。
 * 给定数独永远是 9x9 形式的。
 * 思路，二维循环，i控制行，三个HashSet，代表行，列，快=块
 *      j控制列，判断[i][j]不为点，就可以去行，列，块中判断是否已存在，
 *      块，r = 3 * (i / 3) + j / 3
 *         c = 3 * (i % 3) + j % 3
 *      36.77% , 53.35%
 */
public class ValidSudoku36 {
    public static void main(String[] args) {

    }
    public static boolean isValidSudoku(char[][] board) {
        for(int i = 0;i < board.length; i ++){
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> block = new HashSet<>();
            for(int j = 0;j < board[0].length; j ++){
                if(board[i][j] != '.'){
                    if(!row.contains(board[i][j])){
                        row.add(board[i][j]);
                    }
                    else{
                        //   System.out.println("row : this is returned");
                        return false;
                    }
                }
                if(board[j][i] != '.'){
                    if(!col.contains(board[j][i])){
                        col.add(board[j][i]);
                    }
                    else{
                        //     System.out.println("col : this is returned");
                        return false;
                    }
                }
                int r = 3 * (i / 3) + j / 3;
                int c = 3 * (i % 3) + j % 3;
                if(board[r][c] != '.'){
                    if(!block.contains(board[r][c])){
                        block.add(board[r][c]);
                    }
                    else{
                        //     System.out.println("block :this is returned");
                        return false;
                    }
                }
            }

        }
        return true;
    }
}

package LeetCode;

/**
 * LeetCode 79
 * 题意：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * 思路：特别注意，两者有一者为空 或 长度为0，都应该返回 false
 *      遍历二维矩阵，找到与word首字母相同的，然后递归
 *      dfs(),先判断边界，以及是否相等，还有是否访问过了
 *      递归结束条件 index == word.length() - 1 ,return true
 *      标记访问过 ,'#'，向四周走，去掉标记，返回四周遍历结果
 *      74.71% ， 29.83%
 */
public class WordSearch79 {
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','D'},{'E','F','G','H'},{'I','G','K','L'}};
        String word = "GHLK";
        boolean res = exist(board , word);
        System.out.println(res);
    }
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0 || word == null){
            return false;
        }
        for(int i = 0;i < board.length; i ++){
            for(int j = 0;j < board[0].length ; j ++){
                if(board[i][j] == word.charAt(0) && (dfs(board , word , i , j , 0) == true)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(char[][] board , String word , int x , int y , int index){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index) || board[x][y] == '#'){
            return false;
        }
        if(index == word.length() - 1){
            return true;
        }
        char tmp = board[x][y];
        board[x][y] = '#';
        boolean ans = false;
        if(x - 1 >= 0){
            ans = ans || dfs(board , word , x - 1 , y , index + 1);   //因为||是短路判断
        }
        if(x + 1 < board.length){
            ans = ans || dfs(board , word , x + 1 , y , index + 1);
        }
        if(y - 1 >= 0){
            ans = ans || dfs(board , word , x , y - 1 , index + 1);
        }
        if(y + 1 < board[0].length){
            ans = ans || dfs(board , word , x , y + 1 , index + 1);
        }
        board[x][y] = tmp;
        return ans;
    }
}

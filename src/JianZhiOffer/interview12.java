package JianZhiOffer;

/**
 * 剑指offer 12
 * 题意：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。
 * 如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。
 * 例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，
 * 路径不能再次进入这个格子。
 * 示例 1：
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * 提示：
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 思路：与 leetcode 79 同
 *      回溯，同一条路径中已经走过的要标记，失败回溯的时候，要清除标记，
 *      设定递归结束条件，匹配到了最后一位，停止，
 *      标记此位置，对四个方向进行递归，有一者为true即停止（||的短路）
 *      清除标记，返回res递归结果
 *      97.76% ， 14.22%
 */
public class interview12 {
    public static void main(String[] args) {

    }
    public static boolean exist(char[][] board, String word){
        char[] ch = word.toCharArray();
        for(int i = 0 ; i < board.length ; i ++){
            for (int j = 0 ; j < board[0].length; j ++){
                if(ch[0] == board[i][j] && dfs(board , i , j , ch , 0)){
                    return  true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int x, int y, char[] ch, int index) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != ch[index]){
            return false;
        }
        if(index == ch.length - 1){
            return true;
        }
        board[x][y] = '#';
        boolean res = dfs(board , x + 1 , y , ch , index + 1) || dfs(board , x - 1 , y , ch , index+1)
                || dfs(board , x , y + 1 , ch , index + 1) || dfs(board , x , y - 1 , ch , index + 1);
        board[x][y] = ch[index];
        return res;
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 212
 * 题意：
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 示例:
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 提示:
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 * 思路：两种方法：暴力求解 和 前缀树
 *      暴力求解，遍历words数组，对每一个单词，都去board中搜寻，时间复杂度O(L*M*N),
 *      L:words的长度，M：board行数，N:board列数
 *      前缀树，参考208的TrieNode,对words的单词建立前缀树
 *      然后在二维矩阵board中寻找，看是否能在遇到数中的单词，如果能遇到，加到res中
 *      不能遇到，继续遍历其他位置元素
 *      92.01% , 20.00%s
 */
public class WordSearchii212 {
    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},
                          {'e','t','a','e'},
                          {'i','h','k','r'},
                          {'i','f','l','v'}};
        String[] words = {"oath" , "pea" , "eat" , "rain"};
        List<String> res = findWords1(board , words);
        System.out.println(res);
    }
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
            return res;
        }
        for(String word : words){
            for(int i = 0;i < board.length ; i ++){
                for(int j = 0;j < board[0].length ; j ++){
                    if(word.charAt(0) == board[i][j]){
                        System.out.println(word + ", " + i + ", " + j);
                        dfs(board , i , j , 0 , word , res);

                    }
                }
            }
        }
        return res;
    }
    public static void dfs(char[][] board , int x , int y , int index , String word , List<String> res){
        if(x == 1 && y == 3 && word.equals("eat")){
            for(int i = 0;i < board.length ; i ++){
                for(int j = 0;j < board[0].length ; j ++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || index >= word.length() || board[x][y] != word.charAt(index)){
            return ;
        }
        if(index == word.length() - 1 && !res.contains(word)){
            res.add(word);
        }
        char c = board[x][y];
        board[x][y] = '#';
        for(int i = 0;i < dx.length; i ++){
            dfs(board , x + dx[i] , y + dy[i] , index + 1 , word , res);
        }
        board[x][y] = c;
    }
    public static List<String> findWords1(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0){
            return res;
        }
        TrieNode root = buildTrie(words);
        for(int i = 0;i < board.length ; i ++){
            for(int j = 0;j < board[0].length ; j ++){
                dfs1(board , i , j , root , res);
            }
        }
        return res;
    }
    public static TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }
        return root;
    }
    public static void dfs1(char[][] board , int x , int y , TrieNode root,List<String> res){
        char c = board[x][y];
        if(c == '#' || root.children[c - 'a'] == null){
            return ;
        }
        root = root.children[c - 'a'];
        if(root.item != null && !res.contains(root.item)){
            res.add(root.item);
        }
        board[x][y] = '#';
        if(x - 1 >= 0){
            dfs1(board , x - 1 , y , root , res);
        }
        if(x + 1 < board.length){
            dfs1(board , x + 1 , y , root , res);
        }
        if(y - 1 >= 0){
            dfs1(board , x , y - 1 , root , res);
        }
        if(y + 1 < board[0].length){
            dfs1(board , x , y + 1 , root , res);
        }
        board[x][y] = c;
    }
    static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String item ;
        TrieNode(){

        }
    }
}

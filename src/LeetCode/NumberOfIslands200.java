package LeetCode;

/**
 * LeetCode 200
 * 题意：给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 * 输出: 1
 * 11000
 * 11000
 * 00100
 * 00011
 * 输出: 3
 * 解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
 * 思路：比较简单的递归，首先，确定递归入口，肯定是遇到了'1'，才会进入递归，并且计数ans ++
 *      进入递归之后，设定递归出口，也就是边界越界的，以及遍历到的字符不为'1'的，直接return ;
 *      为'1'的，将其置为'0',并且遍历当前位置的四周，遇到'1'就置为'0'，因为统计的是岛屿数，相连的'1'，是当做一个整体计算的
 *      97.395 , 6.25%
 */
public class NumberOfIslands200 {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','0','0'},
                         {'1','1','0','1','0'},
                         {'1','0','1','0','0'}};
        int res = numIslands(grid);
        System.out.println(res);
    }
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int ans = 0;
        for(int i = 0;i < grid.length ; i ++){
            for(int j = 0;j < grid[0].length ; j ++){
                if(grid[i][j] == '1'){
                    dfs(grid , i , j);
                    ans ++;
                }
            }
        }
        return ans ;
    }
    public static void dfs(char[][] grid , int x , int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1'){
            return ;
        }
        grid[x][y] = '0';
        for(int i = 0;i < dx.length ; i ++){
            dfs(grid , x + dx[i] , y + dy[i]);
        }
    }
}

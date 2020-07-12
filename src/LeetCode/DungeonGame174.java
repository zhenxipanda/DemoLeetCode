package LeetCode;

/**
 * LeetCode 174
 * 题意：一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。
 * 我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；
 * 其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 * 说明:
 * 骑士的健康点数没有上限。
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 * 思路：动态规划，从右下角到左上角，
 *      dp[i][j]含义是：到达dungeon[i][j]所需的最少健康点数，
 *      dp[i][j]不能为负数，因为如果不需点数，点数为0即可，即dp[i][j] = Math.min(0 , need)
 *      最后一列和最后一行的need，单独计算，因为骑士只能向下或向右走，
 *      除了最后一行和最后一列之外的位置，都是受正下方和正右方两个位置影响，两个位置中的最小值 - 当前房间的消耗值，
 *      与0 取最大，即为到达当前房间所需的最少健康点数，dp[0][0]的值是保证到达公主房间正好健康值为0，
 *      所以，最终的返回结果，还要在此基础上+1
 *      整体思路：先确定右下角，再根据右下角确定最后一列和最后一行，再确定余下的元素
 *      96.28% , 100.00%
 */
public class DungeonGame174 {
    public static void main(String[] args) {
        int[][] dungeon = {{-2,-3,3},{-2,-10,1},{10,30,-5}};
        int res = calculateMinimumHP(dungeon);
        System.out.println(res);
    }
    public static int calculateMinimumHP(int[][] dungeon){
        if(dungeon == null || dungeon.length == 0 || dungeon[0].length == 0){
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = Math.max(0 , -dungeon[row - 1][col - 1]);
        // 填充最后一列
        for(int i = row - 2;i >= 0;i --){
            int need = dp[i + 1][col - 1] - dungeon[i][col - 1];
            dp[i][col - 1] = Math.max(0 , need);
        }
        // 填充最后一行
        for(int j = col - 2;j >= 0 ; j --){
            int need = dp[row - 1][j + 1] - dungeon[row - 1][j];
            dp[row - 1][j] = Math.max(0 , need);
        }
        // 填充左上角剩余的 (row - 1) * (col - 1)
        for(int i = row - 2;i >= 0 ; i --){
            for(int j = col - 2;j >= 0; j --){
                int need = Math.min(dp[i + 1][j] , dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0 , need);
            }
        }
        return dp[0][0] + 1;
    }
}

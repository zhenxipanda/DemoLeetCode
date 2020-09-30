package LeetCode;
/**
 * LeetCode 149
 * 题意：给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * 示例 1:
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o  
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 * 思路：双层循环，外层一个map，记录与当前点构成的直线情况，斜率使用最大公约数表示，
 *      因为可能有重复点，所以需要考虑将重复点统计进去，
 *      40.53% , 45.07%
 */

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine149 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] points = {{1, 1}, {1, 1}, {2, 2}};
        int ans = maxPoints(points);
        System.out.println(ans);
    }

    public static int maxPoints(int[][] points) {
        if(points.length < 3){
            return points.length;
        }
        int res = 0;
        for(int i = 0 ; i < points.length ; i ++){
            int samePoint = 0;
            int max = 0;
            Map<String , Integer> map = new HashMap<>();
            for(int j = i + 1 ; j < points.length ; j ++){
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if(x == 0 && y == 0){
                    samePoint ++ ;
                    continue;
                }
                int d = gcd(x , y);
                String key = (x / d) + "#" + (y / d);
                map.put(key , map.getOrDefault(key , 0) + 1);
                max = Math.max(max , map.get(key));
            }
            res = Math.max(res , max + samePoint + 1);
        }
        return res;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);

    }
}

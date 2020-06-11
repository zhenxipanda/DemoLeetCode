package LeetCode;

import java.util.HashMap;
/* LeetCode 149
 * 思路：两层循环，探寻过每个点的直线，记录这些直线上最多点的数量
 *
 * */
public class MaxPointsOnALine149 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] points = {{1, 1}, {1, 1}, {2, 2}};
        int ans = maxPoints(points);
        System.out.println(ans);
    }

    public static int maxPoints(int[][] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int max = 0;
        int samePoint = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            samePoint = 0;
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                if (points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    samePoint++;
                    continue;
                }
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                int d = gcd(dx, dy);
                String temp = Integer.toString(dx / d) + "#" + Integer.toString(dy / d);
                if (map.get(temp) == null) {
                    map.put(temp, 2);
                } else {
                    int index = map.get(temp) + 1;
                    map.put(temp, index);
                }
            }
            for (int a : map.values()) {
                if (a + samePoint > max) {
                    max = a + samePoint;
                }
            }
        }
        return max == 0 ? samePoint + 1 : max;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);

    }
}

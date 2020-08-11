package LeetCode;

import java.util.HashMap;

/**
 * LeetCode 454
 * 题意：
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，
 * 使得 A[i] + B[j] + C[k] + D[l] = 0。
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
 * 所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * 例如:
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * 输出:
 * 2
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * 思路：因为四个数组长度相同，所以分为2组，分别计算2数组内部的交叉和，如计算A ,B 数组
 *      将和 ，出现的次数，放入map中存储，再计算C,D两个数组和，去map中寻找是否有互补数，
 *      有的话，即为匹配成功，res += 补数出现次数
 *      83.39% ， 81.91%
 */
public class _4sumii454 {
    public static void main(String[] args) {
        int[] A = {1,2};
        int[] B = {-2,-1};
        int[] C = {-1,2};
        int[] D = {0,2};
        int res = fourSumCount(A , B , C , D);
        System.out.println(res);
    }
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer , Integer> map1 = new HashMap<>();
        for(int i = 0; i < A.length; i ++){
            int a = A[i];
            for(int j = 0; j < B.length; j ++){
                int b = B[j];
                map1.put(a + b , map1.getOrDefault(a + b , 0 ) + 1);
            }
        }
        int res = 0;
        for(int i = 0;i < C.length ; i ++){
            int c = C[i];
            for(int j = 0; j < D.length ; j ++){
                int d = D[j];
                int sum = c + d;
                if(map1.containsKey(-1 * sum)){
                    res += map1.get(-1 * sum);
                }
            }
        }
        return res;
    }
}

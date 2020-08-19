package LeetCode;

import java.util.Arrays;

/**
 * LeetCode 739
 * 题意：
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 * 思路：实际上是统计右侧第一个大于自身的元素下标，然后相减就是间距
 *      注意：两个相邻元素且相等，也应该去向后寻找第一个大于自身的，遇到等于自身不能停止
 *      98.05% , 27.78%
 */
public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] T = {24,25,26,26,20,27};
        int[] res = dailyTemperatures(T);
        System.out.println(Arrays.toString(res));
    }
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = -1;
        for(int i = T.length - 2; i >= 0; i --){
            int j = i + 1;
            while(j > 0 && T[i] >= T[j]){  // 加上=号，遇到等于自身的继续向后寻找
                j = res[j];
            }
            res[i] = j;
        }
        //   System.out.println(Arrays.toString(res));
        for(int i = 0;i < T.length ; i ++){
            if(res[i] == -1){
                res[i] = 0;
            }
            else{
                res[i] = res[i] - i;
            }
        }
        return res;
    }
}
